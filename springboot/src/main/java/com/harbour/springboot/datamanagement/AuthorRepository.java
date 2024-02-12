package com.harbour.springboot.datamanagement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query(value = "SELECT id FROM authors", nativeQuery = true)
    public List<Long> getIds();
}
