package com.rulemanager.entities;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;


@EntityListeners(AuditingEntityListener.class)
@Entity
public class App {


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getLastModified() {
		return lastModified;
	}
	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="appId")
	private int id;
	
	@NotNull
	@Column(name="appTitle")
	private String title;
	public App(int id, String title, boolean active, String description, Date createdDate, Date lastModified) {
		super();
		this.id = id;
		this.title = title;
		this.active = active;
		this.description = description;
		this.createdDate = createdDate;
		this.lastModified = lastModified;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	private boolean active=true;
	
	public App() {
		super();
		// TODO Auto-generated constructor stub
	}

	@NotNull
	@Column(name="description")
	private String description;
	
	@CreatedDate
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date createdDate;
	@LastModifiedDate
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date lastModified;
	
}
