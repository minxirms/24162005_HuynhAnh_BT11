package vn.minxi.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Videos")
public class Video_24162005 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "VideoId", length = 50)
	private String videoId;

	@Column(name = "Title", length = 200)
	private String title;

	@Column(name = "Poster", length = 50)
	private String poster;

	@Column(name = "Views")
	private Integer views;

	@Column(name = "Description", length = 500)
	private String description;

	@Column(name = "Active")
	private Boolean active;

	@ManyToOne
	@JoinColumn(name = "CategoryId")
	private Category_24162005 category;

	@OneToMany(mappedBy = "video")
	private List<Favorite_24162005> favorites;

	@OneToMany(mappedBy = "video")
	private List<Share_24162005> shares;

	public Video_24162005() {
	}

	// Getter & Setter
	public String getVideoId() {
		return videoId;
	}

	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public Integer getViews() {
		return views;
	}

	public void setViews(Integer views) {
		this.views = views;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Category_24162005 getCategory() {
		return category;
	}

	public void setCategory(Category_24162005 category) {
		this.category = category;
	}

	public List<Favorite_24162005> getFavorites() {
		return favorites;
	}

	public void setFavorites(List<Favorite_24162005> favorites) {
		this.favorites = favorites;
	}

	public List<Share_24162005> getShares() {
		return shares;
	}

	public void setShares(List<Share_24162005> shares) {
		this.shares = shares;
	}
}