package com.spring.CloudScale.persistence;

import com.spring.CloudScale.model.Borrowed;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;


public interface BorrowedRepository extends JpaRepository<Borrowed, Long> {
    List<Borrowed> findAllByUserid(Long userid);

    List<Borrowed> findAllByBookid(Long bookid);

    List<Borrowed> deleteByBorrowid(Long borrowedid);

    List<Borrowed> findAllById(long bookid);

    Object findAllByUserId(long userid);
}
