package com.github.mcnew.user.controller.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class PermissionRequestCreate {

	@NotNull
	@NotEmpty
	private String name;

	@NotNull
	@NotEmpty
	private String description;

	@NotNull
	@NotEmpty
	private String codeA;

	@NotNull
	@NotEmpty
	private String codeB;

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

	public String getCodeA() {
		return codeA;
	}

	public void setCodeA(String codeA) {
		this.codeA = codeA;
	}

	public String getCodeB() {
		return codeB;
	}

	public void setCodeB(String codeB) {
		this.codeB = codeB;
	}

}
