package com.github.mcnew.user.repository;

import org.springframework.data.repository.CrudRepository;

import com.github.mcnew.user.model.Permission;

public interface PermissionRepository extends CrudRepository<Permission, Integer> {

}
