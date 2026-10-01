package vn.minxi.controller;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import vn.minxi.dao.impl.VideoDaoImpl_24162005;
import vn.minxi.entity.Video_24162005;

@WebServlet(urlPatterns = { "/category/videos" })
public class CategoryVideoController_24162005 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VideoDaoImpl_24162005 videoDao = new VideoDaoImpl_24162005();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		// 1. Kiểm tra tham số categoryId an toàn
		int categoryId = 1; // Mặc định là category 1 nếu không truyền tham số
		String idParam = req.getParameter("id");
		if (idParam != null && !idParam.isEmpty()) {
			try {
				categoryId = Integer.parseInt(idParam);
			} catch (NumberFormatException e) {
				categoryId = 1;
			}
		}

		// 2. Kiểm tra tham số page an toàn
		int page = 1;
		String pageParam = req.getParameter("page");
		if (pageParam != null && !pageParam.isEmpty()) {
			try {
				page = Integer.parseInt(pageParam);
			} catch (NumberFormatException e) {
				page = 1;
			}
		}

		// 3. Đếm tổng video (Câu 6)
		int totalVideos = videoDao.countVideosByCategory(categoryId);

		// 4. Lấy danh sách phân trang (Câu 5)
		List<Video_24162005> videos = videoDao.getVideosByCategoryPaging(categoryId, page);
		int endPage = (int) Math.ceil((double) totalVideos / 3);

		// Đảm bảo endPage tối thiểu là 1 nếu không có video nào
		if (endPage == 0)
			endPage = 1;

		req.setAttribute("totalVideos", totalVideos);
		req.setAttribute("videos", videos);
		req.setAttribute("endPage", endPage);
		req.setAttribute("currentPage", page);
		req.setAttribute("categoryId", categoryId);

		req.getRequestDispatcher("/WEB-INF/views/user/category-videos.jsp").forward(req, resp);
	}
}