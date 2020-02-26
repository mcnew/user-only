package com.github.mcnew.user.service.impl;

import java.util.Collection;
import java.util.Optional;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.mcnew.user.configuration.PermissionRepositoryTestConfiguration;
import com.github.mcnew.user.controller.request.PermissionRequestCreate;
import com.github.mcnew.user.controller.request.PermissionRequestUpdate;
import com.github.mcnew.user.controller.response.PermissionViewFull;
import com.github.mcnew.user.controller.response.PermissionViewSimple;
import com.github.mcnew.user.repository.PermissionRepository;
import com.github.mcnew.user.service.PermissionService;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ContextConfiguration(classes = { PermissionRepositoryTestConfiguration.class,
		PermissionServiceImpl.class }, inheritLocations = false)
public class PermissionServiceImplTest {

	@Autowired
	private PermissionRepository repository;

	@Autowired
	private PermissionService service;

	@Test
	public void testRead0() {
		Collection<PermissionViewSimple> list = service.read();
		Assert.assertNotNull(list);
		Assert.assertEquals(2, list.size());
	}

	@Test
	public void testRead1Present() {
		Optional<PermissionViewFull> optional = service.read(1);
		Assert.assertNotNull(optional);
		Assert.assertTrue(optional.isPresent());
	}

	@Test
	public void testRead1NotPresent() {
		Optional<PermissionViewFull> optional = service.read(0);
		Assert.assertNotNull(optional);
		Assert.assertFalse(optional.isPresent());
	}

	@Test
	public void testUpdatePresent() {
		PermissionRequestUpdate request = new PermissionRequestUpdate();
		request.setDescription("alpha");
		request.setCodeA("9000");
		request.setCodeB("0009");
		Assert.assertTrue(service.update(2, request));
		System.out.println(service.read(2).get().getDescription());
	}

	@Test
	public void testUpdateNotPresent() {
		PermissionRequestUpdate request = new PermissionRequestUpdate();
		request.setDescription("alpha");
		request.setCodeA("9000");
		request.setCodeB("0009");
		Assert.assertFalse(service.update(0, request));
	}

	@Test
	public void testSave() {
		PermissionRequestCreate request = new PermissionRequestCreate();
		request.setName("Eyi");
		request.setDescription("Eyi Description");
		request.setCodeA("5000");
		request.setCodeB("0004");
		Assert.assertEquals(Integer.valueOf(1000), service.save(request));
		Mockito.verify(repository, Mockito.times(1)).save(Mockito.any());
	}

}
