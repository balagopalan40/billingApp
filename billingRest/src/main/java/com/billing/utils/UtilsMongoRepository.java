package com.billing.utils;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UtilsMongoRepository extends MongoRepository<Utils,String> {
	
}
