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
    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping("/dataJdbc")
    public List<Map<String, String>> getDatajdbc() {
        return jdbcWay.fetchFromDatabase();
    }

    @PostMapping("/dataJdbc")
    public List<Map<String, String>> createDatajdbc() {
        return jdbcWay.create();
    }

    @GetMapping("/dataJpa")
    public List<Map<String, String>> getDataJpa() {
        return jpaWay.fetchFromDatabase().stream().map(a -> Map.of("id", String.valueOf(a.getId()), "firstName", a.getFirstName())).toList();
    }

    @PostMapping("/dataJpa")
    public void createJpa() {
        jpaWay.create();
    }

    @GetMapping("/dataSpring")
    public List<Author> dataSpring() {
        return authorRepository.findAll();
    }

    @GetMapping("/dataMongo")
    public List<AuthorMongo> getDataMongo() {
        return mongoRepository.findAll();
    }

    @PostMapping("/dataMongo")
    public void createMongo() {
        AuthorMongo todo = new AuthorMongo();
        todo.setId(123L);
        todo.setName("This is a test");
        todo.setCountry("This is a test");
        mongoRepository.save(todo);
    }
}
