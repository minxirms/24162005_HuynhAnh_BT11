package vn.minxi.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import vn.minxi.dao.impl.VideoDaoImpl_24162005;
import vn.minxi.model.CartItem;
import vn.minxi.entity.Video_24162005;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = { "/cart", "/cart/add", "/cart/update", "/cart/delete" })
public class CartController_24162005 extends HttpServlet {
	private VideoDaoImpl_24162005 videoDao = new VideoDaoImpl_24162005();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		HttpSession session = req.getSession();
		Map<String, CartItem> cart = (Map<String, CartItem>) session.getAttribute("cart");
		if (cart == null)
			cart = new HashMap<>();

		if ("/cart/add".equals(path)) {
			String videoId = req.getParameter("id");
			Video_24162005 video = videoDao.findById(videoId);
			if (video != null) {
				if (cart.containsKey(videoId)) {
					CartItem item = cart.get(videoId);
					if (item.getQuantity() < 99) { // Giới hạn tối đa 99
						item.setQuantity(item.getQuantity() + 1);
					}
				} else {
					cart.put(videoId, new CartItem(video, 1));
				}
			}
			session.setAttribute("cart", cart);
			resp.sendRedirect(req.getContextPath() + "/cart");
			return;
		} else if ("/cart/delete".equals(path)) {
			String videoId = req.getParameter("id");
			cart.remove(videoId);
			session.setAttribute("cart", cart);
			resp.sendRedirect(req.getContextPath() + "/cart");
			return;
		}

		req.getRequestDispatcher("/WEB-INF/views/user/cart.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		HttpSession session = req.getSession();
		Map<String, CartItem> cart = (Map<String, CartItem>) session.getAttribute("cart");

		if ("/cart/update".equals(path) && cart != null) {
			String videoId = req.getParameter("id");
			try {
				int quantity = Integer.parseInt(req.getParameter("quantity"));
				if (quantity <= 0) {
					cart.remove(videoId);
				} else {
					quantity = Math.min(quantity, 99); // Giới hạn tối đa 99
					if (cart.containsKey(videoId)) {
						cart.get(videoId).setQuantity(quantity);
					}
				}
			} catch (NumberFormatException e) {
				// Ignore invalid numbers
			}
			session.setAttribute("cart", cart);
		}
		resp.sendRedirect(req.getContextPath() + "/cart");
	}
}