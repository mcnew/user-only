package com.github.mcnew.user.controller;

import java.net.URI;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.mcnew.user.configuration.PermissionServiceTestConfiguration;
import com.github.mcnew.user.controller.request.PermissionRequestCreate;
import com.github.mcnew.user.controller.request.PermissionRequestUpdate;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ContextConfiguration(classes = { PermissionServiceTestConfiguration.class,
		PermissionController.class }, inheritLocations = false)
public class PermissionControllerTest {

	@Autowired
	private PermissionController controller;

	@Test
	public void testGet0() {
		ResponseEntity<?> response = controller.get();
		Assert.assertNotNull(response);
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
		Assert.assertTrue(response.hasBody());
	}

	@Test
	public void testGetNotFound() {
		ResponseEntity<?> response = controller.get(0);
		Assert.assertNotNull(response);
		Assert.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
		Assert.assertFalse(response.hasBody());
	}

	@Test
	public void testGetOk() {
		ResponseEntity<?> response = controller.get(1);
		Assert.assertNotNull(response);
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
		Assert.assertTrue(response.hasBody());
	}

	@Test
	public void testPostOk() {
		PermissionRequestCreate request = new PermissionRequestCreate();
		request.setName("vince");
		request.setDescription("vince description");
		request.setCodeA("8008");
		request.setCodeB("0880");

		ResponseEntity<?> response = controller.post(request);
		Assert.assertNotNull(response);
		Assert.assertEquals(HttpStatus.CREATED, response.getStatusCode());
		Assert.assertFalse(response.hasBody());

		URI location = response.getHeaders().getLocation();
		Assert.assertNotNull(location);
		Assert.assertTrue(location.toString().endsWith("/permissions/1"));
	}

	@Test
	public void testPutNotFound() {
		PermissionRequestUpdate request = new PermissionRequestUpdate();
		request.setDescription("vince description");
		request.setCodeA("8008");
		request.setCodeB("0880");

		ResponseEntity<?> response = controller.put(0, request);
		Assert.assertNotNull(response);
		Assert.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
		Assert.assertFalse(response.hasBody());
	}

	@Test
	public void testPutOk() {
		PermissionRequestUpdate request = new PermissionRequestUpdate();
		request.setDescription("vince description");
		request.setCodeA("8008");
		request.setCodeB("0880");

		ResponseEntity<?> response = controller.put(1, request);
		Assert.assertNotNull(response);
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
		Assert.assertFalse(response.hasBody());
	}

}
