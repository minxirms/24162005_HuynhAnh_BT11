<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark mb-4">
	<div class="container">
		<a class="navbar-brand fw-bold" href="<c:url value='/home'/>">HỆ
			THỐNG VIDEO</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarNav">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<!-- 1. Trang Chủ -->
				<li class="nav-item"><a class="nav-link active"
					href="<c:url value='/home'/>">Trang Chủ</a></li>

				<!-- 2. Sản phẩm -->
				<li class="nav-item"><a class="nav-link"
					href="<c:url value='/category/videos?id=1'/>">Sản phẩm</a></li>

				<!-- 3. Trang quản trị (Chỉ Admin mới thấy) -->
				<c:if
					test="${not empty sessionScope.account && sessionScope.account.admin}">
					<li class="nav-item"><a class="nav-link text-warning fw-bold"
						href="<c:url value='/admin/home'/>">Trang quản trị</a></li>
				</c:if>
			</ul>

			<!-- 4. Đăng nhập / Đăng xuất -->
			<ul class="navbar-nav">
				<c:choose>
					<c:when test="${empty sessionScope.account}">
						<li class="nav-item"><a class="btn btn-outline-light me-2"
							href="<c:url value='/login'/>">Đăng nhập</a></li>
					</c:when>
					<c:otherwise>
						<li class="nav-item"><span
							class="navbar-text text-white me-2">Xin chào, <b>${sessionScope.account.fullname}</b></span>
						</li>
						<li class="nav-item"><a class="btn btn-danger btn-sm"
							href="<c:url value='/logout'/>">Đăng xuất</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</div>
</nav>