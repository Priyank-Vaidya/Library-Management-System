package com.spring.CloudScale.persistence;

import com.spring.CloudScale.model.Borrowed;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface BorrowedRepository extends JpaRepository<Borrowed, Long> {

//    List<Borrowed> save ();
    List<Borrowed> findAllByUserid(Long user_id);

    Optional<Borrowed> findById(Long book_id);
    List<Borrowed> findAllByUserIdAndBookId(Long cust_id, Long book_id);

    Optional<Borrowed> deleteAll(List<Borrowed> borrowedList);

    Optional<Borrowed> deleteById(long book_id);

}
