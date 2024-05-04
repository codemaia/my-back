package com.codemaia.workmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codemaia.workmongo.domain.Book;
import com.codemaia.workmongo.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository repo;
	 
	public List<Book> findAll() {
		
		return repo.findAll();
	}
}
