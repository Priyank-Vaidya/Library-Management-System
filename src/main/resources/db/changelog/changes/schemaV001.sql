-- Database consisting of all of the Data of Books in the Library
CREATE TABLE library(
    bookid SERIAL PRIMARY KEY ,
    bookname VARCHAR(25),
    borrowed BOOLEAN,
    copies INT,
    createdAt TIMESTAMP WITHOUT TIME ZONE,
    editedAt TIMESTAMP WITHOUT TIME ZONE,
    published BOOLEAN
);

--Database for all the users who subscribed to the Library
CREATE TABLE customer(
    custid SERIAL PRIMARY KEY ,
    cust_name VARCHAR(25)
);

-- Database for all the borrowed Items by customers
CREATE TABLE BORROWED(
    borrowid INT PRIMARY KEY,
    cust_id INT REFERENCES customer(custid),
    book_id INT REFERENCES library(bookid),
    borrowedAt TIMESTAMP WITHOUT TIME ZONE,
    returnBy TIMESTAMP WITHOUT TIME ZONE,
    copies INT
);