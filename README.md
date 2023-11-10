# Simple CRUD API with Spring Boot

This is a simple CRUD API of products.

## Requirements

For building and running the application you need:

- [JDK 17](https://www.oracle.com/java/technologies/downloads/#java17)
- [Maven 3](https://maven.apache.org)
- [Docker](https://www.docker.com/)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.example.springboot.SpringbootApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/3.1.5/maven-plugin/reference/html/) like so:

```shell
mvn spring-boot:run
```

## Running the database with Docker

You need to run the database so the application can connect to it. To do so, run the following command:

```shell
docker-compose up -d
```

## Testing endpoints

You can test the endpoints using [Postman](https://www.postman.com/) or [Insomnia](https://insomnia.rest/).

### Creating a product

To create a product, you need to send a POST request to the following endpoint:

```shell
http://localhost:8080/products
```

The body of the request must be a JSON with the following structure:

```json
{
  "name": "Product name",
  "price": 10.0
}
```

### Getting all products

To get all products, you need to send a GET request to the following endpoint:

```shell
http://localhost:8080/products
```

### Getting a product by uuid

To get a product by uuid, you need to send a GET request to the following endpoint:

```shell
http://localhost:8080/products/{uuid}
```

### Updating a product

To update a product, you need to send a PUT request to the following endpoint:

```shell
http://localhost:8080/products/{uuid}
```

The body of the request must be a JSON with the following structure:

```json
{
  "name": "Product name",
  "price": 10.0
}
```

### Deleting a product

To delete a product, you need to send a DELETE request to the following endpoint:

```shell
http://localhost:8080/products/{uuid}
```
 