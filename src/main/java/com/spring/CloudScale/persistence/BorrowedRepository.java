package com.spring.CloudScale.persistence;

import com.spring.CloudScale.model.Borrowed;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface BorrowedRepository extends JpaRepository<Borrowed, Long> {
    List<Borrowed> findAllByUserid(Long userid);

    Optional<Borrowed> findById(Long bookid);
    List<Borrowed> findAllByUserIdAndBookId(Long cust_id, Long book_id);

}
