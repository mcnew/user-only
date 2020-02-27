package com.github.mcnew.user.service.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.github.mcnew.user.controller.request.PairParameterRequest;
import com.github.mcnew.user.controller.request.RoleRequestCreate;
import com.github.mcnew.user.controller.request.RoleRequestUpdate;
import com.github.mcnew.user.controller.response.RoleViewFull;
import com.github.mcnew.user.controller.response.RoleViewSimple;
import com.github.mcnew.user.model.Role;
import com.github.mcnew.user.repository.PermissionRepository;
import com.github.mcnew.user.repository.RoleRepository;
import com.github.mcnew.user.service.RoleService;
import com.github.mcnew.user.utility.PermissionUtil;
import com.github.mcnew.user.utility.RoleUtil;

public class RoleServiceImplTest {

	private RoleRepository repository;

	private RoleService service;

	@BeforeEach
	public void setUp() {
		Role ce = RoleUtil.buildEntity(1, "Ce", "Ce description");
		Role ome = RoleUtil.buildEntity(1, "Ome", "Ome description");

		repository = Mockito.mock(RoleRepository.class);
		Mockito.when(repository.findAll()).thenReturn(Arrays.asList(ce, ome));

		Mockito.when(repository.findById(1)).thenReturn(Optional.of(ce));
		Mockito.when(repository.findById(2)).thenReturn(Optional.of(ome));

		Mockito.when(repository.save(Mockito.any()))
				.thenReturn(RoleUtil.buildEntity(1000, "Yonce", "Yonce description"));

		PermissionRepository permissionRepositor = Mockito.mock(PermissionRepository.class);

		Mockito.when(permissionRepositor.findById(Mockito.eq(1)))
				.thenReturn(Optional.of(PermissionUtil.buildEntity(1, "uno", "uno desc", "2222", "3333")));
		Mockito.when(permissionRepositor.findById(Mockito.eq(2)))
				.thenReturn(Optional.of(PermissionUtil.buildEntity(2, "dos", "dos desc", "2288", "3344")));

		service = new RoleServiceImpl(repository, permissionRepositor);
	}

	@Test
	public void testRead0() {
		Collection<RoleViewSimple> list = service.read();
		Assertions.assertNotNull(list);
		Assertions.assertEquals(2, list.size());
	}

	@Test
	public void testRead1Present() {
		Optional<RoleViewFull> optional = service.read(1);
		Assertions.assertNotNull(optional);
		Assertions.assertTrue(optional.isPresent());
	}

	@Test
	public void testRead1NotPresent() {
		Optional<RoleViewFull> optional = service.read(0);
		Assertions.assertNotNull(optional);
		Assertions.assertFalse(optional.isPresent());
	}

	@Test
	public void testUpdatePresent() {
		RoleRequestUpdate request = new RoleRequestUpdate();
		request.setDescription("alpha");
		request.setPermissions(Collections.emptySet());
		Assertions.assertTrue(service.update(2, request));
	}

	@Test
	public void testUpdateNotPresent() {
		RoleRequestUpdate request = new RoleRequestUpdate();
		request.setDescription("alpha");
		Assertions.assertFalse(service.update(0, request));
	}

	@Test
	public void testSave() {
		RoleRequestCreate request = new RoleRequestCreate();
		request.setName("Eyi");
		request.setDescription("Eyi Description");
		request.setPermissions(Arrays.asList(1, 2).stream().map(idPermission -> {
			PairParameterRequest pair = new PairParameterRequest();
			pair.setId(idPermission);
			return pair;
		}).collect(Collectors.toSet()));
		Assertions.assertEquals(Integer.valueOf(1000), service.save(request));
		Mockito.verify(repository, Mockito.times(1)).save(Mockito.any());
	}

}
