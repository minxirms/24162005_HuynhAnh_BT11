<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang Chủ User</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body class="d-flex flex-column min-vh-100">

	<!-- Nhúng Header -->
	<jsp:include page="/WEB-INF/views/decorators/header.jsp" />

	<!-- Nội dung Trang chủ User -->
	<div class="container my-4 flex-grow-1">
		<h2>Danh Sách Video Nổi Bật</h2>
		<!-- Nơi hiển thị các video -->
	</div>

	<!-- Nhúng Footer -->
	<jsp:include page="/WEB-INF/views/decorators/footer.jsp" />

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>