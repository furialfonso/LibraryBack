package com.credibanco.assessmet.library.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.credibanco.assessmet.library.model.Author;

public interface IAuthorService {

	public List<Author> findAll();

	public Author findById(Long id);

	public ResponseEntity<Map<String, Object>> save(Author author);
	
	public ResponseEntity<Map<String, Object>> update(Author author, Long id);

	public ResponseEntity<Map<String, Object>> delete(Long id);
}
