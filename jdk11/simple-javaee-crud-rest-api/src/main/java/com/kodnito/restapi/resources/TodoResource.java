package com.kodnito.restapi.resources;

import com.kodnito.restapi.dao.TodoDAO;
import com.kodnito.restapi.models.Todo;

import javax.annotation.processing.Generated;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

// Example POST 
// curl -X POST 'http://localhost:8080/restapi/api/todos' -H 'Content-Type: application/json' -d '{"task": "Buy milk", "description": "I drink coffee with milk"}'

@RequestScoped  // indicates class created once every request
@Path("todos")  // identifies URI path to which resource response
@Produces(MediaType.APPLICATION_JSON)  // automatically converts response to JSON format
@Consumes(MediaType.APPLICATION_JSON)  // automatically converts posted JSON string here into Todo object
public class TodoResource {

    @Inject  // inject TodoDAO
    private TodoDAO todoDao;

    @GET  // maps /todos HTTP GET request to getAll() method
    public Response getAll() {
        return Response.ok(todoDao.getAll()).build();
    }

    @GET
    @Path("{id}")  // params accessed with @PathParam method
    public Response getTodo(@PathParam("id") Long id) {
        Todo todo = todoDao.findById(id);

        return Response.ok(todo).build();
    }

    @PUT  // handles HTTP PUT request, meant to update existing resource
    @Path("{id}")
    public Response update(@PathParam("id") Long id, Todo todo) {
        Todo updateTodo = todoDao.findById(id);

        updateTodo.setTask(todo.getTask());
        updateTodo.setDescription(todo.getDescription());
        todoDao.update(updateTodo);

        return Response.ok().build();
    }

    @POST  // handles HTTP POST request, meant to create new resource
    public Response create(Todo todo) {
        todoDao.create(todo);
        return Response.ok().build();
    }

    @DELETE  // handles HTTP DELETE request
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) {
        Todo getTodo = todoDao.findById(id);

        todoDao.delete(getTodo);

        return Response.ok().build();
    }
}