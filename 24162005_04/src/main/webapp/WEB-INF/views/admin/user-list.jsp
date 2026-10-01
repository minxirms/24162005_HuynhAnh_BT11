<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý người dùng</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container my-4">
    <div class="d-flex justify-content-between align-items-center mb-3">
        <h3 class="fw-bold text-primary">DANH SÁCH NGUỜI DÙNG</h3>
        <a href="${pageContext.request.contextPath}/admin/user/add" class="btn btn-success">+ Thêm Người Dùng</a>
    </div>

    <div class="table-responsive">
        <table class="table table-bordered table-striped align-middle">
            <thead class="table-dark">
                <tr>
                    <th>Username</th>
                    <th>Họ và Tên</th>
                    <th>Email</th>
                    <th>Số điện thoại</th>
                    <th>Vai trò</th>
                    <th>Trạng thái</th>
                    <th class="text-center">Thao tác</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${userList}" var="u">
                    <tr>
                        <td class="fw-bold">${u.username}</td>
                        <td>${u.fullname}</td>
                        <td>${u.email}</td>
                        <td>${u.phone}</td>
                        <td>
                            <span class="badge ${u.admin ? 'bg-danger' : 'bg-secondary'}">
                                ${u.admin ? 'Admin' : 'User'}
                            </span>
                        </td>
                        <td>
                            <span class="badge ${u.active ? 'bg-success' : 'bg-warning'}">
                                ${u.active ? 'Hoạt động' : 'Khóa'}
                            </span>
                        </td>
                        <td class="text-center">
                            <a href="${pageContext.request.contextPath}/admin/user/edit?username=${u.username}" class="btn btn-primary btn-sm me-1">Sửa</a>
                            <a href="${pageContext.request.contextPath}/admin/user/delete?username=${u.username}" 
                               onclick="return confirm('Bạn có chắc chắn muốn xóa user ${u.username}?');" class="btn btn-danger btn-sm">Xóa</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <!-- Thanh phân trang 6 Users/Trang -->
    <c:if test="${totalPages > 1}">
        <nav aria-label="Page navigation" class="mt-4">
            <ul class="pagination justify-content-center">
                <c:forEach begin="1" end="${totalPages}" var="i">
                    <li class="page-item ${currentPage == i ? 'active' : ''}">
                        <a class="page-link" href="${pageContext.request.contextPath}/admin/users?page=${i}">${i}</a>
                    </li>
                </c:forEach>
            </ul>
        </nav>
    </c:if>
</div>
</body>
</html>