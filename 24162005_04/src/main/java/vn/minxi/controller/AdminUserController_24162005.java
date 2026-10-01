package vn.minxi.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import vn.minxi.entity.User_24162005;
import vn.minxi.service.impl.UserServiceImpl_24162005;

@WebServlet(urlPatterns = { "/admin/users", "/admin/user/add", "/admin/user/edit", "/admin/user/delete" })
public class AdminUserController_24162005 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserServiceImpl_24162005 userService = new UserServiceImpl_24162005();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();

		if (path.equals("/admin/users")) {
			int page = 1;
			int pageSize = 6; 

			if (req.getParameter("page") != null) {
				try {
					page = Integer.parseInt(req.getParameter("page"));
				} catch (Exception e) {
					page = 1;
				}
			}

			int totalUsers = userService.count();
			int totalPages = (int) Math.ceil((double) totalUsers / pageSize);

			List<User_24162005> userList = userService.findAll(page, pageSize);

			req.setAttribute("userList", userList);
			req.setAttribute("currentPage", page);
			req.setAttribute("totalPages", totalPages);

			req.getRequestDispatcher("/WEB-INF/views/admin/user-list.jsp").forward(req, resp);

		} else if (path.equals("/admin/user/add")) {
			req.getRequestDispatcher("/WEB-INF/views/admin/user-form.jsp").forward(req, resp);

		} else if (path.equals("/admin/user/edit")) {
			String username = req.getParameter("username");
			User_24162005 user = userService.findByUsername(username);
			req.setAttribute("user", user);
			req.getRequestDispatcher("/WEB-INF/views/admin/user-form.jsp").forward(req, resp);

		} else if (path.equals("/admin/user/delete")) {
			String username = req.getParameter("username");
			if (username != null) {
				userService.delete(username);
			}
			resp.sendRedirect(req.getContextPath() + "/admin/users");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String username = req.getParameter("username");
		String fullname = req.getParameter("fullname");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		boolean isAdmin = req.getParameter("admin") != null;
		boolean isActive = req.getParameter("active") != null;

		User_24162005 existingUser = userService.findByUsername(username);

		if (existingUser == null) {
			// Thêm mới User
			User_24162005 newUser = new User_24162005();
			newUser.setUsername(username);
			newUser.setPassword(req.getParameter("password"));
			newUser.setFullname(fullname);
			newUser.setEmail(email);
			newUser.setPhone(phone);
			newUser.setAdmin(isAdmin);
			newUser.setActive(isActive);

			userService.insert(newUser);
		} else {
			// Cập nhật User
			existingUser.setFullname(fullname);
			existingUser.setEmail(email);
			existingUser.setPhone(phone);
			existingUser.setAdmin(isAdmin);
			existingUser.setActive(isActive);

			// Nếu có nhập mật khẩu mới thì đổi, không thì giữ nguyên
			String newPassword = req.getParameter("password");
			if (newPassword != null && !newPassword.trim().isEmpty()) {
				existingUser.setPassword(newPassword);
			}

			userService.update(existingUser);
		}

		resp.sendRedirect(req.getContextPath() + "/admin/users");
	}
}