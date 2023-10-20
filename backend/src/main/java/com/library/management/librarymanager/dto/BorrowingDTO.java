package com.library.management.librarymanager.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class BorrowingDTO {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("person")
	private PersonDTO person;
    @JsonProperty("book")
	private BookDTO book;
    
    public BookDTO getBook() {
		return book;
	}
    
    public Long getId() {
		return id;
	}
    
    public PersonDTO getPerson() {
		return person;
	}
    
    
    public void setBook(BookDTO book) {
		this.book = book;
	}
    
    public void setId(Long id) {
		this.id = id;
	}
    
    public void setPerson(PersonDTO person) {
		this.person = person;
	}
}
