package com.library.management.librarymanager.repositories;

import com.library.management.librarymanager.models.Borrowing;
import org.springframework.data.repository.CrudRepository;
    
public interface BorrowingRepository extends CrudRepository<Borrowing, Long> {

}
