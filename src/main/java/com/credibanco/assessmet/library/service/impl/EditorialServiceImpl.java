package com.credibanco.assessmet.library.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.credibanco.assessmet.library.dao.IEditorialDao;
import com.credibanco.assessmet.library.model.Editorial;
import com.credibanco.assessmet.library.service.IEditorialService;

@Service
public class EditorialServiceImpl implements IEditorialService {

	@Autowired
	private IEditorialDao editorialDao;

	@Override
	public List<Editorial> findAll() {
		return editorialDao.findAll();
	}

	@Override
	public Editorial findById(Long id) {
		return editorialDao.findById(id).orElse(null);
	}

	@Override
	public ResponseEntity<Map<String, Object>> save(Editorial editorial) {
		Editorial editorialNew = null;
		Map<String, Object> response = new HashMap<>();

		try {
			editorialNew = editorialDao.save(editorial);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error guardando la editorial");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "Editorial creada con éxito!");
		response.put("editorial", editorialNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<Map<String, Object>> update(Editorial editorial, Long id) {
		Editorial editorialOld = this.findById(id);
		Editorial editorialUpdated = null;
		Map<String, Object> response = new HashMap<>();
		if (editorialOld == null) {
			response.put("mensaje", "Error: no se pudo editar, la editorial ID: "
					.concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {

			editorialOld.setName(editorial.getName());
			editorialOld.setAddress(editorial.getAddress());
			editorialOld.setPhone(editorial.getPhone());
			editorialOld.setEmail(editorial.getEmail());
			editorialOld.setMaximumBooks(editorial.getMaximumBooks());

			editorialUpdated = editorialDao.save(editorialOld);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar la editorial en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Editorial actualizada con éxito!");
		response.put("editorial", editorialUpdated);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<Map<String, Object>> delete(Long id) {
		Map<String, Object> response = new HashMap<>();
		Editorial editorial = this.findById(id);
		if (editorial == null) {
			response.put("mensaje", "Error: no se pudo Eliminar la editorial ID: "
					.concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {
			editorialDao.deleteById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar la editorial en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "Editorial eliminada con éxito!");

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

	}
}
