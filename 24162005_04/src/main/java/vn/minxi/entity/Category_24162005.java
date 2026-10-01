package vn.minxi.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Category")
public class Category_24162005 implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CategoryId")
	private Integer categoryId;

	@Column(name = "Categoryname", length = 100)
	private String categoryName;

	@Column(name = "Categorycode", length = 100)
	private String categoryCode;

	@Column(name = "Images", length = 500)
	private String images;

	@Column(name = "Status")
	private Boolean status;

	@OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
	private List<Video_24162005> videos;

	// Getter & Setter đầy đủ
	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public List<Video_24162005> getVideos() {
		return videos;
	}

	public void setVideos(List<Video_24162005> videos) {
		this.videos = videos;
	}
}