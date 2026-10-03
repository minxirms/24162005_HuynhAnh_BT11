package vn.minxi.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet(urlPatterns = { "/home" })
public class HomeController_24162005 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Chuyển sang giao diện trang chủ dành cho User
		req.getRequestDispatcher("/WEB-INF/views/user/home.jsp").forward(req, resp);
	}
}