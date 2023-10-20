package com.library.management.librarymanager.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
public class Person {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    @NotNull
    @Size(min = 3, max = 500)
	private String name;
    
    @OneToMany(mappedBy = "person")
    private List<Borrowing> borrowings = new ArrayList<>();
    

	public Long getId() {
		return id;
	}

    public String getName() {
		return name;
	}
    
    public void setName(String name) {
		this.name = name;
	}
    
    public List<Borrowing> getBorrowings() {
		return borrowings;
	}
    
    public void setBorrowings(List<Borrowing> borrowings) {
		this.borrowings = borrowings;
	}
    
   

	

	
	



}
