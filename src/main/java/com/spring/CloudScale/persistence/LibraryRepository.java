package com.spring.CloudScale.persistence;

import com.spring.CloudScale.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;



public interface LibraryRepository extends JpaRepository<Library, Long> {

    List<Library> save(Library library);

    List<Library> findAll();
}