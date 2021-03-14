package com.credibanco.assessmet.library.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Author implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_id_author")
	@SequenceGenerator(name = "sec_id_author", sequenceName = "sec_id_author", allocationSize = 1)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = true)
	@Temporal(TemporalType.DATE)
	private Date birthDate;

	@Column(nullable = true)
	private String cityOrigin;

	@Column(nullable = true)
	private String email;

	@JsonIgnoreProperties(value = { "author", "hibernateLazyInitializer", "handler" }, allowSetters = true)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "author", cascade = CascadeType.ALL)
	private List<Book> books;

}