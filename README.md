****Play Framework Product API****

This is a Play Framework application that provides APIs for managing products. It allows users to create, update, list, and delete products, as well as search for products by ID and sort them by category.

**Getting Started**

To get started with the application, clone this repository to your local machine:

`git clone https://github.com/your-username/play-product-api.git`


Then, install the necessary dependencies by running:

`sbt update`

Running the Application

To run the application locally, use the following command:

`sbt run`

This will start the application on port 9000.

API Documentation

The API documentation is available at http://localhost:9000/docs. It provides details on the available endpoints, request and response formats, and example requests and responses.

Usage

Creating a Product

To create a new product, send a POST request to /products with the following JSON payload:

`{
"name": "Product Name",
"price": 10.0,
"category": "type__"
}`

API Endpoints
Seed Data

Seed data can be inserted into the database using the following endpoints:

    GET /seed-data/insert-categories
    GET /

Categories

Categories can be managed using the following endpoints:

    POST /categories
    GET /categories

Products

Products can be managed using the following endpoints:

    POST /products
    GET /products
    GET /products/:id
    PUT /products/:id
    DELETE /products/:id

Query Parameters

The /products endpoint supports the following query parameters:

    page: Page number to retrieve (default is 1)
    pageSize: Number of items per page (default is 5)
    sortBy: Sort field (default is "id")

Authors

    ANAS BIN ARIF
