package com.billing.sales;

import java.time.LocalDate;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.billing.purchase.Items;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection="sales")
public class Sales {
	@Id
	private ObjectId id;
	private String salesOrderId;
	private LocalDate salesDate;
	private String salesType;
	private List<Items> items;
	private long totalPrice;
	private long amountPaid;
	private long recevables;
	private boolean customizeBagFlag;
	private long billNumber;
	private String customerName;
	private LocalDate createdTime;
	private LocalDate modifiedTime;
}
