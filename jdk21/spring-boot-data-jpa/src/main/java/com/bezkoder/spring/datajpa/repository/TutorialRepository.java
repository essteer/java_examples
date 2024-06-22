package com.bezkoder.spring.datajpa.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.spring.datajpa.model.Tutorial;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {

    List<Tutorial> findByPublished(boolean published);
    List<Tutorial> findByTitleContaining(String title);

}

// Now we can use JpaRepository’s methods: 
// save(), findOne(), findById(), findAll(), count(), delete(), deleteById()… 
// without implementing these methods.

// We also define custom finder methods:
// – findByPublished(): returns all Tutorials with published having value as input published.
// – findByTitleContaining(): returns all Tutorials which title contains input title.

// The implementation is plugged in by Spring Data JPA automatically.
// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/
