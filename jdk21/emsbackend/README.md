# RESTful API tutorial

CRUD RESTful API tutorial with PostgreSQL, Spring Data JPA and Hibernate.

Source: https://www.youtube.com/watch?v=v1IFQWzuSrw

## Structure

Postman (API endpoint) <-> Controller <-> Service <-> Repository <-> PostgreSQL

The `Controller` layer depends on the `Service` layer, which in turn depends on the `Repository` layer. The structure is therefore built up from the `Repository` to the `Controller` layer.