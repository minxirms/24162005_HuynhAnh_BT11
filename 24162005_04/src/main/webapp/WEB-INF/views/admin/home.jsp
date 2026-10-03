<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang Chủ Quản Trị Admin</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container my-5">
    <h2 class="text-primary fw-bold mb-4">Bảng Quản Trị Hệ Thống </h2>
    
    <div class="row g-4">
        <div class="col-md-6">
            <div class="card bg-primary text-white shadow">
                <div class="card-body">
                    <h5 class="card-title">Quản Lý Người Dùng</h5>
                    <p class="card-text">Xem danh sách, phân trang và quản lý tài khoản User.</p>
                    <a href="${pageContext.request.contextPath}/admin/users" class="btn btn-light text-primary font-weight-bold">Quản lý User</a>
                </div>
            </div>
        </div>
        
        <div class="col-md-6">
            <div class="card bg-success text-white shadow">
                <div class="card-body">
                    <h5 class="card-title">Quản Lý Video</h5>
                    <p class="card-text">Thêm, sửa, xóa các Video hiển thị trên hệ thống.</p>
                    <a href="${pageContext.request.contextPath}/admin/videos" class="btn btn-light text-success font-weight-bold">Quản lý Video</a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>