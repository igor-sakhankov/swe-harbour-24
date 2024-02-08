package com.harbour.springboot.datamanagement;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MyAuthorMongoRepository extends MongoRepository<AuthorMongo, Long> {
}
