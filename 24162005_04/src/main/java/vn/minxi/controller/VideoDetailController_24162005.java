package vn.minxi.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import vn.minxi.dao.impl.VideoDaoImpl_24162005;
import vn.minxi.entity.Video_24162005;

@WebServlet(urlPatterns = { "/video/detail" })
public class VideoDetailController_24162005 extends HttpServlet {
	private VideoDaoImpl_24162005 videoDao = new VideoDaoImpl_24162005();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String videoId = req.getParameter("id");
		Video_24162005 video = videoDao.findById(videoId);

		req.setAttribute("video", video);
		req.getRequestDispatcher("/WEB-INF/views/user/video-detail.jsp").forward(req, resp);
	}
}