<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thanh toán COD</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container mt-4" style="max-width: 600px;">
		<h2 class="mb-4 text-center">Xác nhận thanh toán (COD)</h2>

		<form action="${pageContext.request.contextPath}/checkout"
			method="post">
			<div class="mb-3">
				<label class="form-label">Họ và tên người nhận</label> <input
					type="text" name="name" class="form-control" required
					placeholder="Nguyễn Văn A">
			</div>
			<div class="mb-3">
				<label class="form-label">Số điện thoại</label> <input type="text"
					name="phone" class="form-control" required placeholder="0901234567">
			</div>
			<div class="mb-3">
				<label class="form-label">Địa chỉ giao hàng</label>
				<textarea name="address" class="form-control" rows="3" required
					placeholder="Số nhà, đường, phường/xã, quận/huyện..."></textarea>
			</div>
			<div class="mb-3">
				<label class="form-label">Phương thức thanh toán</label> <input
					type="text" class="form-control"
					value="Thanh toán khi nhận hàng (COD)" readonly>
			</div>
			<button type="submit" class="btn btn-primary w-100">Xác nhận
				Đặt hàng</button>
		</form>
	</div>
</body>
</html>