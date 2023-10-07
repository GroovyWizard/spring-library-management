package com.library.management.librarymanager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.management.librarymanager.repositories.BookRepository;
import com.library.management.librarymanager.models.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Validator;

@Service
public class BookService {

    @Autowired
    private Validator validator;

    @Autowired
    private BookRepository bookRepository;

    public Book createBook(String name, String author, String genre) {
        Book book = new Book();
        book.setName(name);
        book.setAuthor(author);
        book.setGenre(genre);
        isValidBook(book);
        bookRepository.save(book);

        return book;
    }

    private void isValidBook(Book book) {
        BeanPropertyBindingResult bindingResult = new BeanPropertyBindingResult(book, "book");
        validator.validate(book, bindingResult);

        if (bindingResult.hasErrors()) {
            throw new IllegalArgumentException("Validation failed");
        }


    }

}
