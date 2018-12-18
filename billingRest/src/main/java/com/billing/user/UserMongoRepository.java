package com.billing.user;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserMongoRepository extends MongoRepository<User, String> {
    User findByName(String name);
    
    @Query("{ 'name': ?0, 'age': ?1}")
    public User findbyNameAndAge(String name, int age);
}
