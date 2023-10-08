package com.library.management.librarymanager.services;

import com.library.management.librarymanager.models.Language;
import com.library.management.librarymanager.repositories.LanguageRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Validator;

@Service
public class LanguageService {
    @Autowired    
    private LanguageRepository languageRepository;

    public Language createLanguage(String name, String brief) {
        Language language = new Language();
        language.setName(name);
        language.setBrief(brief);
        languageRepository.save(language);
        return language;
    }

    public Optional<Language> findLanguageById(Long languageId) {
        return languageRepository.findById(languageId);
    }


    public String deleteLanguage(Long id) {
        Optional<Language> language = this.findLanguageById(id);
        if(language == null) {
            throw new IllegalArgumentException("Language not found");
        }

        Language languageToDelete = language.orElse(new Language());
        languageRepository.delete(languageToDelete);
        return "Deleted language";

    }
}
