package com.github.mcnew.user.model.id;

import java.io.Serializable;

import javax.persistence.Column;

public class RolePermissionId implements Serializable {

	private static final long serialVersionUID = 8390969442572203067L;

	@Column(name = "id_role")
	private Integer idRole;

	@Column(name = "id_permission")
	private Integer idPermission;

	public Integer getIdRole() {
		return idRole;
	}

	public void setIdRole(Integer idRole) {
		this.idRole = idRole;
	}

	public Integer getIdPermission() {
		return idPermission;
	}

	public void setIdPermission(Integer idPermission) {
		this.idPermission = idPermission;
	}

}
