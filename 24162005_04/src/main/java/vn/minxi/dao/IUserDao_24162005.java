package vn.minxi.dao;

import java.util.List;
import vn.minxi.entity.User_24162005;

public interface IUserDao_24162005 {
	User_24162005 findByUsername(String username);

	void insert(User_24162005 user);

	void update(User_24162005 user);

	void delete(String username);

	List<User_24162005> findAll(int page, int pageSize);

	int count();

	List<User_24162005> getPagingUsers(int page);

	int getTotalUsersCount();
}