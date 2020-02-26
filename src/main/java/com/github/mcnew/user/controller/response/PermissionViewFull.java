package com.github.mcnew.user.controller.response;

import com.github.mcnew.user.model.Permission;

public class PermissionViewFull {

	private Integer id;

	private String name;

	private String description;

	private String codeA;

	private String codeB;

	private String created;

	private String updated;

	public PermissionViewFull(Permission permission) {
		id = permission.getId();
		name = permission.getName();
		codeA = permission.getCodeA();
		codeB = permission.getCodeB();
		description = permission.getDescription();
		created = permission.getCreated().toString();
		updated = permission.getUpdated().toString();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getUpdated() {
		return updated;
	}

	public void setUpdated(String updated) {
		this.updated = updated;
	}

}
