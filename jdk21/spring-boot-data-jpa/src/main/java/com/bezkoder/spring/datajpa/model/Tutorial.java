package com.bezkoder.spring.datajpa.model;


import jakarta.persistence.*;  // for Spring Boot 3


@Entity  // indicates that the class is a persistent Java class
@Table(name = "tutorials")  // provides the table that maps this entity
public class Tutorial {

    @Id  // for the primary key
    // GeneratedValue is used to define generation strategy for the primary key
    @GeneratedValue(strategy = GenerationType.AUTO)  // GenerationType.AUTO means Auto Increment field
    private long id;

    @Column(name = "title")  // used to define the column in database that maps annotated field
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "published")
    private boolean published;

    public Tutorial() {

    }

    public Tutorial(String title, String description, boolean published) {
        this.title = title;
        this.description = description;
        this.published = published;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean isPublished) {
        this.published = isPublished;
    }

    @Override
    public String toString() {
        return "Tutorial [id=" + id + ", title=" + title + ", desc=" + description + ", published=" + published + "]"; 
    }

}
