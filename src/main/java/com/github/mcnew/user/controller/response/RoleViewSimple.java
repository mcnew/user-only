package com.github.mcnew.user.controller.response;

import java.util.Collection;
import java.util.stream.Collectors;

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
		this.permissions = role.getPermissions().stream().map(entity -> {
			PairParameterResponseSimple pair = new PairParameterResponseSimple();
			pair.setName(entity.getName());
			return pair;
		}).collect(Collectors.toList());
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
