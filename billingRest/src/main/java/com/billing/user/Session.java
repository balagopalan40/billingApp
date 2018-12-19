package com.billing.user;

import java.time.LocalDate;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection = "session")
public class Session {	
	@Id
	private ObjectId id;
	private String sessionId;
	private String email;
	private String role;
	private LocalDate createdTime;
	private LocalDate modifiedTime;
}
