package vn.minxi.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import vn.minxi.dao.impl.UserDaoImpl_24162005;
import vn.minxi.entity.User_24162005;

@WebServlet(urlPatterns = { "/login" })
public class LoginController_24162005 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Chuyển tới giao diện login
		req.getRequestDispatcher("/WEB-INF/views/user/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String username = req.getParameter("username");
		String password = req.getParameter("password");

		// Gọi DAO kiểm tra tài khoản
		UserDaoImpl_24162005 userDao = new UserDaoImpl_24162005();
		User_24162005 user = userDao.findByUsername(username);

		// 1. Kiểm tra username & password
		if (user != null && password != null && password.equals(user.getPassword())) {
			
			// 2. Kiểm tra xem tài khoản đã kích hoạt (Active) hay chưa
			if (Boolean.FALSE.equals(user.getActive())) {
				req.setAttribute("alert", "Tài khoản của bạn chưa được kích hoạt qua OTP!");
				req.getRequestDispatcher("/WEB-INF/views/user/login.jsp").forward(req, resp);
				return;
			}

			// Đăng nhập thành công -> Lưu thông tin vào Session
			HttpSession session = req.getSession();
			session.setAttribute("account", user);

			// 3. Kiểm tra quyền Admin
			if (Boolean.TRUE.equals(user.getAdmin())) {
				// Nếu là Admin -> Về trang Quản trị
				resp.sendRedirect(req.getContextPath() + "/admin/home");
			} else {
				// Nếu là User thường -> Về trang Chủ
				resp.sendRedirect(req.getContextPath() + "/home");
			}
		} else {
			// Đăng nhập thất bại
			req.setAttribute("alert", "Tên đăng nhập hoặc mật khẩu không chính xác!");
			req.getRequestDispatcher("/WEB-INF/views/user/login.jsp").forward(req, resp);
		}
	}
}