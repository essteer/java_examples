package com.kodnito.restapi.models;

import java.io.Serializable;
import java.lang.annotation.Inherited;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity  // indicates it is a JPA entity
@Table(name = "todos")  // used to name table in db
@NamedQueries({  // used to add multiple queries
    @NamedQuery(name = "Todo.findAll", query = "SELECT t FROM Todo t")  // defines query with a name
})
public class Todo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id  // defines primary key and annotated with @GeneratedValue
    @GeneratedValue(strategy = GenerationType.AUTO)  // indicates Id should be generated automatically
    private Long id;
    private String task;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Todo{" + "id=" + id + ", task=" + task + ", description=" + description + "}";
    }
}
