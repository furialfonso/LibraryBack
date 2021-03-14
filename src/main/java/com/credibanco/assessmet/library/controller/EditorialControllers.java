package com.credibanco.assessmet.library.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.credibanco.assessmet.library.model.Editorial;
import com.credibanco.assessmet.library.service.IEditorialService;

@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RestController
@RequestMapping("/editorial")
public class EditorialControllers {

	private final Logger logger = LoggerFactory.getLogger(EditorialControllers.class);

	@Autowired
	private IEditorialService editorialService;

	@GetMapping("/todos")
	public List<Editorial> readResource() {
		return editorialService.findAll();
	}

	@GetMapping("/todos/{id}")
	public Editorial readResource(@PathVariable Long id) {
		return editorialService.findById(id);
	}

	@PostMapping("/crear")
	public ResponseEntity<?> create(@Valid @RequestBody Editorial editorial) {
		return editorialService.save(editorial);
	}

	@PutMapping("/editar/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Editorial editorial, @PathVariable Long id) {
		return editorialService.update(editorial, id);
	}

	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		return editorialService.delete(id);
	}
}