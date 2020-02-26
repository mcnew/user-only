package com.github.mcnew.user.controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.github.mcnew.user.controller.request.PermissionRequestCreate;
import com.github.mcnew.user.controller.request.PermissionRequestUpdate;
import com.github.mcnew.user.controller.response.PermissionViewFull;
import com.github.mcnew.user.controller.response.PermissionViewSimple;
import com.github.mcnew.user.service.PermissionService;

@RestController
@RequestMapping(path = "/permissions")
public class PermissionController {

	private final PermissionService service;

	@Autowired
	public PermissionController(PermissionService service) {
		this.service = service;
	}

	@GetMapping(produces = ControllerConst.CONTENT_TYPE_JSON)
	public ResponseEntity<Collection<PermissionViewSimple>> get() {
		return ResponseEntity.ok(service.read());
	}

	@GetMapping(path = "/{id}", produces = ControllerConst.CONTENT_TYPE_JSON)
	public ResponseEntity<PermissionViewFull> get(@PathVariable("id") Integer id) {
		Optional<PermissionViewFull> optional = service.read(id);
		if (optional.isPresent()) {
			return ResponseEntity.ok(optional.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping(consumes = ControllerConst.CONTENT_TYPE_JSON)
	public ResponseEntity<Void> post(@Validated @RequestBody PermissionRequestCreate request) {
		return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/permissions/{id}")
				.buildAndExpand(service.save(request)).toUri()).build();
	}

	@PutMapping(path = "/{id}", consumes = ControllerConst.CONTENT_TYPE_JSON)
	public ResponseEntity<Void> put(@PathVariable("id") Integer id,
			@Validated @RequestBody PermissionRequestUpdate request) {
		if (service.update(id, request)) {
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
