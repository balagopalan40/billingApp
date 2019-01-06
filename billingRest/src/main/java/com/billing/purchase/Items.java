package com.billing.purchase;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Items {
	
	private String supplierName;
	private String brand;
	private String variety;
	private String lotNumber;
	private String godown;
	private long units;
	private int quantityPerUnit;
	private long totalquantity;
	private long unitPrice;
	private long totalPricePerItem;
	private String purchaseOrder;
}
