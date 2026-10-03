package vn.minxi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "OrderItems")
public class OrderItem_24162005 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "orderId")
	private Order_24162005 order;

	@ManyToOne
	@JoinColumn(name = "videoId")
	private Video_24162005 video;

	private int quantity;
	private double price;

	// Getter, Setter...
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Order_24162005 getOrder() {
		return order;
	}

	public void setOrder(Order_24162005 order) {
		this.order = order;
	}

	public Video_24162005 getVideo() {
		return video;
	}

	public void setVideo(Video_24162005 video) {
		this.video = video;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}