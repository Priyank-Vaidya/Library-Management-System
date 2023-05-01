package com.spring.CloudScale.model.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
public class libraryUpdateDTO {

    @Id
    @NotNull
    private Long bookid;

    @NotNull
    private String bookname;

    @NotNull
    private int copies;

    @JsonIgnore
    private final LocalDateTime editedAt = LocalDateTime.now();

    public Long getBookid() {
        return bookid;
    }

    public void setBookid(Long bookid) {
        this.bookid = bookid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public LocalDateTime getEditedAt() {
        return editedAt;
    }
}
