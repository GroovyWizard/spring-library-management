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

    public Language getLanguage(Long id){
        Language language = this.findLanguageById(id);
        return language;
    }

    public String deleteLanguage(Long id) {
        Language language = this.findLanguageById(id);
        languageRepository.delete(language);
        return "Deleted language";
    }

    public Language findLanguageById (Long languageId) throws IllegalArgumentException {

        Optional<Language> language = languageRepository.findById(languageId);
        Language foundLanguage = language.orElseThrow(
                () -> new IllegalArgumentException("Language not found"));

        return foundLanguage;

    }
}
