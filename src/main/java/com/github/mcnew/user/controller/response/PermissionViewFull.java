package com.github.mcnew.user.controller.response;

import com.github.mcnew.user.model.Permission;

public class PermissionViewFull {

	private final Integer id;

	private final String name;

	private final String description;

	private final String codeA;

	private final String codeB;

	private final String created;

	private final String updated;

	public PermissionViewFull(Permission permission) {
		id = permission.getId();
		name = permission.getName();
		codeA = permission.getCodeA();
		codeB = permission.getCodeB();
		description = permission.getDescription();
		created = permission.getCreated().toString();
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

	public String getCodeA() {
		return codeA;
	}

	public String getCodeB() {
		return codeB;
	}

	public String getCreated() {
		return created;
	}

	public String getUpdated() {
		return updated;
	}

}
