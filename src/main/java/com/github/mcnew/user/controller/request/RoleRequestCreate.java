package com.github.mcnew.user.controller.request;

import java.util.Set;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class RoleRequestCreate {

	@NotNull
	@Pattern(regexp = "^[a-zA-Z]+$")
	private String name;

	@NotNull
	@Pattern(regexp = "^[-a-zA-Z 0-9.,ñ]+$")
	private String description;

	@NotNull
	@NotEmpty
	private Set<@Valid PairParameterRequest> permissions;

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

	public Set<PairParameterRequest> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<PairParameterRequest> permissions) {
		this.permissions = permissions;
	}

}
