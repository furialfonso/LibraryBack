package com.credibanco.assessmet.library.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.credibanco.assessmet.library.model.Author;

public interface IAuthorDao extends JpaRepository<Author, Long> {

}
