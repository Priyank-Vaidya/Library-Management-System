package com.spring.CloudScale.controller;


import com.spring.CloudScale.model.Library;
import com.spring.CloudScale.model.dto.libraryCreation;
import com.spring.CloudScale.model.dto.libraryUpdateDTO;
import com.spring.CloudScale.persistence.LibraryRepository;
import com.spring.CloudScale.util.DTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/library")
public class LibraryController {

    private LibraryRepository libraryRepository;

    public LibraryController(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    @GetMapping
    public List<Library> getLibrary(){
        return libraryRepository.findAll();
    }

    @PostMapping
    public void newBook(@DTO(libraryCreation.class) Library library){
        libraryRepository.save(library);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void editLibrary(@DTO(libraryUpdateDTO.class) Library library) {
        libraryRepository.save(library);

    }

}
