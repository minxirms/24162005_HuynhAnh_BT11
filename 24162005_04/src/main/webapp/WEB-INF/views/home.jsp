<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<title>Trang Chủ</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container">
			<a class="navbar-brand"
				href="${pageContext.request.contextPath}/home">MY SYSTEM</a>
			<div class="d-flex">
				<c:choose>
					<c:when test="${not empty sessionScope.account}">
						<span class="navbar-text me-3 text-white">Xin chào, <strong>${sessionScope.account.fullname}</strong></span>
						<a href="${pageContext.request.contextPath}/logout"
							class="btn btn-outline-light btn-sm">Đăng xuất</a>
					</c:when>
					<c:otherwise>
						<a href="${pageContext.request.contextPath}/login"
							class="btn btn-outline-light me-2 btn-sm">Đăng nhập</a>
						<a href="${pageContext.request.contextPath}/register"
							class="btn btn-primary btn-sm">Đăng ký</a>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</nav>

	<div class="container mt-5">
		<div class="p-5 mb-4 bg-light rounded-3 text-center">
			<h1 class="display-5 fw-bold">CHÀO MỪNG ĐẾN VỚI HỆ THỐNG</h1>
			<p class="fs-4">Ứng dụng Servlet - JPA Hibernate hoàn chỉnh.</p>
		</div>
	</div>
</body>
</html>