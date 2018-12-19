package com.billing.user;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection = "users")
public class User {
    @Id
    private ObjectId id;
    private String name;
    private long phoneNumber;
    private int countryCode;
    private String email;
    private String password;
    private String role;
}