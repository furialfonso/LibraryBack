package com.credibanco.assessmet.library.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.credibanco.assessmet.library.model.Editorial;

public interface IEditorialService {

	public List<Editorial> findAll();

	public Editorial findById(Long id);

	public ResponseEntity<Map<String, Object>> save(Editorial editorial);
	
	public ResponseEntity<Map<String, Object>> update(Editorial editorial, Long id);

	public ResponseEntity<Map<String, Object>> delete(Long id);
}
