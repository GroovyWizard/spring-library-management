package com.library.management.librarymanager.repositories;
import org.springframework.data.repository.CrudRepository;
import com.library.management.librarymanager.models.Language;

public interface LanguageRepository extends CrudRepository<Language, Long> {

}
