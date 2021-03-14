package com.credibanco.assessmet.library.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.credibanco.assessmet.library.model.Book;

public interface IBookService {

	public List<Book> findAll();

	public Book findById(Long id);

	public ResponseEntity<Map<String, Object>> save(Book book);
	
	public ResponseEntity<Map<String, Object>> update(Book book, Long id);

	public ResponseEntity<Map<String, Object>> delete(Long id);
}
