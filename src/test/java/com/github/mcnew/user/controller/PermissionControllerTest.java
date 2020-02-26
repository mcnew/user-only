package com.github.mcnew.user.controller;

import java.net.URI;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.github.mcnew.user.controller.request.PermissionRequestCreate;
import com.github.mcnew.user.controller.request.PermissionRequestUpdate;
import com.github.mcnew.user.controller.response.PermissionViewFull;
import com.github.mcnew.user.service.PermissionService;
import com.github.mcnew.user.utility.PermissionUtil;

@SpringBootTest
public class PermissionControllerTest {

	@Autowired
	private PermissionController controller;

	@BeforeEach
	public void setUp() {
		PermissionService service = Mockito.mock(PermissionService.class);

		Mockito.when(service.read(1)).thenReturn(Optional
				.of(new PermissionViewFull(PermissionUtil.buildEntity(1, "Ce", "Ce description", "0001", "1000"))));
		Mockito.when(service.save(Mockito.any())).thenReturn(1);
		Mockito.when(service.update(Mockito.eq(1), Mockito.any())).thenReturn(true);

		controller = new PermissionController(service);
	}

	@Test
	public void testGet0() {
		ResponseEntity<?> response = controller.get();
		Assertions.assertNotNull(response);
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
		Assertions.assertTrue(response.hasBody());
	}

	@Test
	public void testGetNotFound() {
		ResponseEntity<?> response = controller.get(0);
		Assertions.assertNotNull(response);
		Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
		Assertions.assertFalse(response.hasBody());
	}

	@Test
	public void testGetOk() {
		ResponseEntity<?> response = controller.get(1);
		Assertions.assertNotNull(response);
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
		Assertions.assertTrue(response.hasBody());
	}

	@Test
	public void testPostOk() {
		PermissionRequestCreate request = new PermissionRequestCreate();
		request.setName("vince");
		request.setDescription("vince description");
		request.setCodeA("8008");
		request.setCodeB("0880");

		ResponseEntity<?> response = controller.post(request);
		Assertions.assertNotNull(response);
		Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
		Assertions.assertFalse(response.hasBody());

		URI location = response.getHeaders().getLocation();
		Assertions.assertNotNull(location);
		Assertions.assertTrue(location.toString().endsWith("/permissions/1"));
	}

	@Test
	public void testPutNotFound() {
		PermissionRequestUpdate request = new PermissionRequestUpdate();
		request.setDescription("vince description");
		request.setCodeA("8008");
		request.setCodeB("0880");

		ResponseEntity<?> response = controller.put(0, request);
		Assertions.assertNotNull(response);
		Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
		Assertions.assertFalse(response.hasBody());
	}

	@Test
	public void testPutOk() {
		PermissionRequestUpdate request = new PermissionRequestUpdate();
		request.setDescription("vince description");
		request.setCodeA("8008");
		request.setCodeB("0880");

		ResponseEntity<?> response = controller.put(1, request);
		Assertions.assertNotNull(response);
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
		Assertions.assertFalse(response.hasBody());
	}

}
