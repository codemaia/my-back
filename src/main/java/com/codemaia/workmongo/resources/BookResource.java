package com.codemaia.workmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody BookDTO objDto) {
		Book obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build(); // created return void with cod. http 201 
	}
	
}
