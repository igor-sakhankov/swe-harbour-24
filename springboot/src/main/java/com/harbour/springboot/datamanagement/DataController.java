package com.harbour.springboot.datamanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class DataController {

    @Autowired
    private JdbcWay jdbcWay;
    @Autowired
    private JpaWay jpaWay;
    @Autowired
    private MyAuthorMongoRepository mongoRepository;

    @GetMapping("/dataJdbc")
    public List<Map<String, String>> getDatajdbc() {
        return jdbcWay.fetchFromDatabase();
    }

    @GetMapping("/dataJpa")
    public List<Author> getDataJpa() {
        return jpaWay.fetchFromDatabase();
    }

    @PostMapping("/dataJpa")
    public void createJpa() {
        jpaWay.create();
    }

    @GetMapping("/dataMongo")
    public List<AuthorMongo> getDataMongo() {
        return mongoRepository.findAll();
    }

    @PostMapping("/dataMongo")
    public void createMongo() {
        AuthorMongo todo = new AuthorMongo();
        todo.setName("This is a test");
        todo.setCountry("This is a test");
        mongoRepository.save(todo);
    }
}
