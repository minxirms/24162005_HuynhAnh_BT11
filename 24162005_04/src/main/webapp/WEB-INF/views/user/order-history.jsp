<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lịch sử đơn hàng</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container mt-4">
		<h2 class="mb-4">Lịch sử đặt hàng</h2>

		<!-- Bộ lọc trạng thái đơn hàng -->
		<div class="mb-4 btn-group flex-wrap">
			<a href="${pageContext.request.contextPath}/order/history?status=ALL"
				class="btn ${selectedStatus == 'ALL' ? 'btn-primary' : 'btn-outline-primary'}">Tất
				cả</a> <a
				href="${pageContext.request.contextPath}/order/history?status=DON_HANG_MOI"
				class="btn ${selectedStatus == 'DON_HANG_MOI' ? 'btn-primary' : 'btn-outline-primary'}">Đơn
				hàng mới</a> <a
				href="${pageContext.request.contextPath}/order/history?status=DA_XAC_NHAN"
				class="btn ${selectedStatus == 'DA_XAC_NHAN' ? 'btn-primary' : 'btn-outline-primary'}">Đã
				xác nhận</a> <a
				href="${pageContext.request.contextPath}/order/history?status=CHUAN_BI_HANG"
				class="btn ${selectedStatus == 'CHUAN_BI_HANG' ? 'btn-primary' : 'btn-outline-primary'}">Chuẩn
				bị hàng</a> <a
				href="${pageContext.request.contextPath}/order/history?status=VAN_CHUYEN"
				class="btn ${selectedStatus == 'VAN_CHUYEN' ? 'btn-primary' : 'btn-outline-primary'}">Vận
				chuyển</a> <a
				href="${pageContext.request.contextPath}/order/history?status=GIAO_HANG"
				class="btn ${selectedStatus == 'GIAO_HANG' ? 'btn-primary' : 'btn-outline-primary'}">Giao
				hàng</a> <a
				href="${pageContext.request.contextPath}/order/history?status=DA_GIAO"
				class="btn ${selectedStatus == 'DA_GIAO' ? 'btn-primary' : 'btn-outline-primary'}">Đã
				giao</a> <a
				href="${pageContext.request.contextPath}/order/history?status=DA_HUY"
				class="btn ${selectedStatus == 'DA_HUY' ? 'btn-primary' : 'btn-outline-primary'}">Đơn
				hàng hủy</a> <a
				href="${pageContext.request.contextPath}/order/history?status=HOAN_TIEN"
				class="btn ${selectedStatus == 'HOAN_TIEN' ? 'btn-primary' : 'btn-outline-primary'}">Đơn
				hàng hoàn</a>
		</div>

		<!-- Danh sách đơn hàng -->
		<c:choose>
			<c:when test="${not empty orders}">
				<c:forEach var="o" items="${orders}">
					<div class="card mb-3 shadow-sm">
						<div
							class="card-header d-flex justify-content-between align-items-center">
							<span><strong>Mã đơn hàng:</strong> #${o.orderId} -
								${o.createdDate}</span> <span class="badge bg-info text-dark">${o.status}</span>
						</div>
						<div class="card-body">
							<p class="mb-1">
								<strong>Khách hàng:</strong> ${o.customerName} | <strong>SDT:</strong>
								${o.phone}
							</p>
							<p class="mb-2">
								<strong>Địa chỉ:</strong> ${o.address}
							</p>
							<table class="table table-sm table-bordered">
								<thead>
									<tr>
										<th>Sản phẩm</th>
										<th>Số lượng</th>
										<th>Đơn giá</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="item" items="${o.orderItems}">
										<tr>
											<td>${item.video.title}</td>
											<td>${item.quantity}</td>
											<td>${item.price}VNĐ</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<h5 class="text-end text-danger mb-0">Tổng tiền:
								${o.totalAmount} VNĐ</h5>
						</div>
					</div>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<div class="alert alert-info">Không tìm thấy đơn hàng nào ở
					trạng thái này!</div>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>