package vn.minxi.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Videos")
@NamedQuery(name = "Video_24162005.findAll", query = "SELECT v FROM Video_24162005 v")
public class Video_24162005 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "VideoId")
	private String videoId;

	@Column(name = "Active")
	private boolean active;

	@Column(name = "Description", columnDefinition = "NVARCHAR(MAX)")
	private String description;

	@Column(name = "Poster")
	private String poster;

	@Column(name = "Title", columnDefinition = "NVARCHAR(MAX)")
	private String title;

	@Column(name = "Views")
	private int views;

	@ManyToOne
	@JoinColumn(name = "CategoryId")
	private Category_24162005 category;

	@OneToMany(mappedBy = "video", fetch = FetchType.EAGER)
	private List<Share_24162005> shares;

	@OneToMany(mappedBy = "video", fetch = FetchType.EAGER)
	private List<Favorite_24162005> favorites;

	public Video_24162005() {
	}

	public String getVideoId() {
		return videoId;
	}

	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public Category_24162005 getCategory() {
		return category;
	}

	public void setCategory(Category_24162005 category) {
		this.category = category;
	}

	public List<Share_24162005> getShares() {
		return shares;
	}

	public void setShares(List<Share_24162005> shares) {
		this.shares = shares;
	}

	public List<Favorite_24162005> getFavorites() {
		return favorites;
	}

	public void setFavorites(List<Favorite_24162005> favorites) {
		this.favorites = favorites;
	}
}