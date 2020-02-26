package com.github.mcnew.user.controller.response;

import com.github.mcnew.user.model.Role;

public class RoleViewSimple {

	private final Integer id;

	private final String name;

	private final String updated;

	public RoleViewSimple(Role role) {
		this.id = role.getId();
		this.name = role.getName();
		this.updated = role.getUpdated().toString();
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getUpdated() {
		return updated;
	}

}
