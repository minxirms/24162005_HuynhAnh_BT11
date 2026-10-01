<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<title>Đăng Ký Tài Khoản</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body class="bg-light">
	<div class="container mt-5" style="max-width: 500px;">
		<div class="card shadow">
			<div class="card-body p-4">
				<h3 class="text-center mb-4">ĐĂNG KÝ TÀI KHOẢN</h3>

				<c:if test="${not empty error}">
					<div class="alert alert-danger">${error}</div>
				</c:if>

				<form action="${pageContext.request.contextPath}/register"
					method="post">
					<div class="mb-3">
						<label class="form-label">Tên đăng nhập</label> <input type="text"
							name="username" class="form-control" required>
					</div>
					<div class="mb-3">
						<label class="form-label">Mật khẩu</label> <input type="password"
							name="password" class="form-control" required>
					</div>
					<div class="mb-3">
						<label class="form-label">Họ và tên</label> <input type="text"
							name="fullname" class="form-control" required>
					</div>
					<div class="mb-3">
						<label class="form-label">Email (Nhận mã OTP)</label> <input
							type="email" name="email" class="form-control" required>
					</div>
					<div class="mb-3">
						<label class="form-label">Số điện thoại</label> <input type="text"
							name="phone" class="form-control" required>
					</div>
					<button type="submit" class="btn btn-success w-100">Gửi mã
						OTP qua Email</button>
				</form>
				<div class="text-center mt-3">
					Đã có tài khoản? <a href="${pageContext.request.contextPath}/login">Đăng
						nhập</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>