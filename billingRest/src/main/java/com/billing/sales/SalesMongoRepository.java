package com.billing.sales;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface SalesMongoRepository extends MongoRepository<Sales, String>{

	@Query("{ 'salesOrderId': ?0}")
    public Sales findbySalesOrderId(String salesOrderId);
}
