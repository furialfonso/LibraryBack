package com.credibanco.assessmet.library.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.credibanco.assessmet.library.model.Author;
import com.credibanco.assessmet.library.service.IAuthorService;

@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RestController
@RequestMapping("/author")
public class AuthorControllers {

	@Autowired
	private IAuthorService authorService;

	@GetMapping("/todos")
	public List<Author> readResource() {
		return authorService.findAll();
	}

	@GetMapping("/todos/{id}")
	public Author readResource(@PathVariable Long id) {
		return authorService.findById(id);
	}

	@PostMapping("/crear")
	public ResponseEntity<?> create(@Valid @RequestBody Author author) {
		return authorService.save(author);
	}

	@PutMapping("/editar/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Author author, @PathVariable Long id) {
		return authorService.update(author, id);
	}

	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		return authorService.delete(id);
	}
}