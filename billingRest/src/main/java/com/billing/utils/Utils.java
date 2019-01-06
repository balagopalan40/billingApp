package com.billing.utils;

import java.time.LocalDate;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection="utils")
public class Utils {
	@Id
	private ObjectId id;
	private List<String> customer;
	private List<Supplier> supplier;
	private List<String> brand;
	private List<String> variety;
	private LocalDate createdTime;
	private LocalDate modifiedTime;
}
