package com.github.mcnew.user.controller;

import org.springframework.http.MediaType;

public final class ControllerConst {

	public static final String CONTENT_TYPE_JSON = MediaType.APPLICATION_JSON_VALUE + "; charset=UTF-8";

	public static final String URL_PERMISSIONS = "/adm-permissions";

	public static final String URL_ROLES = "/adm-roles";
	
	public static final String PRM_ID = "/{id}";

	private ControllerConst() {
	}

}
