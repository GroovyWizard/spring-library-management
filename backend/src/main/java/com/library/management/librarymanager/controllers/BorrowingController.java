package com.library.management.librarymanager.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.library.management.librarymanager.models.Borrowing;
import com.library.management.librarymanager.repositories.BorrowingRepository;
import com.library.management.librarymanager.services.BorrowingService;
import com.library.management.librarymanager.dto.*;

@RestController
@RequestMapping(path = "/borrowings")
public class BorrowingController {
	
	@Autowired
	private BorrowingRepository borrowingRepository;
	private final BorrowingService borrowingService;
	
	public BorrowingController(BorrowingService borrowingService) {
		this.borrowingService = borrowingService;
	}
	
	@PostMapping(path="/add")
	public ResponseEntity<String> addNewBorrowing(@RequestParam Long personId, @RequestParam Long bookId ) {
		try {
			borrowingService.createBorrowing(personId, bookId);
		} catch (Exception exception) {
			return ResponseEntity.badRequest().body(exception.getMessage());
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body("Borrowing saved.");

	}
	
	@GetMapping(path="/list")
	public ResponseEntity<List<BorrowingDTO>> getAllBorrowings() {
        List<BorrowingDTO> borrowings = borrowingService.getAllBorrowings();
		return ResponseEntity.ok(borrowings);
	}
    
}
