<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${user != null ? 'Cập Nhật Người Dùng' : 'Thêm Người Dùng Mới'}</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container my-5" style="max-width: 600px;">
		<div class="card shadow">
			<div class="card-header bg-primary text-white">
				<h4 class="mb-0">${user != null ? 'CẬP NHẬT NGƯỜI DÙNG' : 'THÊM NGƯỜI DÙNG MỚI'}</h4>
			</div>
			<div class="card-body">
				<form action="${pageContext.request.contextPath}/admin/user/add"
					method="post">
					<div class="mb-3">
						<label class="form-label font-weight-bold">Tên đăng nhập
							(Username):</label> <input type="text" name="username"
							class="form-control" value="${user.username}"
							${user != null ? 'readonly' : 'required'}>
					</div>

					<div class="mb-3">
						<label class="form-label">Mật khẩu:</label> <input type="password"
							name="password" class="form-control"
							${user != null ? '' : 'required'}
							placeholder="${user != null ? 'Bỏ trống nếu giữ nguyên' : ''}">
					</div>

					<div class="mb-3">
						<label class="form-label">Họ và Tên:</label> <input type="text"
							name="fullname" class="form-control" value="${user.fullname}"
							required>
					</div>

					<div class="mb-3">
						<label class="form-label">Email:</label> <input type="email"
							name="email" class="form-control" value="${user.email}" required>
					</div>

					<div class="mb-3">
						<label class="form-label">Số điện thoại:</label> <input
							type="text" name="phone" class="form-control"
							value="${user.phone}">
					</div>

					<div class="mb-3 form-check">
						<input type="checkbox" name="admin" class="form-check-input"
							id="adminCheck" ${user.admin ? 'checked' : ''}> <label
							class="form-check-label" for="adminCheck">Quyền Admin</label>
					</div>

					<div class="mb-3 form-check">
						<input type="checkbox" name="active" class="form-check-input"
							id="activeCheck" ${user == null || user.active ? 'checked' : ''}>
						<label class="form-check-label" for="activeCheck">Kích
							hoạt tài khoản</label>
					</div>

					<div class="d-flex justify-content-between">
						<a href="${pageContext.request.contextPath}/admin/users"
							class="btn btn-secondary">Quay lại</a>
						<button type="submit" class="btn btn-success">${user != null ? 'Cập Nhật' : 'Lưu Lại'}</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>