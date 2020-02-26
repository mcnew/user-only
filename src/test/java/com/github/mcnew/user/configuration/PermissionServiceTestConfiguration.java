package com.github.mcnew.user.configuration;

import java.sql.Timestamp;
import java.util.Optional;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.github.mcnew.user.controller.response.PermissionViewFull;
import com.github.mcnew.user.model.Permission;
import com.github.mcnew.user.service.PermissionService;

@Profile("test")
@Configuration
public class PermissionServiceTestConfiguration {

	@Bean
	@Primary
	public PermissionService permissionService() {

		PermissionService service = Mockito.mock(PermissionService.class);

		Mockito.when(service.read(1))
				.thenReturn(Optional.of(new PermissionViewFull(permission(1, "Ce", "Ce description", "0001", "1000"))));
		Mockito.when(service.save(Mockito.any())).thenReturn(1);
		Mockito.when(service.update(Mockito.eq(1), Mockito.any())).thenReturn(true);

		return service;
	}

	Permission permission(Integer id, String name, String description, String codeA, String codeB) {
		Permission permission = new Permission();
		permission.setId(id);
		permission.setName(name);
		permission.setDescription(description);
		permission.setCodeA(codeA);
		permission.setCodeB(codeB);
		permission.setCreated(new Timestamp(System.currentTimeMillis()));
		permission.setUpdated(new Timestamp(System.currentTimeMillis()));
		return permission;
	}

}
