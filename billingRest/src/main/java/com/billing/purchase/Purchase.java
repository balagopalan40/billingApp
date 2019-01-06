package com.billing.purchase;

import java.time.LocalDate;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection = "purchase")
public class Purchase {
	@Id
	private ObjectId id;
	private String purchaseOrderId;
	private LocalDate purchaseDate;
	private String purchaseType;
	private List<Items> items;
	private long totalPrice;
	private long amountPaid;
	private long payables;
	private boolean customizeBagFlag;
	private long billNumber;
	private LocalDate createdTime;
	private LocalDate modifiedTime;
}
