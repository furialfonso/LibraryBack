package com.credibanco.assessmet.library.dto;

import java.util.Date;

public class AuthorDTO {
	private Integer id;
	private String name;
	private Date birthDate;
	private String cityOrigin;
	private String email;

	public AuthorDTO() {
	}

	public AuthorDTO(Integer id, String name, Date birthDate, String cityOrigin, String email) {
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.cityOrigin = cityOrigin;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getCityOrigin() {
		return cityOrigin;
	}

	public void setCityOrigin(String cityOrigin) {
		this.cityOrigin = cityOrigin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
