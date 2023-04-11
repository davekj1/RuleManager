package com.rulemanager.dtos;

import java.util.Date;


public class AppDTO {
	private int id;
	private String title;
	private String description;
	private Date lastModified;
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
	public Date getLastModified() {
		return lastModified;
	}
	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}
	@Override
	public String toString() {
		return "AppDTO [id=" + id + ", title=" + title + ", description=" + description + ", lastModified="
				+ lastModified + "]";
	}
	
	
}
