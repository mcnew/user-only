package com.github.mcnew.user.repository;

import org.springframework.data.repository.CrudRepository;

import com.github.mcnew.user.model.RolePermission;
import com.github.mcnew.user.model.id.RolePermissionId;

public interface RolePermissionRepository extends CrudRepository<RolePermission, RolePermissionId> {

}
