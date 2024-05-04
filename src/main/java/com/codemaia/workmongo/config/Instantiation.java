package com.codemaia.workmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.codemaia.workmongo.domain.Book;
import com.codemaia.workmongo.repository.BookRepository;


/*
 * Carga inicial do banco de dados
 */

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired // Dependency Injection
	private BookRepository bookRepository;	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub	
		
		bookRepository.deleteAll(); //delete all book in mongodb
		
		Book book1 = new Book(null, "Engenharia de Software", "Somerville", "Futuro");
		Book book2 = new Book(null, "Estruturade dados e algoritmos com JavaScript", "Loiane Groner", "Novatec");
		Book book3 = new Book(null, "Entendendo Algoritmos: Um Guia Ilustrado Para Programadores e Outros Curiosos", " Aditya Y. Bhargava", "Novatec");
		
		
		bookRepository.saveAll(Arrays.asList(book1, book2, book3));
		
		
	}
	

}
