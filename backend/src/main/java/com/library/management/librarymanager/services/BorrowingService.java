package com.library.management.librarymanager.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;

import com.library.management.librarymanager.dto.BorrowingDTO;
import com.library.management.librarymanager.models.Book;
import com.library.management.librarymanager.models.Borrowing;
import com.library.management.librarymanager.models.Person;
import com.library.management.librarymanager.repositories.BookRepository;
import com.library.management.librarymanager.repositories.BorrowingRepository;
import com.library.management.librarymanager.repositories.PersonRepository;

import org.springframework.validation.Validator;


@Service
public class BorrowingService {

	@Autowired
	private Validator validator;

	@Autowired
	private BorrowingRepository borrowingRepository;

	private final PersonService personService;
	private final BookService bookService;
	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	public BorrowingService(BookService bookService, PersonService personService) {
		this.personService = personService;
		this.bookService = bookService;

	}
	
	public List<BorrowingDTO> getAllBorrowings() {
		List<Borrowing> borrowings = (List<Borrowing>) borrowingRepository.findAll();
		return borrowings.stream().map(this::convertToBorrowingDTO).collect(Collectors.toList());
	}
	
	private BorrowingDTO convertToBorrowingDTO(Borrowing borrowing) {
		BorrowingDTO borrowingDTO = modelMapper.map(borrowing, BorrowingDTO.class );
		return borrowingDTO;
	}

	public Borrowing createBorrowing(Long personId, Long bookId) {
		Borrowing borrowing = new Borrowing();
		Book book = bookService.getBook(bookId);
		Person person = personService.getPerson(personId);
		borrowing.setBook(book);
		borrowing.setPerson(person);
		isValidBorrowing(borrowing);
		borrowingRepository.save(borrowing);
		return borrowing;

	}

	private void isValidBorrowing(Borrowing borrowing) throws IllegalArgumentException {
		BeanPropertyBindingResult bindingResult = new BeanPropertyBindingResult(borrowing, "borrowing");
		validator.validate(borrowing, bindingResult);

		if (bindingResult.hasErrors()) {
			throw new IllegalArgumentException("Validation failed");
		}

	}

}
