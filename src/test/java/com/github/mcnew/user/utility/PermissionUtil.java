package com.github.mcnew.user.utility;

import java.sql.Timestamp;

import com.github.mcnew.user.model.Permission;

public final class PermissionUtil {

	private PermissionUtil() {
	}

	public static Permission buildEntity(Integer id, String name, String description, String codeA, String codeB) {
		Permission permission = new Permission();
		permission.setId(id);
		permission.setName(name);
		permission.setDescription(description);
		permission.setCodeA(codeA);
		permission.setCodeB(codeB);
		permission.setCreated(new Timestamp(System.currentTimeMillis()));
		permission.setUpdated(new Timestamp(System.currentTimeMillis()));
		return permission;
	}

}
