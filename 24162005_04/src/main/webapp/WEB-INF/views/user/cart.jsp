<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Giỏ hàng của bạn</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container mt-4">
		<h2 class="fw-bold mb-4">🛒 Giỏ hàng của bạn</h2>

		<c:choose>
			<c:when test="${not empty sessionScope.cart}">
				<div class="table-responsive">
					<table class="table table-bordered align-middle">
						<thead class="table-dark">
							<tr>
								<th>Ảnh</th>
								<th>Tên Video / Sản phẩm</th>
								<th style="width: 180px;">Số lượng (1-99)</th>
								<th>Đơn giá</th>
								<th>Thành tiền</th>
								<th style="width: 100px;">Thao tác</th>
							</tr>
						</thead>
						<tbody>
							<c:set var="totalSum" value="0" />
							<c:forEach var="entry" items="${sessionScope.cart}">
								<c:set var="item" value="${entry.value}" />
								<c:set var="totalSum" value="${totalSum + item.totalPrice}" />
								<tr>
									<td style="width: 100px;">
										<img src="${item.video.poster}" alt="${item.video.title}" 
											 class="img-thumbnail" style="height: 60px; object-fit: cover;">
									</td>
									<td>
										<strong>${item.video.title}</strong>
										<br>
										<small class="text-muted">Mã: ${item.video.videoId}</small>
									</td>
									<td>
										<!-- Cập nhật số lượng -->
										<form action="${pageContext.request.contextPath}/cart/update" method="post" class="d-flex align-items-center">
											<input type="hidden" name="id" value="${item.video.videoId}">
											<input type="number" name="quantity" value="${item.quantity}" 
												   min="1" max="99" class="form-control form-control-sm me-2" required>
											<button type="submit" class="btn btn-sm btn-outline-secondary">Lưu</button>
										</form>
									</td>
									<td>50.000 VNĐ</td>
									<td class="fw-bold text-primary">${item.totalPrice} VNĐ</td>
									<td>
										<!-- Xóa khỏi giỏ -->
										<a href="${pageContext.request.contextPath}/cart/delete?id=${item.video.videoId}" 
										   class="btn btn-sm btn-danger"
										   onclick="return confirm('Bạn có chắc muốn xóa sản phẩm này khỏi giỏ hàng?');">
										   Xóa
										</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>

				<!-- Tổng tiền & Chuyển hướng -->
				<div class="d-flex justify-content-between align-items-center mt-4 p-3 bg-light rounded shadow-sm">
					<div>
						<a href="${pageContext.request.contextPath}/category/videos" class="btn btn-outline-secondary">
							&laquo; Tiếp tục xem video
						</a>
					</div>
					<div class="text-end">
						<h4 class="mb-2">Tổng thanh toán: <span class="text-danger fw-bold">${totalSum} VNĐ</span></h4>
						<a href="${pageContext.request.contextPath}/checkout" class="btn btn-success btn-lg">
							Thanh toán COD &raquo;
						</a>
					</div>
				</div>
			</c:when>
			<c:otherwise>
				<div class="alert alert-info p-4 text-center">
					<p class="fs-5 mb-3">Giỏ hàng của bạn đang trống!</p>
					<a href="${pageContext.request.contextPath}/category/videos" class="btn btn-primary">
						Quay lại danh sách video
					</a>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>