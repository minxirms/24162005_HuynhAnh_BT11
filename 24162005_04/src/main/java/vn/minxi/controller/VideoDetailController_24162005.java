package vn.minxi.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import vn.minxi.dao.IVideoDao_24162005;
import vn.minxi.dao.impl.VideoDaoImpl_24162005;
import vn.minxi.entity.Video_24162005;

import java.io.IOException;

@WebServlet(urlPatterns = { "/video/detail" })
public class VideoDetailController_24162005 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IVideoDao_24162005 videoDao = new VideoDaoImpl_24162005();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String videoId = req.getParameter("id");
		Video_24162005 video = videoDao.findById(videoId);

		req.setAttribute("video", video);
		req.getRequestDispatcher("/WEB-INF/views/user/video-detail.jsp").forward(req, resp);
	}
}