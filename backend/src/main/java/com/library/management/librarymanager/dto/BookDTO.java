package com.library.management.librarymanager.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookDTO {

    @JsonProperty("id")
	private Long id;

    @JsonProperty("name")
	private String name;
    
    public Long getId() {
		return id;
	}
    
    public String getName() {
		return name;
	}
    
    public void setId(Long id) {
		this.id = id;
	}
    
    public void setName(String name) {
		this.name = name;
	}
}
