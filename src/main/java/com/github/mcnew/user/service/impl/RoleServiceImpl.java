package com.github.mcnew.user.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.github.mcnew.user.controller.request.RoleRequestCreate;
import com.github.mcnew.user.controller.request.RoleRequestUpdate;
import com.github.mcnew.user.controller.response.RoleViewFull;
import com.github.mcnew.user.controller.response.RoleViewSimple;
import com.github.mcnew.user.model.Permission;
import com.github.mcnew.user.model.Role;
import com.github.mcnew.user.repository.PermissionRepository;
import com.github.mcnew.user.repository.RoleRepository;
import com.github.mcnew.user.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	private final RoleRepository repository;

	private final PermissionRepository permissionRepository;

	@Autowired
	public RoleServiceImpl(RoleRepository repository, PermissionRepository permissionRepository) {
		this.repository = repository;
		this.permissionRepository = permissionRepository;
	}

	@Override
	@Transactional
	public Integer save(RoleRequestCreate request) {
		Role entity = new Role();
		entity.setName(request.getName());
		entity.setDescription(request.getDescription());
		entity.setPermissions(request.getPermissions().stream().map(pair -> {
			Optional<Permission> optional = permissionRepository.findById(pair.getId());
			if (optional.isPresent()) {
				return optional.get();
			} else {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
						"Permission id = " + pair.getId() + ": Does not exist");
			}
		}).collect(Collectors.toList()));
		entity = repository.save(entity);
		return entity.getId();
	}

	@Override
	@Transactional
	public boolean update(Integer id, RoleRequestUpdate request) {
		Optional<Role> optional = repository.findById(id);
		if (optional.isPresent()) {
			Role entity = optional.get();
			entity.setDescription(request.getDescription());
			entity.setPermissions(request.getPermissions().stream().map(pair -> {
				Optional<Permission> temp = permissionRepository.findById(pair.getId());
				if (temp.isPresent()) {
					return temp.get();
				} else {
					throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
							"Permission id = " + pair.getId() + ": Does not exist");
				}
			}).collect(Collectors.toList()));
			repository.save(entity);
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
