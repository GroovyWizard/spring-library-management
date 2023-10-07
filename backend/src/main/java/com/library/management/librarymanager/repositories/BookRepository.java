package com.library.management.librarymanager.repositories;
import org.springframework.data.repository.CrudRepository;
import com.library.management.librarymanager.models.Book;


public interface BookRepository extends CrudRepository<Book, Integer>{


    
}
