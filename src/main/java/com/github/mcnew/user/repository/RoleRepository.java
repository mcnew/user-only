package com.github.mcnew.user.repository;

import org.springframework.data.repository.CrudRepository;

import com.github.mcnew.user.model.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {

}
