package com.codemaia.workmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codemaia.workmongo.domain.Book;
import com.codemaia.workmongo.dto.BookDTO;
import com.codemaia.workmongo.services.BookService;

@RestController
@RequestMapping(value="/books")
public class BookResource {
	
	@Autowired
	private BookService service;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<BookDTO>> findAll() {
				
		List<Book> list = service.findAll();
		List<BookDTO> listDto = list.stream().map(x -> new BookDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

	@RequestMapping(value="/{id}" ,method=RequestMethod.GET)
	public ResponseEntity<BookDTO> findById(@PathVariable String id) {
		Book obj = service.findById(id);
		
		return ResponseEntity.ok().body(new BookDTO(obj));
	}
}
