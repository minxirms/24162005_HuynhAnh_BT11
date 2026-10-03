<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Video theo Danh mục</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container mt-4">

		<!-- Header & Giỏ hàng -->
		<div class="d-flex justify-content-between align-items-center mb-4">
			<h2 class="fw-bold m-0">${category.categoryName}
				(${totalVideos})</h2>
			<a href="${pageContext.request.contextPath}/cart"
				class="btn btn-outline-primary"> 🛒 Giỏ hàng </a>
		</div>

		<!-- Danh sách Video dạng lưới -->
		<div class="row">
			<c:choose>
				<c:when test="${not empty videos}">
					<c:forEach var="v" items="${videos}">
						<div class="col-md-4 mb-4">
							<div class="card h-100 shadow-sm">
								<img src="${v.poster}" class="card-img-top" alt="${v.title}"
									style="height: 200px; object-fit: cover;">
								<div class="card-body">
									<p class="card-text fw-bold mb-1">Tiêu đề: ${v.title}</p>
									<p class="card-text mb-1">Mã video: ${v.videoId}</p>
									<p class="card-text mb-1">Category name:
										${v.category.categoryName}</p>
									<p class="card-text mb-2">View: ${v.views}</p>

									<div class="mb-3">
										<span class="badge bg-primary">Share(${v.shares != null ? v.shares.size() : 0})</span>
										<span class="badge bg-success">Like(${v.favorites != null ? v.favorites.size() : 0})</span>
									</div>

									<div class="d-flex justify-content-between align-items-center">
										<a
											href="${pageContext.request.contextPath}/video/detail?id=${v.videoId}"
											class="btn btn-outline-danger btn-sm">Xem chi tiết</a> <a
											href="${pageContext.request.contextPath}/cart/add?id=${v.videoId}"
											class="btn btn-primary btn-sm">Thêm vào giỏ</a>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<div class="col-12">
						<div class="alert alert-warning">Không có video nào trong
							danh mục này!</div>
					</div>
				</c:otherwise>
			</c:choose>
		</div>

		<!-- Phân trang: << 1 2 3 4 5 >> -->
		<c:if test="${totalPages > 1}">
			<nav class="mt-4">
				<ul class="pagination justify-content-center">
					<li class="page-item ${currentPage <= 1 ? 'disabled' : ''}"><a
						class="page-link"
						href="${pageContext.request.contextPath}/category/videos?id=${categoryId}&page=${currentPage - 1}">&lt;&lt;</a>
					</li>

					<c:forEach var="i" begin="1" end="${totalPages}">
						<li class="page-item ${i == currentPage ? 'active' : ''}"><a
							class="page-link"
							href="${pageContext.request.contextPath}/category/videos?id=${categoryId}&page=${i}">${i}</a>
						</li>
					</c:forEach>

					<li
						class="page-item ${currentPage >= totalPages ? 'disabled' : ''}">
						<a class="page-link"
						href="${pageContext.request.contextPath}/category/videos?id=${categoryId}&page=${currentPage + 1}">&gt;&gt;</a>
					</li>
				</ul>
			</nav>
		</c:if>

	</div>
</body>
</html>