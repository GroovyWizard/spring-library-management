package com.library.management.librarymanager.controllers;

import com.library.management.librarymanager.models.Book;
import com.library.management.librarymanager.repositories.BookRepository;
import com.library.management.librarymanager.services.BookService;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/books")
public class BookController {
    @Autowired
    private BookRepository bookRepository;
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping(path = "/add")
    public ResponseEntity<String> addNewBook(@RequestParam String name, @RequestParam String author,
            @RequestParam String genre) {

            try {
               bookService.createBook(name, author, genre);
            } catch (Exception exception) {
                return ResponseEntity.badRequest().body(exception.getMessage());
            }
            return ResponseEntity.status(HttpStatus.CREATED).body("Book successfully saved.");
    }

    @GetMapping(path="/list")
    public @ResponseBody Iterable<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping(path="/get/{id}")
    public ResponseEntity<?> getBook(@PathVariable Long id) {
        Book book;
        try {
            book = bookService.getBook(id);
            return ResponseEntity.ok(book);
        } catch (Exception exception) {
            return ResponseEntity.notFound().build();
        }
    }


}
