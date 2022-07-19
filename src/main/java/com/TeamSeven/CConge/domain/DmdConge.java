package com.TeamSeven.CConge.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class DmdConge {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(updatable = false, unique = true)
	private Date dateDebutC;
	private Date dateFinC;
	@NotBlank(message = "code de congée est obligatoire.")
	private String congesCode;
	
	private String username;
	
	private String description;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="userDmdConges_id", updatable = false, nullable = false)
	@JsonIgnore
	private UserDmdConges userDmdConges;

	
	
	
	public DmdConge() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateDebutC() {
		return dateDebutC;
	}

	public void setDateDebutC(Date dateDebutC) {
		this.dateDebutC = dateDebutC;
	}

	public Date getDateFinC() {
		return dateFinC;
	}

	public void setDateFinC(Date dateFinC) {
		this.dateFinC = dateFinC;
	}

	public String getCongesCode() {
		return congesCode;
	}

	public void setCongesCode(String congesCode) {
		this.congesCode = congesCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public UserDmdConges getUserDmdConges() {
		return userDmdConges;
	}

	public void setUserDmdConges(UserDmdConges userDmdConges) {
		this.userDmdConges = userDmdConges;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
	
	
	
	
	
	
}
