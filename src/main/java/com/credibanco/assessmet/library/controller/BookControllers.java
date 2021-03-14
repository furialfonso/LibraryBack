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

import com.credibanco.assessmet.library.model.Book;
import com.credibanco.assessmet.library.service.IBookService;

@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RestController
@RequestMapping("/book")
public class BookControllers {
	private final Logger logger = LoggerFactory.getLogger(BookControllers.class);

	@Autowired
	private IBookService bookService;

	@GetMapping("/todos")
	public List<Book> readResource() {
		return bookService.findAll();
	}

	@GetMapping("/todos/{id}")
	public Book readResource(@PathVariable Long id) {
		return bookService.findById(id);
	}

	@PostMapping("/crear")
	public ResponseEntity<?> create(@Valid @RequestBody Book book) {
		logger.info(book.toString());
		return bookService.save(book);
	}

	@PutMapping("/editar/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Book book, @PathVariable Long id) {
		return bookService.update(book, id);
	}

	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		return bookService.delete(id);
	}
}