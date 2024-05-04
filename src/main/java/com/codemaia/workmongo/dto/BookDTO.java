package com.codemaia.workmongo.dto;

import java.io.Serializable;

import com.codemaia.workmongo.domain.Book;

public class BookDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String author;
	private String editora;
	
	public BookDTO() {
		
	}
	
	public BookDTO(Book obj) {
		id = obj.getId();
		name = obj.getName();
		author = obj.getAuthor();
		editora = obj.getEditora();		
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
	
	
	
}
