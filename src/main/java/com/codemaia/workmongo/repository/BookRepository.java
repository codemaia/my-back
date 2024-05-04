package com.codemaia.workmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.codemaia.workmongo.domain.Book;

@Repository
public interface BookRepository extends MongoRepository<Book, String>{

	
}
