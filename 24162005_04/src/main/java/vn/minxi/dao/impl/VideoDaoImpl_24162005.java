package vn.minxi.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import vn.minxi.config.JPAConfig_24162005;
import vn.minxi.entity.Video_24162005;
import java.util.List;

public class VideoDaoImpl_24162005 {

	public Video_24162005 findById(int videoId) {
		EntityManager em = JPAConfig_24162005.getEntityManager();
		try {
			return em.find(Video_24162005.class, videoId);
		} finally {
			em.close();
		}
	}

	
	public List<Video_24162005> getVideosByCategoryPaging(int categoryId, int page) {
		EntityManager em = JPAConfig_24162005.getEntityManager();
		try {
			String jpql = "SELECT v FROM Video_24162005 v WHERE v.category.categoryId = :catId ORDER BY v.videoId";
			TypedQuery<Video_24162005> query = em.createQuery(jpql, Video_24162005.class);
			query.setParameter("catId", categoryId);
			query.setFirstResult((page - 1) * 3);
			query.setMaxResults(3);
			return query.getResultList();
		} finally {
			em.close();
		}
	}

	
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


	public Video_24162005 findById(String videoId) {
		// TODO Auto-generated method stub
		return null;
	}
}