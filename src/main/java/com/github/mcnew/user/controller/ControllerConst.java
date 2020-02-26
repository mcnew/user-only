package com.github.mcnew.user.controller;

import org.springframework.http.MediaType;

final class ControllerConst {

	public static final String CONTENT_TYPE_JSON = MediaType.APPLICATION_JSON_VALUE + "; charset=UTF-8";

	public static final String URL_PERMISSIONS = "/permissions";

	public static final String URL_ROLES = "/roles";
	
	public static final String PRM_ID = "/{id}";

	private ControllerConst() {
	}

}
