package vn.minxi.dao.impl;

import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import vn.minxi.config.JPAConfig_24162005;
import vn.minxi.dao.IVideoDao_24162005;
import vn.minxi.entity.Category_24162005;
import vn.minxi.entity.Video_24162005;

public class VideoDaoImpl_24162005 implements IVideoDao_24162005 {

	@Override
	public Video_24162005 findById(String videoId) {
		EntityManager em = JPAConfig_24162005.getEntityManager();
		try {
			return em.find(Video_24162005.class, videoId);
		} finally {
			em.close();
		}
	}

	@Override
	public Category_24162005 findCategoryById(int categoryId) {
		EntityManager em = JPAConfig_24162005.getEntityManager();
		try {
			return em.find(Category_24162005.class, categoryId);
		} finally {
			em.close();
		}
	}

	@Override
	public int countVideosByCategory(int categoryId) {
		EntityManager em = JPAConfig_24162005.getEntityManager();
		try {
			String jpql = "SELECT COUNT(v) FROM Video_24162005 v WHERE v.category.categoryId = :catId";
			TypedQuery<Long> query = em.createQuery(jpql, Long.class);
			query.setParameter("catId", categoryId);
			return query.getSingleResult().intValue();
		} finally {
			em.close();
		}
	}

	@Override
	public List<Video_24162005> getVideosByCategoryPaging(int categoryId, int page, int pageSize) {
		EntityManager em = JPAConfig_24162005.getEntityManager();
		try {
			if (page < 1)
				page = 1;
			String jpql = "SELECT v FROM Video_24162005 v WHERE v.category.categoryId = :catId ORDER BY v.videoId";
			TypedQuery<Video_24162005> query = em.createQuery(jpql, Video_24162005.class);
			query.setParameter("catId", categoryId);
			query.setFirstResult((page - 1) * pageSize);
			query.setMaxResults(pageSize);
			return query.getResultList();
		} finally {
			em.close();
		}
	}
}