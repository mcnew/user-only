package com.github.mcnew.user.configuration;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Optional;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.github.mcnew.user.model.Permission;
import com.github.mcnew.user.repository.PermissionRepository;

@Profile("test")
@Configuration
public class PermissionRepositoryTestConfiguration {

	@Bean
	@Primary
	public PermissionRepository permissionRepository() {
		Permission ce = buildEntity(1, "Ce", "Ce description", "0001", "1000");
		Permission ome = buildEntity(1, "Ome", "Ome description", "0002", "2000");

		PermissionRepository repository = Mockito.mock(PermissionRepository.class);
		Mockito.when(repository.findAll()).thenReturn(Arrays.asList(ce, ome));

		Mockito.when(repository.findById(1)).thenReturn(Optional.of(ce));
		Mockito.when(repository.findById(2)).thenReturn(Optional.of(ome));

		Mockito.when(repository.save(Mockito.any()))
				.thenReturn(buildEntity(1000, "Yonce", "Yonce description", "0220", "2002"));
		return repository;
	}

	Permission buildEntity(Integer id, String name, String description, String codeA, String codeB) {
		Permission entity = new Permission();
		entity.setId(id);
		entity.setName(name);
		entity.setDescription(description);
		entity.setCodeA(codeA);
		entity.setCodeB(codeB);
		entity.setCreated(new Timestamp(System.currentTimeMillis()));
		entity.setUpdated(new Timestamp(System.currentTimeMillis()));
		return entity;
	}

}
