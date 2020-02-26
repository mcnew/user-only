package com.github.mcnew.user.service.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.github.mcnew.user.controller.request.PermissionRequestCreate;
import com.github.mcnew.user.controller.request.PermissionRequestUpdate;
import com.github.mcnew.user.controller.response.PermissionViewFull;
import com.github.mcnew.user.controller.response.PermissionViewSimple;
import com.github.mcnew.user.model.Permission;
import com.github.mcnew.user.repository.PermissionRepository;
import com.github.mcnew.user.service.PermissionService;
import com.github.mcnew.user.utility.PermissionUtil;

public class PermissionServiceImplTest {

	private PermissionRepository repository;

	private PermissionService service;

	@BeforeEach
	public void setUp() {
		Permission ce = PermissionUtil.buildEntity(1, "Ce", "Ce description", "0001", "1000");
		Permission ome = PermissionUtil.buildEntity(1, "Ome", "Ome description", "0002", "2000");

		repository = Mockito.mock(PermissionRepository.class);
		Mockito.when(repository.findAll()).thenReturn(Arrays.asList(ce, ome));

		Mockito.when(repository.findById(1)).thenReturn(Optional.of(ce));
		Mockito.when(repository.findById(2)).thenReturn(Optional.of(ome));

		Mockito.when(repository.save(Mockito.any()))
				.thenReturn(PermissionUtil.buildEntity(1000, "Yonce", "Yonce description", "0220", "2002"));

		service = new PermissionServiceImpl(repository);
	}

	@Test
	public void testRead0() {
		Collection<PermissionViewSimple> list = service.read();
		Assertions.assertNotNull(list);
		Assertions.assertEquals(2, list.size());
	}

	@Test
	public void testRead1Present() {
		Optional<PermissionViewFull> optional = service.read(1);
		Assertions.assertNotNull(optional);
		Assertions.assertTrue(optional.isPresent());
	}

	@Test
	public void testRead1NotPresent() {
		Optional<PermissionViewFull> optional = service.read(0);
		Assertions.assertNotNull(optional);
		Assertions.assertFalse(optional.isPresent());
	}

	@Test
	public void testUpdatePresent() {
		PermissionRequestUpdate request = new PermissionRequestUpdate();
		request.setDescription("alpha");
		request.setCodeA("9000");
		request.setCodeB("0009");
		Assertions.assertTrue(service.update(2, request));
	}

	@Test
	public void testUpdateNotPresent() {
		PermissionRequestUpdate request = new PermissionRequestUpdate();
		request.setDescription("alpha");
		request.setCodeA("9000");
		request.setCodeB("0009");
		Assertions.assertFalse(service.update(0, request));
	}

	@Test
	public void testSave() {
		PermissionRequestCreate request = new PermissionRequestCreate();
		request.setName("Eyi");
		request.setDescription("Eyi Description");
		request.setCodeA("5000");
		request.setCodeB("0004");
		Assertions.assertEquals(Integer.valueOf(1000), service.save(request));
		Mockito.verify(repository, Mockito.times(1)).save(Mockito.any());
	}

}
