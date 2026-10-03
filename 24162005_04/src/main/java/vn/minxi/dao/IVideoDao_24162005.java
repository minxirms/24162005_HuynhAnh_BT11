package vn.minxi.dao;

import java.util.List;
import vn.minxi.entity.Category_24162005;
import vn.minxi.entity.Video_24162005;

public interface IVideoDao_24162005 {
	Video_24162005 findById(String videoId);

	Category_24162005 findCategoryById(int categoryId);

	int countVideosByCategory(int categoryId);

	List<Video_24162005> getVideosByCategoryPaging(int categoryId, int page, int pageSize);
}