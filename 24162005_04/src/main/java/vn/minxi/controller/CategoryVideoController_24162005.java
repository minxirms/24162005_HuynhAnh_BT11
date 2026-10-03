package vn.minxi.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import vn.minxi.dao.IVideoDao_24162005;
import vn.minxi.dao.impl.VideoDaoImpl_24162005;
import vn.minxi.entity.Category_24162005;
import vn.minxi.entity.Video_24162005;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = { "/category/videos" })
public class CategoryVideoController_24162005 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IVideoDao_24162005 videoDao = new VideoDaoImpl_24162005();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int categoryId = 1;
		try {
			if (req.getParameter("id") != null) {
				categoryId = Integer.parseInt(req.getParameter("id"));
			}
		} catch (NumberFormatException e) {
			categoryId = 1;
		}

		int page = 1;
		if (req.getParameter("page") != null) {
			try {
				page = Integer.parseInt(req.getParameter("page"));
				if (page < 1)
					page = 1;
			} catch (NumberFormatException e) {
				page = 1;
			}
		}

		int pageSize = 3;

		Category_24162005 category = videoDao.findCategoryById(categoryId);
		int totalVideos = videoDao.countVideosByCategory(categoryId);

		int totalPages = (int) Math.ceil((double) totalVideos / pageSize);
		if (totalPages < 1)
			totalPages = 1;
		if (page > totalPages)
			page = totalPages;

		List<Video_24162005> videos = videoDao.getVideosByCategoryPaging(categoryId, page, pageSize);

		req.setAttribute("category", category);
		req.setAttribute("videos", videos);
		req.setAttribute("totalVideos", totalVideos);
		req.setAttribute("currentPage", page);
		req.setAttribute("totalPages", totalPages);
		req.setAttribute("categoryId", categoryId);

		req.getRequestDispatcher("/WEB-INF/views/user/category-video.jsp").forward(req, resp);
	}
}