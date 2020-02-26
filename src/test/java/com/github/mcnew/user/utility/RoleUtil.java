package com.github.mcnew.user.utility;

import java.sql.Timestamp;

import com.github.mcnew.user.model.Role;

public final class RoleUtil {

	private RoleUtil() {
	}

	public static Role buildEntity(Integer id, String name, String description) {
		Role entity = new Role();
		entity.setId(id);
		entity.setName(name);
		entity.setDescription(description);
		entity.setCreated(new Timestamp(System.currentTimeMillis()));
		entity.setUpdated(new Timestamp(System.currentTimeMillis()));
		return entity;
	}

}
