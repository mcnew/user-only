package com.github.mcnew.user.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.mcnew.user.controller.request.PermissionRequestCreate;
import com.github.mcnew.user.controller.request.PermissionRequestUpdate;
import com.github.mcnew.user.controller.response.PermissionViewFull;
import com.github.mcnew.user.controller.response.PermissionViewSimple;
import com.github.mcnew.user.model.Permission;
import com.github.mcnew.user.repository.PermissionRepository;
import com.github.mcnew.user.service.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService {

	private final PermissionRepository repository;

	@Autowired
	public PermissionServiceImpl(PermissionRepository repository) {
		this.repository = repository;
	}

	@Override
	public Integer create(PermissionRequestCreate request) {
		Permission entity = new Permission();
		entity.setName(request.getName());
		entity.setDescription(request.getDescription());
		entity.setCodeA(request.getCodeA());
		entity.setCodeB(request.getCodeB());
		entity = repository.save(entity);
		return entity.getId();
	}

	@Override
	public boolean update(Integer id, PermissionRequestUpdate request) {
		Optional<Permission> optional = repository.findById(id);
		if (optional.isPresent()) {
			Permission entity = optional.get();
			entity.setDescription(request.getDescription());
			entity.setCodeA(request.getCodeA());
			entity.setCodeB(request.getCodeB());
			this.repository.save(entity);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Collection<PermissionViewSimple> read() {
		List<PermissionViewSimple> permissions = new ArrayList<>();
		repository.findAll().forEach(permission -> {
			permissions.add(new PermissionViewSimple(permission));
		});
		return permissions;
	}

	@Override
	public Optional<PermissionViewFull> read(Integer id) {
		return repository.findById(id).map(entity -> {
			return new PermissionViewFull(entity);
		});
	}

}
