package vn.minxi.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet(urlPatterns = { "/logout" })
public class LogoutController_24162005 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session != null) {
			session.removeAttribute("account");
			session.invalidate(); // Hủy toàn bộ Session
		}
		// Chuyển hướng về lại trang đăng nhập
		resp.sendRedirect(req.getContextPath() + "/login");
	}
}