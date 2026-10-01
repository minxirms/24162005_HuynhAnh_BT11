<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<title>Đăng Nhập</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body class="bg-light">
	<div class="container mt-5" style="max-width: 450px;">
		<div class="card shadow">
			<div class="card-body p-4">
				<h3 class="text-center mb-4">ĐĂNG NHẬP</h3>

				<c:if test="${not empty error}">
					<div class="alert alert-danger">${error}</div>
				</c:if>
				<c:if test="${not empty message}">
					<div class="alert alert-success">${message}</div>
				</c:if>

				<form action="${pageContext.request.contextPath}/login"
					method="post">
					<div class="mb-3">
						<label class="form-label">Tên đăng nhập</label> <input type="text"
							name="username" class="form-control" required>
					</div>
					<div class="mb-3">
						<label class="form-label">Mật khẩu</label> <input type="password"
							name="password" class="form-control" required>
					</div>
					<button type="submit" class="btn btn-primary w-100">Đăng
						nhập</button>
				</form>
				<div class="text-center mt-3">
					Chưa có tài khoản? <a
						href="${pageContext.request.contextPath}/register">Đăng ký
						ngay</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>