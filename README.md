
# Library API

The following Documentation contains the scrips for Running the CloudScale Library Management System. This Project is the part of CloudScale Interview Assignment.

The Following Application is build upon **Maven Dependent Spring-Boot Microservice Architechtured Principles**.




## API Reference

#### POST Book in Library

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `Content-Type` | `application/json` | **Required**: For Following |


```http
  curl --location --request POST 'http://localhost:8080/api/v1/library' \
--header 'Content-Type: application/json' \
--data-raw '{
    "book_name": "The Alchemist",
    "borrowed": false,
    "copies": 10
}'
```

#### GET All Books from Library

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `Content-Type` | `application/json` | **Required**: For Following |

```http
 curl --location --request GET 'http://localhost:8080/api/v1/library'
```



#### POST Borrow a book by a User
| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `custid` | `long` | **Required** |
| `bookid` | `long` | **Required** |
| `copies` | `int` | **Required** |


```http
  curl --location --request POST 'http://localhost:8080/api/v1/{user_id}/borrow' \
--header 'Content-Type: application/json' \
--data-raw '{
    "bookid": 1,
    "copies": 1
}'
```

#### POST Returning the Book
| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `user_id` | `long` | **Required** |
| `book_id` | `long` | **Required** |
| `copies` | `long` | **Required** |



```http
 curl --location --request POST 'http://localhost:8080/api/v1/{user_id}/return?bookid={bookid}'

```

## Optimizations in Future
- Including the Implementation of Docker file to containerize the application
- Setting up Jenkins Automation for Running tests, Build DockerFile
- The Current Code Structure includes the uses/abstraction of classes in the same TCP connection. It is possible to deploy the application at another server and bridge it through Docker-Compose through Subnet-Gateway

### For More reference on Implementation visit the below Link
---

[Documentation](https://docs.google.com/document/d/16fLI9HOpq6BfB_MOnTZmmdWb5PVRMUsixkAdtloSt6E/edit?usp=sharing)

## 🔗 Links

[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/priyank-vaidya/)
[![twitter](https://img.shields.io/badge/twitter-1DA1F2?style=for-the-badge&logo=twitter&logoColor=white)](https://twitter.com/priyank_vaidya)

## Please find the microarchitectured Data-Flow diagram

![Technology Roadmap](https://github.com/Priyank-Vaidya/Library-Management-System/assets/96229416/86c7962d-91ae-4f51-83ce-dde418040e4c)

