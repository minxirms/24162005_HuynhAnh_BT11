package vn.minxi.controller;

import java.io.IOException;
import java.util.Random;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import vn.minxi.dao.impl.UserDaoImpl_24162005;
import vn.minxi.entity.User_24162005;
import vn.minxi.service.EmailService_24162005;

@WebServlet(urlPatterns = { "/register", "/verify-otp" })
public class RegisterController_24162005 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoImpl_24162005 userDao = new UserDaoImpl_24162005();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		if (path.equals("/register")) {
			req.getRequestDispatcher("/WEB-INF/views/user/register.jsp").forward(req, resp);
		} else if (path.equals("/verify-otp")) {
			req.getRequestDispatcher("/WEB-INF/views/user/verify-otp.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String path = req.getServletPath();
		HttpSession session = req.getSession();

		if (path.equals("/register")) {
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			String fullname = req.getParameter("fullname");
			String email = req.getParameter("email");
			String phone = req.getParameter("phone");

			System.out.println("=== THÔNG TIN ĐĂNG KÝ ===");
			System.out.println("Username: " + username);
			System.out.println("Email nhận: " + email);

			// Kiểm tra các trường dữ liệu bắt buộc
			if (email == null || email.trim().isEmpty()) {
				req.setAttribute("error", "Vui lòng nhập địa chỉ Email!");
				req.getRequestDispatcher("/WEB-INF/views/user/register.jsp").forward(req, resp);
				return;
			}

			// 1. Kiểm tra Username đã tồn tại trong CSDL chưa
			User_24162005 existUser = userDao.findByUsername(username);
			if (existUser != null) {
				req.setAttribute("error", "Tên đăng nhập đã tồn tại, vui lòng chọn tên khác!");
				req.getRequestDispatcher("/WEB-INF/views/user/register.jsp").forward(req, resp);
				return;
			}

			// 2. Tạo mã OTP 6 chữ số
			String otp = String.format("%06d", new Random().nextInt(900000) + 100000);

			// 3. Khởi tạo đối tượng User tạm thời
			User_24162005 tempUser = new User_24162005();
			tempUser.setUsername(username);
			tempUser.setPassword(password);
			tempUser.setFullname(fullname);
			tempUser.setEmail(email);
			tempUser.setPhone(phone);
			tempUser.setAdmin(false);
			tempUser.setActive(true);

			// 4. Lưu OTP và User tạm thời vào Session
			session.setAttribute("otpCode", otp);
			session.setAttribute("tempUser", tempUser);

			// 5. Gửi Mail bất đồng bộ (Thread riêng) tránh block Servlet
			new Thread(() -> {
				try {
					boolean isSent = EmailService_24162005.sendOTP(email, otp);
					if (isSent) {
						System.out.println("[EMAIL SUCCESS] Đã gửi OTP thành công tới: " + email);
					} else {
						System.err.println("[EMAIL ERROR] Không thể gửi OTP tới: " + email);
					}
				} catch (Exception e) {
					System.err.println("[EMAIL EXCEPTION] Lỗi tiến trình gửi mail:");
					e.printStackTrace();
				}
			}).start();

			// 6. Chuyển hướng ngay sang trang xác nhận OTP
			resp.sendRedirect(req.getContextPath() + "/verify-otp");

		} else if (path.equals("/verify-otp")) {
			String inputOtp = req.getParameter("otp");
			String sessionOtp = (String) session.getAttribute("otpCode");
			User_24162005 tempUser = (User_24162005) session.getAttribute("tempUser");

			if (sessionOtp != null && sessionOtp.equals(inputOtp) && tempUser != null) {
				// OTP hợp lệ -> Lưu User vào CSDL
				userDao.insert(tempUser);

				// Dọn dẹp session OTP và TempUser
				session.removeAttribute("otpCode");
				session.removeAttribute("tempUser");

				// Chuyển hướng về trang đăng nhập
				session.setAttribute("message", "Xác thực OTP thành công! Bạn có thể đăng nhập ngay.");
				resp.sendRedirect(req.getContextPath() + "/login");
			} else {
				req.setAttribute("error", "Mã OTP không chính xác, vui lòng thử lại!");
				req.getRequestDispatcher("/WEB-INF/views/user/verify-otp.jsp").forward(req, resp);
			}
		}
	}
}