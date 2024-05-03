package com.codemaia.workmongo.domain;

import java.io.Serializable;
import java.util.Objects;

public class Book implements Serializable{


	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String author;
	private String editora;
	
	
	public Book( ) {
		
	}


	public Book(String id, String name, String author, String editora) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.editora = editora;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getEditora() {
		return editora;
	}


	public void setEditora(String editora) {
		this.editora = editora;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
