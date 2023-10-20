package com.library.management.librarymanager.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @NotNull
    @Size(min = 3, max = 500)
    private String name;

    @NotNull
    @Size(min = 1, max = 500)
    private String author;

    @NotNull
    @Size(min = 1, max = 500)
    private String genre;


    @ManyToOne
    private Language language;
    
    @OneToMany(mappedBy = "book")
    private List<Borrowing> borrowings = new ArrayList<>();
    
    public List<Borrowing> getBorrowings() {
		return borrowings;
	}
    
    public void setBorrowings(List<Borrowing> borrowings) {
		this.borrowings = borrowings;
	}


    public Long getId() {
		return id;
	}
    
    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    
}
