package com.github.mcnew.user.controller;

import java.net.URI;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import com.github.mcnew.user.controller.request.RoleRequestCreate;
import com.github.mcnew.user.controller.request.RoleRequestUpdate;
import com.github.mcnew.user.controller.response.RoleViewFull;
import com.github.mcnew.user.service.RoleService;
import com.github.mcnew.user.test.configuration.TConf;
import com.github.mcnew.user.utility.RoleUtil;

@SpringBootTest
@ContextConfiguration(classes = TConf.class)
public class RoleControllerTest {

	private RoleController controller;

	@BeforeEach
	public void setUp() {
		RoleService service = Mockito.mock(RoleService.class);

		Mockito.when(service.read(1))
				.thenReturn(Optional.of(new RoleViewFull(RoleUtil.buildEntity(1, "Ce", "Ce description"))));
		Mockito.when(service.save(Mockito.any())).thenReturn(1);
		Mockito.when(service.update(Mockito.eq(1), Mockito.any())).thenReturn(true);

		controller = new RoleController(service);
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
		RoleRequestCreate request = new RoleRequestCreate();
		request.setName("vince");
		request.setDescription("vince description");

		ResponseEntity<?> response = controller.post(request);
		Assertions.assertNotNull(response);
		Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
		Assertions.assertFalse(response.hasBody());

		URI location = response.getHeaders().getLocation();
		Assertions.assertNotNull(location);
		Assertions.assertTrue(location.toString().endsWith(ControllerConst.URL_ROLES + "/1"));
	}

	@Test
	public void testPutNotFound() {
		RoleRequestUpdate request = new RoleRequestUpdate();
		request.setDescription("vince description");

		ResponseEntity<?> response = controller.put(0, request);
		Assertions.assertNotNull(response);
		Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
		Assertions.assertFalse(response.hasBody());
	}

	@Test
	public void testPutOk() {
		RoleRequestUpdate request = new RoleRequestUpdate();
		request.setDescription("vince description");

		ResponseEntity<?> response = controller.put(1, request);
		Assertions.assertNotNull(response);
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
		Assertions.assertFalse(response.hasBody());
	}

}
