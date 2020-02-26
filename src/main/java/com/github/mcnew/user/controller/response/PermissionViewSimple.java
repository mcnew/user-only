package com.github.mcnew.user.controller.response;

import com.github.mcnew.user.model.Permission;

public class PermissionViewSimple {

	private final Integer id;

	private final String name;

	private final String description;

	private final String updated;

	public PermissionViewSimple(Permission permission) {
		id = permission.getId();
		name = permission.getName();
		description = permission.getDescription();
		updated = permission.getUpdated().toString();
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getUpdated() {
		return updated;
	}

}
