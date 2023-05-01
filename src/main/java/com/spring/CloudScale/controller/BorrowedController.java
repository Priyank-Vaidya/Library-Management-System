package com.spring.CloudScale.controller;

import com.spring.CloudScale.model.Borrowed;
import com.spring.CloudScale.model.Customers;
import com.spring.CloudScale.model.Library;
import com.spring.CloudScale.model.dto.borrowedCreationDTO;
import com.spring.CloudScale.model.dto.borrowedUpdationDTO;
import com.spring.CloudScale.model.dto.libraryUpdateDTO;
import com.spring.CloudScale.persistence.BorrowedRepository;
import com.spring.CloudScale.persistence.LibraryRepository;
import com.spring.CloudScale.util.DTO;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user/{custid}/borrowed")
public class BorrowedController {

    protected BorrowedRepository borrowedRepository;
    protected LibraryRepository libraryRepository;

    public BorrowedController(BorrowedRepository borrowedRepository, LibraryRepository libraryRepository) {
        this.borrowedRepository = borrowedRepository;
        this.libraryRepository = libraryRepository;
    }

    @PostMapping(value = "/api/v1/{custid}/borrow", params = "bookid")
    public void newBorrow(@DTO(borrowedCreationDTO.class) Borrowed user, @PathVariable("custid") long custid, @RequestParam("bookid") long bookid, @RequestParam("copies") int copies) {
        borrowedCreationDTO borrowedCreationDTO = new borrowedCreationDTO();

        List<Borrowed>  borrowedList = borrowedRepository.findAllByUserid(custid);

        borrowedCreationDTO.setUserid(custid);
        borrowedCreationDTO.setBookid(bookid);
        borrowedCreationDTO.setCopies(copies);

        borrowedRepository.save(user);


        Library library = new Library();
        //Updating the Library
        updateLibrary(library, borrowedCreationDTO.getCopies());

        System.out.println("The Customer has Successfully Borrowed the Book from the Library");


    }


    public void updateLibrary(@DTO(libraryUpdateDTO.class) Library library, int copiesBorrowed) {
        libraryUpdateDTO libraryupdatedto = new libraryUpdateDTO();
        libraryupdatedto.setCopies(libraryupdatedto.getCopies() - copiesBorrowed);

        libraryRepository.save(library);

        System.out.println("After Borrowing the Library Database has been changed");

    }
}

@RestController
@RequestMapping(value = "api/v1/user/{userid}/return", params = "bookid")
class returnBorrow extends BorrowedController{

    public void updateLibraryafterReturn(@DTO(libraryUpdateDTO.class) Library library, int copiesBorrowed) {
        libraryUpdateDTO libraryupdatedto = new libraryUpdateDTO();
        libraryupdatedto.setCopies(libraryupdatedto.getCopies() + copiesBorrowed);

        libraryRepository.save(library);

        System.out.println("After Borrowing the Library Database has been changed");

    }



    public returnBorrow(BorrowedRepository borrowedRepository, LibraryRepository libraryRepository) {
        super(borrowedRepository, libraryRepository);
    }

    @PostMapping
    public void returnBook(@DTO(borrowedUpdationDTO.class) Borrowed user, @PathVariable("userid") long userid, @RequestParam("bookid") long bookid){
        borrowedUpdationDTO borrowedupdationdto = new borrowedUpdationDTO();

//        Borrowed borrowed = (Borrowed) borrowedRepository.findAllByUserId(userid);

        Optional<Borrowed> borrowedOptional = borrowedRepository.findById(userid);
        int copies = borrowedOptional.get().getCopies();
        if(borrowedOptional!=null){


            borrowedupdationdto.setReturnBy(borrowedupdationdto.getBorrowedAt());
            borrowedRepository.deleteById(bookid);
        }
        else{
            new Exception("The book is not borrowed by anyone");
        }

        Library library = new Library();
        updateLibraryafterReturn(library, copies);


    }
}
