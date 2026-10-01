<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<title>Đăng Nhập Vào Hệ Thống</title>
<!-- Bootstrap CSS & Font Awesome -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<style>
.login-container {
	max-width: 400px;
	margin: 50px auto;
	padding: 20px;
	border: 1px solid #e3e3e3;
	border-radius: 4px;
	background-color: #fff;
}

.form-options {
	margin: 15px 0;
	display: flex;
	justify-content: space-between;
	align-items: center;
}

.text-danger-error {
	color: #a94442;
	font-size: 12px;
	margin-top: 4px;
	display: block;
}
</style>
</head>
<body>

	<div class="container">
		<div class="login-container">

			<form action="${pageContext.request.contextPath}/login" method="post" novalidate>
				<h2 class="text-center">Đăng Nhập Vào Hệ Thống</h2>

				<!-- Thông báo lỗi tổng quát -->
				<c:if test="${not empty alert}">
					<div class="alert alert-danger text-center" role="alert">
						${alert}</div>
				</c:if>

				<!-- Thông báo thành công -->
				<c:if test="${not empty message}">
					<div class="alert alert-success text-center" role="alert">
						${message}</div>
				</c:if>

				<section>
					<!-- Ô nhập Tài khoản -->
					<div class="form-group ${not empty errUsername ? 'has-error' : ''}">
						<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-user"></i></span>
							<input type="text" name="username" class="form-control"
								placeholder="Tài khoản" value="${username}" required>
						</div>
						<!-- Hiển thị lỗi validation riêng của Username -->
						<c:if test="${not empty errUsername}">
							<span class="text-danger-error"><i class="fa fa-exclamation-circle"></i> ${errUsername}</span>
						</c:if>
					</div>

					<!-- Ô nhập Mật khẩu -->
					<div class="form-group ${not empty errPassword ? 'has-error' : ''}">
						<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-lock"></i></span>
							<input type="password" name="password" class="form-control"
								placeholder="Mật khẩu" required>
						</div>
						<!-- Hiển thị lỗi validation riêng của Password -->
						<c:if test="${not empty errPassword}">
							<span class="text-danger-error"><i class="fa fa-exclamation-circle"></i> ${errPassword}</span>
						</c:if>
					</div>

					<div class="form-group form-options">
						<label class="checkbox-inline"> <input type="checkbox"
							name="remember" ${remember ? 'checked' : ''}> Nhớ tôi
						</label> <a href="${pageContext.request.contextPath}/forgot-password"
							class="pull-right">Quên mật khẩu?</a>
					</div>

					<button type="submit" class="btn btn-primary btn-block">Đăng
						nhập</button>
				</section>
			</form>

			<hr>
			<p class="text-center text-muted">
				Nếu bạn chưa có tài khoản trên hệ thống, thì hãy <a
					href="${pageContext.request.contextPath}/register">Đăng ký</a>
			</p>

		</div>
	</div>

</body>
</html>