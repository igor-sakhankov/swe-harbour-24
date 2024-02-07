package com.harbour.springboot;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class LectureV2Controller {

    @GetMapping("/v2/lecture/{id}")
    public String getLectureById(@PathVariable("id") String id, @RequestBody Map<String, String> body) {
        System.out.println("id = " + id);
        body.entrySet().stream().map(e -> e.getKey() + " " + e.getValue()).forEach(System.out::println);

        return "Lecture 1";
    }

    @DeleteMapping("/v2/lecture/{id}")
    public String deleteLectureById(@PathVariable("id") String id, @RequestBody Map<String, String> body) {
        System.out.println("id = " + id);
        body.entrySet().stream().map(e -> e.getKey() + " " + e.getValue()).forEach(System.out::println);
        return "Lecture 1";
    }

}
