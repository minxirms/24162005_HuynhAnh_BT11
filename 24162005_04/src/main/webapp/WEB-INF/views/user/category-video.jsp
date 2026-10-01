<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<div class="container my-4">
	<!-- Tiêu đề và Đếm số lượng video (Câu 6) -->
	<h3 class="fw-bold mb-4">Category Name (${totalVideos})</h3>

	<!-- Danh sách Video 3 cột / hàng (Câu 5) -->
	<div class="row">
		<c:forEach items="${videos}" var="v">
			<div class="col-md-4 mb-4">
				<div class="card h-100 shadow-sm">
					<img src="${pageContext.request.contextPath}/${v.poster}"
						class="card-img-top" style="height: 200px; object-fit: cover;"
						alt="${v.title}">
					<div class="card-body">
						<h5 class="card-title text-truncate">Tiêu đề: ${v.title}</h5>
						<p class="card-text mb-1">Mã video: ${v.videoId}</p>
						<p class="card-text mb-1">Category name:
							${v.category.categoryName}</p>
						<p class="card-text mb-1">View: ${v.views}</p>
						<p class="card-text">
							<span class="badge bg-secondary me-1">Share(${v.shares.size()})</span>
							<span class="badge bg-danger">Like(${v.favorites.size()})</span>
						</p>
						<a href="<c:url value='/video/detail?id=${v.videoId}'/>"
							class="btn btn-sm btn-primary w-100 mt-2">Xem chi tiết</a>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>

	<!-- Thanh phân trang: << 1 2 3 4 5 >> -->
	<nav class="mt-4">
		<ul class="pagination justify-content-center">
			<!-- Nút Previous << -->
			<li class="page-item ${currentPage == 1 ? 'disabled' : ''}"><a
				class="page-link" href="?id=${categoryId}&page=${currentPage - 1}">&lt;&lt;</a>
			</li>

			<!-- Các con số trang -->
			<c:forEach begin="1" end="${endPage}" var="i">
				<li class="page-item ${currentPage == i ? 'active' : ''}"><a
					class="page-link" href="?id=${categoryId}&page=${i}">${i}</a></li>
			</c:forEach>

			<!-- Nút Next >> -->
			<li class="page-item ${currentPage == endPage ? 'disabled' : ''}">
				<a class="page-link"
				href="?id=${categoryId}&page=${currentPage + 1}">&gt;&gt;</a>
			</li>
		</ul>
	</nav>
</div>