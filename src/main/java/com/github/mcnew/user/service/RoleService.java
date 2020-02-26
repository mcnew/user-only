package com.github.mcnew.user.service;

import java.util.Collection;
import java.util.Optional;

import com.github.mcnew.user.controller.request.RoleRequestCreate;
import com.github.mcnew.user.controller.request.RoleRequestUpdate;
import com.github.mcnew.user.controller.response.RoleViewFull;
import com.github.mcnew.user.controller.response.RoleViewSimple;

public interface RoleService {

	Integer save(RoleRequestCreate request);

	boolean update(Integer id, RoleRequestUpdate request);

	Collection<RoleViewSimple> read();

	Optional<RoleViewFull> read(Integer id);

}
