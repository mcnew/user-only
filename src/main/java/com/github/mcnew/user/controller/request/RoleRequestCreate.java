package com.github.mcnew.user.controller.request;

import java.util.Collection;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class RoleRequestCreate {

	@NotNull
	@NotEmpty
	private String name;

	@NotNull
	@NotEmpty
	private String description;

	@NotNull
	@NotEmpty
	private Collection<PairParameterRequest> permissions;

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

	public Collection<PairParameterRequest> getPermissions() {
		return permissions;
	}

	public void setPermissions(Collection<PairParameterRequest> permissions) {
		this.permissions = permissions;
	}

}
