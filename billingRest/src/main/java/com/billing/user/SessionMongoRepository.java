package com.billing.user;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface SessionMongoRepository extends MongoRepository<Session, String>{
	
	 Session findBySessionId(String sessionId);
	 void deleteByEmail(String email);

}
