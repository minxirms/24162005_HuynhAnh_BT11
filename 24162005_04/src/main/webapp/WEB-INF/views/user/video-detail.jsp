<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chi tiết Video</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>

<body>

	<div class="container mt-4">

		<div class="row">

			<!-- Poster -->
			<div class="col-md-5">
				<img src="<c:url value='${video.poster}'/>"
					class="img-fluid rounded shadow-sm" alt="${video.title}">
			</div>

			<!-- Thông tin video -->
			<div class="col-md-7">

				<h4>Tiêu đề: ${video.title}</h4>

				<p>
					<strong>Mã video:</strong> ${video.videoId}
				</p>

				<p>
					<strong>Category name:</strong> ${video.category.categoryName}
				</p>

				<p>
					<strong>View:</strong> ${video.views}
				</p>

				<div class="mb-3">

					<span class="btn btn-primary btn-sm me-2">
						Share(${video.shares != null ? video.shares.size() : 0}) </span> <span
						class="btn btn-success btn-sm"> Like(${video.favorites != null ? video.favorites.size() : 0})
					</span>

				</div>

				<hr>

				<p>
					<strong>Description:</strong>
				</p>

				<p>${video.description}</p>

				<!-- Nút Thao tác Giỏ hàng & Chuyển hướng -->
				<div class="mt-4">
					<a
						href="${pageContext.request.contextPath}/cart/add?id=${video.videoId}"
						class="btn btn-success btn-sm me-2"> 🛒 Thêm vào giỏ hàng </a> <a
						href="${pageContext.request.contextPath}/cart"
						class="btn btn-outline-primary btn-sm me-2"> Xem giỏ hàng </a> <a
						href="javascript:history.back()" class="btn btn-secondary btn-sm">Quay
						lại</a>
				</div>

			</div>

		</div>

	</div>

</body>
</html>