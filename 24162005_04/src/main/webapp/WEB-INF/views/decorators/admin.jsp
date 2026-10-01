<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADMIN - <sitemesh:write property='title' /></title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>

	<!-- ADMIN HEADER -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-danger">
		<div class="container">
			<a class="navbar-brand fw-bold" href="<c:url value='/admin/home'/>">HỆ
				THỐNG QUẢN TRỊ</a>
			<div class="collapse navbar-collapse">
				<ul class="navbar-nav me-auto">
					<li class="nav-item"><a class="nav-link text-white"
						href="<c:url value='/admin/home'/>">Trang quản trị</a></li>
					<li class="nav-item"><a class="nav-link text-white"
						href="<c:url value='/home'/>">Về trang chủ User</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<!-- NỘI DUNG TRANG ADMIN -->
	<div class="container my-4" style="min-height: 400px;">
		<sitemesh:write property='body' />
	</div>

	<!-- FOOTER -->
	<footer class="bg-danger text-white text-center py-3">
		<p class="mb-0">Họ tên: [Tên của bạn] | MSSV: 24162005 | Mã đề: 04</p>
	</footer>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>