package vn.minxi.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import vn.minxi.entity.User_24162005;

@WebServlet(urlPatterns = { "/admin/home" })
public class AdminHomeController_24162005 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User_24162005 account = (User_24162005) session.getAttribute("account");

		// Nếu chưa đăng nhập hoặc không phải Admin thì đẩy về Login
		if (account == null || !Boolean.TRUE.equals(account.getAdmin())) {
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}

		// Chuyển sang giao diện Admin
		req.getRequestDispatcher("/WEB-INF/views/admin/home.jsp").forward(req, resp);
	}
}