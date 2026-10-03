package vn.minxi.dao.impl;

import jakarta.persistence.EntityManager;
import vn.minxi.dao.ICategoryDao_24162005;
import vn.minxi.entity.Category_24162005;
import vn.minxi.config.JPAConfig_24162005; // Đảm bảo đúng package chứa JpaUtils của bạn

public class CategoryDaoImpl_24162005 implements ICategoryDao_24162005 {

	@Override
	public Category_24162005 findById(int id) {
		EntityManager en = JPAConfig_24162005.getEntityManager();
		try {
			return en.find(Category_24162005.class, id);
		} finally {
			en.close();
		}
	}
}