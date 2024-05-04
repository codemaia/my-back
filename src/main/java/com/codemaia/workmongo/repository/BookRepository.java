package com.codemaia.workmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.codemaia.workmongo.domain.Book;

/*
 * Repository - persistencia com o banco de dados
 */

@Repository
public interface BookRepository extends MongoRepository<Book, String>{

	
}
