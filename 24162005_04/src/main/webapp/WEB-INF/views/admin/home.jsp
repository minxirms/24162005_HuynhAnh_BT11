<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang Quản Trị</title>
<!-- Nhúng Bootstrap 5 để giao diện đẹp chuẩn -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body class="d-flex flex-column min-vh-100">

	<!-- 1. Nhúng Header chứa Menu -->
	<jsp:include page="/WEB-INF/views/decorators/header.jsp" />

	<!-- 2. Nội dung chính của trang Admin -->
	<div class="container my-4 flex-grow-1">
		<div class="alert alert-success shadow-sm" role="alert">
			<h3 class="alert-heading fw-bold">Chào mừng Admin đến với trang
				quản trị hệ thống!</h3>
			<hr>
			<p class="mb-0">Bạn có thể truy cập danh sách người dùng, quản lý
				video và cấu hình hệ thống từ thanh điều hướng.</p>
		</div>
	</div>

	<!-- 3. Nhúng Footer chứa Họ tên, MSSV, Mã đề -->
	<jsp:include page="/WEB-INF/views/decorators/footer.jsp" />

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>