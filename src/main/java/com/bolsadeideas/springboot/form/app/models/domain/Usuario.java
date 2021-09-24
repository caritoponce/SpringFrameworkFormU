package com.bolsadeideas.springboot.form.app.models.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Usuario {
	
	//@Pattern(regexp="[0-9]{2}[.,][\\d]{3}[.,][\\d]{3}[-][A-Z]{1}")
	private String identifier;
	
	//@NotEmpty
	private String name;
	
	@NotEmpty
	private String lastname;
	
	@NotEmpty
	@Size(min=3, max=8)
	private String username;
	
    @NotEmpty
	private String password;
	
    @NotEmpty 
    @Email
    private String email;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

}
