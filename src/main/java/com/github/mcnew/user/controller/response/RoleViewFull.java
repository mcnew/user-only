package com.github.mcnew.user.controller.response;

import java.util.Collection;
import java.util.stream.Collectors;

import com.github.mcnew.user.model.Role;

public class RoleViewFull {

	private final Integer id;

	private final String name;

	private final String description;

	private final String created;

	private final String updated;

	private final Collection<PairParameterResponseFull> permissions;

	public RoleViewFull(Role role) {
		this.id = role.getId();
		this.name = role.getName();
		this.description = role.getDescription();
		this.created = role.getCreated().toString();
		this.updated = role.getUpdated().toString();
		this.permissions = role.getPermissions().stream().map(entity -> {
			PairParameterResponseFull pair = new PairParameterResponseFull();
			pair.setId(entity.getId());
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

	public String getDescription() {
		return description;
	}

	public String getCreated() {
		return created;
	}

	public String getUpdated() {
		return updated;
	}

	public Collection<PairParameterResponseFull> getPermissions() {
		return permissions;
	}

}
