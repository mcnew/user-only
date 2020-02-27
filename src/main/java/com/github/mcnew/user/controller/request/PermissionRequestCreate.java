package com.github.mcnew.user.controller.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class PermissionRequestCreate {

	@NotNull
	@Pattern(regexp = "^[a-zA-Z]+$")
	private String name;

	@NotNull
	@Pattern(regexp = "^[-a-zA-Z 0-9.,ñ]+$")
	private String description;

	@NotNull
	@Pattern(regexp = "^[a-zA-Z0-9]+$")
	private String codeA;

	@NotNull
	@Pattern(regexp = "^[a-zA-Z0-9]+$")
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
