package com.credibanco.assessmet.library.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_id_books")
	@SequenceGenerator(name = "sec_id_books", sequenceName = "sec_id_books", allocationSize = 1)
	private Long id;
	@Column(nullable = false)
	private String title;
	private String year;
	@Column(nullable = false)
	private String gender;
	@Column(nullable = false)
	private Long numPages;

	@JsonIgnoreProperties(value = { "books", "hibernateLazyInitializer", "handler" }, allowSetters = true)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Author author;

	@JsonIgnoreProperties(value = { "books", "hibernateLazyInitializer", "handler" }, allowSetters = true)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Editorial editorial;
}
