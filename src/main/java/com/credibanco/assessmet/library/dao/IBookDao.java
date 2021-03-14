package com.credibanco.assessmet.library.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.credibanco.assessmet.library.model.Book;

public interface IBookDao extends JpaRepository<Book, Long> {

}
