package com.vinhnguyen.crudapi.entites;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "account")
public class Account {
	@Id
	@Column(name = "id")
	private int id;
	@NotNull
	@Column(name = "username")
	private String username;
	@NotNull
	@Column(name = "password")
	private String password;
	@Column(name = "role")
	private String role;
	@Column(name = "userid")
	private int userid;
	@Column(name = "created_at")
	private Date created_at;
	@Column(name = "updated_at")
	private Date updated_at;

	public Account() {
		super();
		this.created_at = new Date(new java.util.Date().getTime());
		this.updated_at = new Date(new java.util.Date().getTime());
	}

	public Account(String username, String password, String role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
		this.created_at = new Date(new java.util.Date().getTime());
		this.updated_at = new Date(new java.util.Date().getTime());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userId) {
		this.userid = userId;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
