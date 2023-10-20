package com.library.management.librarymanager.repositories;
import com.library.management.librarymanager.models.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {

}
