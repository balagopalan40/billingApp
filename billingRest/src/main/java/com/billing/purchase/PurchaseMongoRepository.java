package com.billing.purchase;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface PurchaseMongoRepository extends MongoRepository<Purchase, String>{

	@Query("{ 'purchaseOrderId': ?0}")
    public Purchase findbyPurchaseOrderId(String purchaseOrderId);
}
