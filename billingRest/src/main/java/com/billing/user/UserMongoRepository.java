package com.billing.user;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserMongoRepository extends MongoRepository<User, String> {
    User findByName(String name);
    
    @Query("{ 'email': ?0, 'password': ?1}")
    public User findbyEmailAndPassword(String email, String password);
}
