package com.harbour.springboot.datamanagement;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JpaWay {

    @Autowired
    EntityManagerFactory entityManagerFactory;

    public List<Author> fetchFromDatabase() {
        var entityManager = entityManagerFactory.createEntityManager();
        Query q = entityManager.createQuery("select a from Author a");
        return (List<Author>) q.getResultList();
    }

    public void create() {
        var entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Author todo = new Author();
        todo.setName("This is a test");
        todo.setCountry("This is a test");

        entityManager.persist(todo);
        entityManager.getTransaction().commit();
    }

}
