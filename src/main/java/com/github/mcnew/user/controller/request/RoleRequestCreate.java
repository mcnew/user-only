package com.github.mcnew.user.controller.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class RoleRequestCreate {

	@NotNull
	@NotEmpty
	private String name;

	@NotNull
	@NotEmpty
	private String description;

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

}
