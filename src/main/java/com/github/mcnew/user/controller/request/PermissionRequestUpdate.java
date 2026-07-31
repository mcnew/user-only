package com.github.mcnew.user.controller.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class PermissionRequestUpdate {

	@NotNull
	@Pattern(regexp = "^[-a-zA-Z 0-9.,ñ]+$")
	private String description;

	@NotNull
	@Pattern(regexp = "^[a-zA-Z0-9]+$")
	private String codeA;

	@NotNull
	@Pattern(regexp = "^[a-zA-Z0-9]+$")
	private String codeB;

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
