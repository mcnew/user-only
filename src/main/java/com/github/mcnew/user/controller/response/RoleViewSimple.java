package com.github.mcnew.user.controller.response;

import java.util.Collection;

import com.github.mcnew.user.model.Role;

public class RoleViewSimple {

	private final Integer id;

	private final String name;

	private final String updated;

	private Collection<PairParameterResponseSimple> permissions;

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

	public Collection<PairParameterResponseSimple> getPermissions() {
		return permissions;
	}

	public void setPermissions(Collection<PairParameterResponseSimple> permissions) {
		this.permissions = permissions;
	}

}
