package com.spring.CloudScale.persistence;

import com.spring.CloudScale.model.Customers;
import com.spring.CloudScale.model.Library;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
public interface UserRepository extends JpaRepository<Customers, Long> {

    List<Customers> save(Customers customers);

    List<Customers> findAll();
}
