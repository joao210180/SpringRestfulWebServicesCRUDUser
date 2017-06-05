package com.joao.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.joao.bean.Department;
import com.joao.bean.Permission;
import com.joao.bean.User;

public class UserService {

	static HashMap<Integer, User> userIdMap = getUserMap();

	public UserService() {
		super();

		if (userIdMap == null) {
			userIdMap = new HashMap<Integer, User>();

			for (int i = 1; i < 5; i++) {
				Department d = new Department();
				d.setId(10l + i);
				d.setDescription("security" + i);
				d.setName("Security");

				ArrayList<Permission> p = new ArrayList<Permission>();
				Permission p1 = new Permission();
				p1.setId(36l + i);
				p1.setDescription("Read" + i);
				p1.setName("Read");
				p.add(p1);

				User u = new User();
				u.setId(30l + i);
				u.setName("Joao " + i);
				u.setDepartment(d);
				u.setPermissions(p);

				userIdMap.put(i, u);
			}

		}
	}

	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>(userIdMap.values());
		return users;
	}

	public User getUser(int id) {
		return userIdMap.get(id);
	}

	public User addUser(User u) {
		u.setId(getMaxId() + 1);
		userIdMap.put(u.getId().intValue(), u);
		return u;
	}

	public User updateUser(User u) {
		if (u.getId() <= 0)
			return null;
		userIdMap.put(u.getId().intValue(), u);
		return u;

	}

	public void deleteUser(int id) {
		userIdMap.remove(id);
	}

	public static HashMap<Integer, User> getUserMap() {
		return userIdMap;
	}

	// Utility method to get max id
	public static Long getMaxId() {
		int max = 0;
		for (int id : userIdMap.keySet()) {
			if (max <= id)
				max = id;

		}
		return new Long(max);
	}
}
