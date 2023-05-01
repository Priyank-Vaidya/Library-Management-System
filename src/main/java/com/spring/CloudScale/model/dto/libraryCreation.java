package com.spring.CloudScale.model.dto;

//Automating DTO mapping with ModelMapper

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;



@Getter
@Setter
public class libraryCreation {

    @NotNull
    private String bookname;

    @NotNull
    private int copies;

    @JsonIgnore
    private final LocalDateTime createdAt = LocalDateTime.now();

    @JsonIgnore
    private final LocalDateTime editedAt = LocalDateTime.now();


}
