package com.library.management.librarymanager.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
public class Borrowing {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "person_id")
    @JsonIgnore
    private Person person;

    @ManyToOne
    @JoinColumn(name = "book_id")
    @JsonIgnore
    private Book book;
    
    
    public Book getBook() {
		return book;
	}
    
    public void setBook(Book book) {
		this.book = book;
	}
    
    public Person getPerson() {
		return person;
	}
    
    public void setPerson(Person person) {
		this.person = person;
	}
    
    public Long getId() {
		return id;
	}
    
   

}
