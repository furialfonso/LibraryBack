package com.credibanco.assessmet.library.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.credibanco.assessmet.library.dao.IBookDao;
import com.credibanco.assessmet.library.model.Book;
import com.credibanco.assessmet.library.service.IBookService;

@Service
public class BookServiceImpl implements IBookService {
	private final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);
	@Autowired
	private IBookDao bookDao;

	@Override
	public List<Book> findAll() {
		return bookDao.findAll();
	}

	@Override
	public Book findById(Long id) {
		return bookDao.findById(id).orElse(null);
	}

	@Override
	public ResponseEntity<Map<String, Object>> save(Book book) {
		Book bookNew = null;
		Map<String, Object> response = new HashMap<>();
		logger.info("max:" + book.getEditorial().getMaximumBooks());
		logger.info("tot:" + book.getEditorial().getBooks().size());
		if (book.getEditorial().getMaximumBooks() != null
				&& book.getEditorial().getBooks().size() >= book.getEditorial().getMaximumBooks()) {
			response.put("mensaje", "No es posible registrar el libro, se alcanzo el maximo permitido.");
			response.put("error", "Regla de negocio");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		try {
			bookNew = bookDao.save(book);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error guardando el libro");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "Lirbo creado con éxito!");
		response.put("book", bookNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<Map<String, Object>> update(Book book, Long id) {
		Book bookOld = this.findById(id);
		Book bookUpdated = null;
		Map<String, Object> response = new HashMap<>();
		if (bookOld == null) {
			response.put("mensaje", "Error: no se pudo editar, el libro ID: "
					.concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {

			bookOld.setTitle(book.getTitle());
			bookOld.setYear(book.getYear());
			bookOld.setGender(book.getGender());
			bookOld.setNumPages(book.getNumPages());
			bookOld.setAuthor(book.getAuthor());
			bookOld.setEditorial(book.getEditorial());
			bookUpdated = bookDao.save(bookOld);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar el libro en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Libro actualizado con éxito!");
		response.put("book", bookUpdated);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

	}

	@Override
	public ResponseEntity<Map<String, Object>> delete(Long id) {
		Map<String, Object> response = new HashMap<>();
		Book book = this.findById(id);
		if (book == null) {
			response.put("mensaje", "Error: no se pudo Eliminar el libro ID: "
					.concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {
			bookDao.deleteById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar el libro en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "Libro eliminado con éxito!");

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

	}
}
