package com.github.mcnew.user.service;

import java.util.Collection;
import java.util.Optional;

import com.github.mcnew.user.controller.request.PermissionRequestCreate;
import com.github.mcnew.user.controller.request.PermissionRequestUpdate;
import com.github.mcnew.user.controller.response.PermissionViewFull;
import com.github.mcnew.user.controller.response.PermissionViewSimple;

public interface PermissionService {

	Integer save(PermissionRequestCreate request);

	boolean update(Integer id, PermissionRequestUpdate request);

	Collection<PermissionViewSimple> read();

	Optional<PermissionViewFull> read(Integer id);

}
