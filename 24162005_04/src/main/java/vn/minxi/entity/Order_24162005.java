package vn.minxi.entity;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Orders")
public class Order_24162005 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;

	private String customerName;
	private String phone;
	private String address;
	private double totalAmount;
	private String paymentMethod; // "COD"

	// Trạng thái: "DON_HANG_MOI", "DA_XAC_NHAN", "CHUAN_BI_HANG", "VAN_CHUYEN",
	// "GIAO_HANG", "DA_GIAO", "DA_HUY", "HOAN_TIEN"
	private String status;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<OrderItem_24162005> orderItems;

	// Getter, Setter...
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public List<OrderItem_24162005> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem_24162005> orderItems) {
		this.orderItems = orderItems;
	}
}