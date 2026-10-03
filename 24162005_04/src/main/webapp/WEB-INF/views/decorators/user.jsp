<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><sitemesh:write property='title' /></title>
    
    <!-- Bootstrap 5 CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    
    <!-- Nhúng head riêng từ các trang con (CSS/JS phụ) -->
    <sitemesh:write property='head' />
</head>
<body>

    <!-- HEADER MENU -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
        <div class="container">
            <a class="navbar-brand fw-bold" href="<c:url value='/home'/>">Website Video</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav me-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value='/home'/>">Trang Chủ</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value='/products'/>">Sản phẩm</a>
                    </li>
                    <c:if test="${empty sessionScope.account}">
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value='/login'/>">Đăng nhập</a>
                        </li>
                    </c:if>
                    <c:if test="${not empty sessionScope.account && sessionScope.account.admin}">
                        <li class="nav-item">
                            <a class="nav-link text-warning fw-bold" href="<c:url value='/admin/home'/>">Trang quản trị</a>
                        </li>
                    </c:if>
                </ul>
            </div>
        </div>
    </nav>

    <!-- NỘI DUNG TRANG USER -->
    <div class="container my-4" style="min-height: 400px;">
        <sitemesh:write property='body' />
    </div>

    <!-- FOOTER (Yêu cầu đề bài) -->
    <footer class="bg-dark text-white text-center py-3">
        <p class="mb-0">Họ tên: Huỳnh Anh | MSSV: 24162005 | Mã đề: 04</p>
    </footer>

    <!-- Bootstrap 5 JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>