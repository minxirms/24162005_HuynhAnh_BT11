package vn.minxi.controller;

import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import vn.minxi.config.JPAConfig_24162005;
import vn.minxi.entity.Order_24162005;
import vn.minxi.entity.OrderItem_24162005;
import vn.minxi.model.CartItem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = { "/checkout" })
public class CheckoutController_24162005 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/user/checkout.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		Map<String, CartItem> cart = (Map<String, CartItem>) session.getAttribute("cart");

		if (cart == null || cart.isEmpty()) {
			resp.sendRedirect(req.getContextPath() + "/cart");
			return;
		}

		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		String address = req.getParameter("address");

		EntityManager em = JPAConfig_24162005.getEntityManager();
		try {
			em.getTransaction().begin();

			Order_24162005 order = new Order_24162005();
			order.setCustomerName(name);
			order.setPhone(phone);
			order.setAddress(address);
			order.setPaymentMethod("COD");
			order.setStatus("DON_HANG_MOI"); // Trạng thái ban đầu
			order.setCreatedDate(new Date());

			double total = 0;
			List<OrderItem_24162005> items = new ArrayList<>();

			for (CartItem ci : cart.values()) {
				OrderItem_24162005 item = new OrderItem_24162005();
				item.setOrder(order);
				item.setVideo(ci.getVideo());
				item.setQuantity(ci.getQuantity());
				item.setPrice(50000); // Giá cố định hoặc lấy từ thuộc tính
				total += ci.getQuantity() * 50000;
				items.add(item);
			}

			order.setTotalAmount(total);
			order.setOrderItems(items);

			em.persist(order);
			em.getTransaction().commit();

			session.removeAttribute("cart"); // Xóa giỏ hàng sau khi đặt thành công
			resp.sendRedirect(req.getContextPath() + "/order/history");
		} catch (Exception e) {
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			e.printStackTrace();
			resp.sendRedirect(req.getContextPath() + "/checkout?error=1");
		} finally {
			em.close();
		}
	}
}