package com.credibanco.assessmet.library.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.credibanco.assessmet.library.dao.IAuthorDao;
import com.credibanco.assessmet.library.model.Author;
import com.credibanco.assessmet.library.service.IAuthorService;

@Service
public class AuthorServiceImpl implements IAuthorService {

	@Autowired
	private IAuthorDao authorDao;

	@Override
	public List<Author> findAll() {
		return authorDao.findAll();
	}

	@Override
	public Author findById(Long id) {
		return authorDao.findById(id).orElse(null);
	}

	@Override
	public ResponseEntity<Map<String, Object>> save(Author author) {
		Author authorNew = null;
		Map<String, Object> response = new HashMap<>();

		try {
			authorNew = authorDao.save(author);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error guardando el Autor");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "Autor creado con éxito!");
		response.put("author", authorNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@Override
	public ResponseEntity<Map<String, Object>> update(Author author, Long id) {
		Author authorOld = this.findById(id);
		Author authorUpdated = null;
		Map<String, Object> response = new HashMap<>();
		if (authorOld == null) {
			response.put("mensaje", "Error: no se pudo editar, el autor ID: "
					.concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {

			authorOld.setName(author.getName());
			authorOld.setBirthDate(author.getBirthDate());
			authorOld.setCityOrigin(author.getCityOrigin());
			authorOld.setEmail(author.getEmail());
			authorUpdated = authorDao.save(authorOld);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar el autor en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Autor actualizado con éxito!");
		response.put("author", authorUpdated);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}


	@Override
	public ResponseEntity<Map<String, Object>> delete(Long id) {
		Map<String, Object> response = new HashMap<>();
		Author author = this.findById(id);
		if (author == null) {
			response.put("mensaje", "Error: no se pudo Eliminar el autor ID: "
					.concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {
			authorDao.deleteById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar el autor en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "Autor eliminado con éxito!");

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);		
	}
}
