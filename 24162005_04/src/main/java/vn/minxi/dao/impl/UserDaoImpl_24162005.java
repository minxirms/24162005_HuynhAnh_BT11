package vn.minxi.dao.impl;

import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import vn.minxi.config.JPAConfig_24162005;
import vn.minxi.dao.IUserDao_24162005;
import vn.minxi.entity.User_24162005;

public class UserDaoImpl_24162005 implements IUserDao_24162005 {

	@Override
	public User_24162005 findByUsername(String username) {
		EntityManager en = JPAConfig_24162005.getEntityManager();
		try {
			return en.find(User_24162005.class, username);
		} finally {
			en.close();
		}
	}

	@Override
	public void insert(User_24162005 user) {
		EntityManager en = JPAConfig_24162005.getEntityManager();
		EntityTransaction trans = en.getTransaction();
		try {
			trans.begin();
			en.persist(user);
			trans.commit();
		} catch (Exception e) {
			if (trans.isActive())
				trans.rollback();
			e.printStackTrace();
		} finally {
			en.close();
		}
	}

	@Override
	public void update(User_24162005 user) {
		EntityManager en = JPAConfig_24162005.getEntityManager();
		EntityTransaction trans = en.getTransaction();
		try {
			trans.begin();
			en.merge(user);
			trans.commit();
		} catch (Exception e) {
			if (trans.isActive())
				trans.rollback();
			e.printStackTrace();
		} finally {
			en.close();
		}
	}

	@Override
	public void delete(String username) {
		EntityManager en = JPAConfig_24162005.getEntityManager();
		EntityTransaction trans = en.getTransaction();
		try {
			trans.begin();
			User_24162005 user = en.find(User_24162005.class, username);
			if (user != null) {
				en.remove(user);
			}
			trans.commit();
		} catch (Exception e) {
			if (trans.isActive())
				trans.rollback();
			e.printStackTrace();
		} finally {
			en.close();
		}
	}

	@Override
	public List<User_24162005> findAll(int page, int pageSize) {
		EntityManager en = JPAConfig_24162005.getEntityManager();
		try {
			TypedQuery<User_24162005> query = en.createQuery("SELECT u FROM User_24162005 u", User_24162005.class);
			query.setFirstResult((page - 1) * pageSize);
			query.setMaxResults(pageSize);
			return query.getResultList();
		} finally {
			en.close();
		}
	}

	@Override
	public int count() {
		EntityManager en = JPAConfig_24162005.getEntityManager();
		try {
			Query query = en.createQuery("SELECT COUNT(u) FROM User_24162005 u");
			return ((Long) query.getSingleResult()).intValue();
		} finally {
			en.close();
		}
	}
	@Override
	public List<User_24162005> getPagingUsers(int page) {
	    EntityManager en = JPAConfig_24162005.getEntityManager();
	    try {
	        int pageSize = 6;
	        TypedQuery<User_24162005> query = en.createQuery("SELECT u FROM User_24162005 u", User_24162005.class);
	        query.setFirstResult((page - 1) * pageSize);
	        query.setMaxResults(pageSize);
	        return query.getResultList();
	    } finally {
	        en.close();
	    }
	}

	@Override
	public int getTotalUsersCount() {
	    EntityManager en = JPAConfig_24162005.getEntityManager();
	    try {
	        Query query = en.createQuery("SELECT COUNT(u) FROM User_24162005 u");
	        return ((Long) query.getSingleResult()).intValue();
	    } finally {
	        en.close();
	    }
	}
}