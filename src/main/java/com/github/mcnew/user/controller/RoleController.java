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

import com.github.mcnew.user.controller.request.RoleRequestCreate;
import com.github.mcnew.user.controller.request.RoleRequestUpdate;
import com.github.mcnew.user.controller.response.RoleViewFull;
import com.github.mcnew.user.controller.response.RoleViewSimple;
import com.github.mcnew.user.service.RoleService;

@RestController
@RequestMapping(path = ControllerConst.URL_ROLES)
public class RoleController {

	private final RoleService service;

	@Autowired
	public RoleController(RoleService service) {
		this.service = service;
	}

	@GetMapping(produces = ControllerConst.CONTENT_TYPE_JSON)
	public ResponseEntity<Collection<RoleViewSimple>> get() {
		return ResponseEntity.ok(service.read());
	}

	@GetMapping(path = ControllerConst.PRM_ID, produces = ControllerConst.CONTENT_TYPE_JSON)
	public ResponseEntity<RoleViewFull> get(@PathVariable("id") Integer id) {
		Optional<RoleViewFull> optional = service.read(id);
		if (optional.isPresent()) {
			return ResponseEntity.ok(optional.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping(consumes = ControllerConst.CONTENT_TYPE_JSON)
	public ResponseEntity<Void> post(@Validated @RequestBody RoleRequestCreate request) {
		return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
				.path(ControllerConst.URL_ROLES + ControllerConst.PRM_ID).buildAndExpand(service.save(request)).toUri())
				.build();
	}

	@PutMapping(path = ControllerConst.PRM_ID, consumes = ControllerConst.CONTENT_TYPE_JSON)
	public ResponseEntity<Void> put(@PathVariable("id") Integer id, @Validated @RequestBody RoleRequestUpdate request) {
		if (service.update(id, request)) {
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
