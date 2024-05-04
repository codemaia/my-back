package com.codemaia.workmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codemaia.workmongo.domain.Book;
import com.codemaia.workmongo.services.BookService;

@RestController
@RequestMapping(value="/books")
public class BookResource {
	
	@Autowired
	private BookService service;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Book>> findAll() {
				
		List<Book> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

}
