# Rest API – Spring Boot (Task 2)

##  Project description

This project is a REST API application built with **Spring Boot**, **Spring Data JPA**, and **H2 Database**.
The application implements full CRUD operations for a `Product` resource and follows a layered architecture:
Controller → Service → Repository.

The API can be tested using **Swagger UI** or **Postman**.

---

## 🛠 Technologies used

* Java 25
* Spring Boot
* Spring Web
* Spring Data JPA
* H2 Database
* Hibernate
* Swagger / OpenAPI 
* Maven

---

## 📂 Project structure

```
src/main/java/org/example/restapi
 └── product
     ├── api
     │   └── request
     │       └── ProductRequest.java
     │       └── UpdateProductRequest.java
     │   └── response
     │       └── ProductResponse.java
     │   └── ProductController.java
     ├── domain
     │   └── Product.java
     ├── repository
     │   └── ProductRepository.java
     ├── service
     │   └── ProductService.java
     ├── support
     │   ├── ProductMapper.java
     │   ├── exception
     │       └── ProductNotFoundException.java
     │       └── ProductExceptionSupplier.java
     │       └── ProductExceptionAdvisor.java
     
```

---

## ▶ How to run the application

1. Clone the repository
2. Open the project in **IntelliJ IDEA**
3. Make sure Java is installed
4. Run `RestApiApplication`
5. Application starts on:

```
http://localhost:8080
```

---

## 📑 Swagger UI

Swagger is available at:

```
http://localhost:8080/swagger-ui/index.html
```
![img_6.png](img_6.png)

---

## 🗄 H2 Database

H2 Console is available at:

```
http://localhost:8080/console
```
![img_7.png](img_7.png)
**Connection settings:**

```
JDBC URL: jdbc:h2:mem:testdb
Username: sa
Password: (empty)
```

---

## 🔄 REST API Endpoints

### ➕ Create product

**POST**

```
/api/v1/products
```

Request body:

```json
{
  "name": "Product name"
}
```


Response:

```json
{
  "id": 1,
  "name": "Product name"
}
```

HTTP Status: **201 Created**
![img.png](img.png)
---

### 📄 Get product by ID

**GET**

```
/api/v1/products/{id}
```

HTTP Status: **200 OK**
![img_1.png](img_1.png)

---

### 📋 Get all products

**GET**

```
/api/v1/products
```

HTTP Status: **200 OK**
![img_2.png](img_2.png)

---

### ✏ Update product

**PUT**

```
/api/v1/products/{id}
```

Request body:

```json
{
  "name": "Updated name"
}
```

HTTP Status: **200 OK**
![img_3.png](img_3.png)

---

### ❌ Delete product

**DELETE**

```
/api/v1/products/{id}
```

HTTP Status: **204 No Content**

![img_4.png](img_4.png)

---

## ⚠ Exception handling

If a product with the given ID does not exist, the API returns:

* HTTP Status: **404 Not Found**
* Error message in JSON format
![img_5.png](img_5.png)

---

## Summary

This project demonstrates a complete REST API implementation using Spring Boot with proper architecture, database integration, Swagger documentation, and exception handling.
---
Created by Vadym Sonin