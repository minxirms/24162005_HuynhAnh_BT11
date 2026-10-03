package vn.minxi.config;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.*;

import vn.minxi.entity.User_24162005;

@WebFilter(urlPatterns = { "/admin/*" })
public class AdminFilter_24162005 implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession(false);

		User_24162005 account = (session != null) ? (User_24162005) session.getAttribute("account") : null;

		// Kiểm tra: Chưa đăng nhập HOẶC không phải là Admin
		if (account == null || !Boolean.TRUE.equals(account.getAdmin())) {
			// Chuyển hướng về trang login
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}

		// Hợp lệ -> Cho phép tiếp tục truy cập
		chain.doFilter(request, response);
	}
}