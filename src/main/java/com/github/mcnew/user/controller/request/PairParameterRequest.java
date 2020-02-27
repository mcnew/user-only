package com.github.mcnew.user.controller.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class PairParameterRequest {

	@NotNull
	@Min(1)
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
