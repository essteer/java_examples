package com.kodnito.restapi.dao;

import com.kodnito.restapi.models.Todo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class TodoDAO {

    // injects EntityManager to be used at runtime
    @PersistenceContext(unitName = "restapi_PU")
    EntityManager em;

    public List<Todo> getAll() {
        // retrieves all todos from db
        return em.createNamedQuery("Todo.findAll", Todo.class).getResultList();
    }

    public Todo findById(Long id) {
        // finds one Todo Object from db with id
        return em.find(Todo.class, id);
    }

    public void update(Todo todo) {
        // updates existing Todo Object in db
        em.merge(todo);
    }

    public void create(Todo todo) {
        // creates Todo Object in db
        em.persist(todo);
    }

    public void delete(Todo todo) {
        // find Todo Object in db and delete it
        if (!em.contains(todo)) {
            todo = em.merge(todo);
        }
        em.remove(todo);
    }

}