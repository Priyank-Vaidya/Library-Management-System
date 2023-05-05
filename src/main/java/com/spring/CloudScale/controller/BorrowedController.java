package com.spring.CloudScale.controller;

import com.spring.CloudScale.model.Borrowed;
import com.spring.CloudScale.model.Library;
import com.spring.CloudScale.model.dto.borrowedCreationDTO;
import com.spring.CloudScale.model.dto.borrowedUpdationDTO;
import com.spring.CloudScale.model.dto.libraryUpdateDTO;
import com.spring.CloudScale.persistence.BorrowedRepository;
import com.spring.CloudScale.persistence.LibraryRepository;
import com.spring.CloudScale.util.DTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user/{user_id}/borrowed")
public class BorrowedController {

    protected BorrowedRepository borrowedRepository;
    protected LibraryRepository libraryRepository;

    public BorrowedController(BorrowedRepository borrowedRepository, LibraryRepository libraryRepository) {
        this.borrowedRepository = borrowedRepository;
        this.libraryRepository = libraryRepository;
    }

    @PostMapping(value = "/api/v1/{user_id}/borrow", params = "book_id")
    public void newBorrow(@DTO(borrowedCreationDTO.class) Borrowed user, @PathVariable("user_id") long user_id, @RequestParam("book_id") long book_id, @RequestParam("copies") int copies) throws Exception {
        borrowedCreationDTO borrowedCreationDTO = new borrowedCreationDTO();

        List<Borrowed>  borrowedList = borrowedRepository.findAllByUserid(user_id);

        //Creating the Updation of the
        borrowedCreationDTO.setBookid(book_id);
        borrowedCreationDTO.setCopies(copies);


        Library library = new Library();
        //Updating the Library
        updateLibrary(library, borrowedCreationDTO.getCopies());

        System.out.println("The Customer has Successfully Borrowed the Book from the Library");


    }


    public void updateLibrary(@DTO(libraryUpdateDTO.class) Library library, int copiesBorrowed) throws Exception {
        libraryUpdateDTO libraryupdatedto = new libraryUpdateDTO();
        if(libraryupdatedto.getCopies() - copiesBorrowed >0) {
            libraryupdatedto.setCopies(libraryupdatedto.getCopies() - copiesBorrowed);
            libraryRepository.save(library);
        }
        else{
            throw new Exception("The User cannot Borrow More copy than available");
        }
        System.out.println("After Borrowing the Library Database has been changed");

    }
}

@RestController
@RequestMapping(value = "api/v1/user/{user_id}/return", params = "book_id")
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
    public void returnBook(@DTO(borrowedUpdationDTO.class) Borrowed user, @PathVariable("user_id") long user_id, @RequestParam("book_id") long book_id) throws Exception {
        borrowedUpdationDTO borrowedupdationdto = new borrowedUpdationDTO();

//        Borrowed borrowed = (Borrowed) borrowedRepository.findAllByUserId(userid);
        Optional<Borrowed> borrowedOptional = borrowedRepository.findById(book_id);

        //Fetching the List matching the user_id and book_id
        List<Borrowed> borrowedList = borrowedRepository.findAllByUserIdAndBookId(user_id, book_id);


        if(borrowedOptional.isPresent()) {
            int copies = borrowedOptional.get().getCopies();

            borrowedupdationdto.setReturnBy(borrowedupdationdto.getBorrowedAt());
//            borrowedList.stream().
            borrowedRepository.deleteAll(borrowedList);
            borrowedRepository.deleteById(book_id);

            Library library = new Library();
            updateLibraryafterReturn(library, copies);
        }
    }
}
