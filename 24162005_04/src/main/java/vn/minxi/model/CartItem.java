package vn.minxi.model;

import vn.minxi.entity.Video_24162005;

public class CartItem {
	private Video_24162005 video;
	private int quantity;

	public CartItem() {
	}

	public CartItem(Video_24162005 video, int quantity) {
		this.video = video;
		this.quantity = quantity;
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

	public double getTotalPrice() {
		// Giả định giá sản phẩm (ví dụ views * 1000 hoặc thuộc tính price)
		return quantity * 50000;
	}
}