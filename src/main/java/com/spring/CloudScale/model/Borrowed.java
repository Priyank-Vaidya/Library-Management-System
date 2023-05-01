package com.spring.CloudScale.model;

import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "borrowed")
public class Borrowed {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int borrowid;

    @OneToMany
    @JoinColumn(name = "book_id")
    private Library library;

    @JoinColumn(name = "cust_id")
    private Customers customers;

    private int copies;

    public int getBorrowid() {
        return borrowid;
    }

    public void setBorrowid(int borrowid) {
        this.borrowid = borrowid;
    }

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }
}
