package com.github.mcnew.user.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.mcnew.user.controller.request.RoleRequestCreate;
import com.github.mcnew.user.controller.request.RoleRequestUpdate;
import com.github.mcnew.user.controller.response.RoleViewFull;
import com.github.mcnew.user.controller.response.RoleViewSimple;
import com.github.mcnew.user.model.Role;
import com.github.mcnew.user.model.RolePermission;
import com.github.mcnew.user.repository.RolePermissionRepository;
import com.github.mcnew.user.repository.RoleRepository;
import com.github.mcnew.user.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	private final RoleRepository repository;

	private final RolePermissionRepository relRepository;

	@Autowired
	public RoleServiceImpl(RoleRepository repository, RolePermissionRepository relRepository) {
		this.repository = repository;
		this.relRepository = relRepository;
	}

	@Override
	@Transactional
	public Integer save(RoleRequestCreate request) {
		Role entity = new Role();
		entity.setName(request.getName());
		entity.setDescription(request.getDescription());
		entity = repository.save(entity);
		Integer id = entity.getId();
		request.getPermissions().forEach(pair -> {
			RolePermission rel = new RolePermission();
			rel.setIdRole(id);
			rel.setIdPermission(pair.getId());
			relRepository.save(rel);
		});
		return id;
	}

	@Override
	@Transactional
	public boolean update(Integer id, RoleRequestUpdate request) {
		Optional<Role> optional = repository.findById(id);
		if (optional.isPresent()) {
			Role entity = optional.get();
			entity.setDescription(request.getDescription());
			repository.save(entity);
			relRepository.deleteByRole(entity);
			request.getPermissions().forEach(pair -> {
				RolePermission rel = new RolePermission();
				rel.setIdRole(id);
				rel.setIdPermission(pair.getId());
				relRepository.save(rel);
			});
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Collection<RoleViewSimple> read() {
		List<RoleViewSimple> permissions = new ArrayList<>();
		repository.findAll().forEach(permission -> {
			permissions.add(new RoleViewSimple(permission));
		});
		return permissions;
	}

	@Override
	public Optional<RoleViewFull> read(Integer id) {
		return repository.findById(id).map(entity -> {
			return new RoleViewFull(entity);
		});
	}

}
