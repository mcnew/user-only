package com.github.mcnew.user.utility;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Collections;

import com.github.mcnew.user.model.Permission;
import com.github.mcnew.user.model.Role;

public final class RoleUtil {

	private RoleUtil() {
	}

	public static Role buildEntity(Integer id, String name, String description, Permission... permissions) {
		Role entity = new Role();
		entity.setId(id);
		entity.setName(name);
		entity.setDescription(description);
		entity.setCreated(new Timestamp(System.currentTimeMillis()));
		entity.setUpdated(new Timestamp(System.currentTimeMillis()));
		if (permissions.length == 0) {
			entity.setPermissions(Collections.emptyList());
		} else {
			entity.setPermissions(Arrays.asList(permissions));
		}
		return entity;
	}

}
