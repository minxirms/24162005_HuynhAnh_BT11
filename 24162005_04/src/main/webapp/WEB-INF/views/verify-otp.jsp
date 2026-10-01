<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<title>Xác Thực OTP</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body class="bg-light">
	<div class="container mt-5" style="max-width: 400px;">
		<div class="card shadow">
			<div class="card-body p-4 text-center">
				<h4 class="mb-3">XÁC THỰC MÃ OTP</h4>
				<p class="text-muted small">Mã OTP đã được gửi đến Email đăng ký
					của bạn.</p>

				<c:if test="${not empty error}">
					<div class="alert alert-danger">${error}</div>
				</c:if>

				<form action="${pageContext.request.contextPath}/verify-otp"
					method="post">
					<div class="mb-3">
						<input type="text" name="otp"
							class="form-control text-center fs-4" placeholder="------"
							maxlength="6" required>
					</div>
					<button type="submit" class="btn btn-primary w-100">Xác
						nhận Kích hoạt</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>