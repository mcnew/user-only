package com.github.mcnew.user.controller.request;

import java.util.Set;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class RoleRequestUpdate {

	@NotNull
	@NotEmpty
	private String description;

	@NotNull
	@NotEmpty
	private Set<PairParameterRequest> permissions;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<PairParameterRequest> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<PairParameterRequest> permissions) {
		this.permissions = permissions;
	}

}
