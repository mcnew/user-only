package com.github.mcnew.user.controller.response;

import com.github.mcnew.user.model.Permission;

public class PermissionViewSimple {

	private Integer id;

	private String name;

	private String description;

	private String updated;

	public PermissionViewSimple(Permission permission) {
		id = permission.getId();
		name = permission.getName();
		description = permission.getDescription();
		updated = permission.getUpdated().toString();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUpdated() {
		return updated;
	}

	public void setUpdated(String updated) {
		this.updated = updated;
	}

}
