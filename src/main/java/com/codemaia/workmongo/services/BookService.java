package com.codemaia.workmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codemaia.workmongo.domain.Book;
import com.codemaia.workmongo.dto.BookDTO;
import com.codemaia.workmongo.repository.BookRepository;
import com.codemaia.workmongo.services.exception.ObjectNotFoundException;

/*
 * Service - os métodos que realmente fazem o CRUD (create, read, update delete)
 */

@Service
public class BookService {
	
	@Autowired
	private BookRepository repo;
	 
	public List<Book> findAll() { // find all books
		return repo.findAll();
	}
	
	public Book findById(String id) { // find book by id
		Optional<Book> book = repo.findById(id);
		
		return book.orElseThrow(() -> new ObjectNotFoundException(":( Objeto não encontrado"));
	}
	
	public Book insert(Book obj) { // insert book
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public Book update(Book obj) {
		Book newBook = findById(obj.getId());
		updateData(newBook, obj);
		return repo.save(newBook);
		
	}
	
	private void updateData(Book newBook, Book obj) {
		newBook.setName(obj.getName());
		newBook.setAuthor(obj.getAuthor());
		newBook.setEditora(obj.getEditora());
	}

	public Book fromDTO(BookDTO objDto) {
		return new Book(objDto.getId(), objDto.getName(), objDto.getAuthor(), objDto.getEditora());
	}
		
}
