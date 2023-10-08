
package com.library.management.librarymanager.controllers;

import com.library.management.librarymanager.models.Language;
import com.library.management.librarymanager.repositories.LanguageRepository;
import com.library.management.librarymanager.services.LanguageService;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping(path = "/languages")
public class LanguageController {
    @Autowired
    private LanguageRepository languageRepository;
    private final LanguageService languageService;

    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @PostMapping(path="/add")
    public ResponseEntity<String> addNewLanguage(@RequestParam String name, @RequestParam String brief) {
        try {
            languageService.createLanguage(name, brief);
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("New language saved");
    }

    @GetMapping(path="/list")
    public @ResponseBody Iterable<Language> getAllLanguages() {
        return languageRepository.findAll();
    }

    @DeleteMapping(path="/delete/{id}")
    public ResponseEntity<String> deleteLanguage(@PathVariable Long id) {
        try {
            languageService.deleteLanguage(id);
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Language deleted");
    }
    
}
