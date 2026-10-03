package vn.minxi.controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import vn.minxi.config.JPAConfig_24162005;
import vn.minxi.entity.Order_24162005;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = { "/order/history" })
public class OrderHistoryController_24162005 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String status = req.getParameter("status");
		if (status == null || status.trim().isEmpty()) {
			status = "ALL";
		}

		EntityManager em = JPAConfig_24162005.getEntityManager();
		try {
			String jpql;
			TypedQuery<Order_24162005> query;

			if ("ALL".equalsIgnoreCase(status)) {
				jpql = "SELECT o FROM Order_24162005 o ORDER BY o.createdDate DESC";
				query = em.createQuery(jpql, Order_24162005.class);
			} else {
				jpql = "SELECT o FROM Order_24162005 o WHERE o.status = :status ORDER BY o.createdDate DESC";
				query = em.createQuery(jpql, Order_24162005.class);
				query.setParameter("status", status);
			}

			List<Order_24162005> orders = query.getResultList();

			req.setAttribute("orders", orders);
			req.setAttribute("selectedStatus", status);
			req.getRequestDispatcher("/WEB-INF/views/user/order-history.jsp").forward(req, resp);
		} finally {
			em.close();
		}
	}
}