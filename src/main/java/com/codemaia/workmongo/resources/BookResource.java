package com.codemaia.workmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codemaia.workmongo.domain.Book;

@RestController
@RequestMapping(value="/books")
public class BookResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Book>> findAll() {
		Book book1 = new Book("1", "Engenharia de Software", "Somerville", "Futuro");
		Book book2 = new Book("2", "Rede de computadores", "Kurouse", "Futuro");
		
		List<Book> list = new ArrayList<>();
		list.addAll(Arrays.asList(book1, book2));
		
		return ResponseEntity.ok().body(list);
	}

}
