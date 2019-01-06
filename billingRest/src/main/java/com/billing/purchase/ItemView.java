package com.billing.purchase;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ItemView {
	
	@ApiModelProperty(value = "Brand name", required = true, dataType = "java.lang.String", example = "rajabogam", position = 1)
	private String brand;
	
	@ApiModelProperty(value = "Variety name", required = true, dataType = "java.lang.String", example = "very old", position = 2)
	private String variety;
	
	@ApiModelProperty(value = "Number of units", required = true, dataType = "java.lang.long", example = "3", position = 3)
	private long units;
	
	@ApiModelProperty(value = "Quantity per unit", required = true, dataType = "java.lang.long", example = "30", position = 4)
	private int quantityPerUnit;

	@ApiModelProperty(value = "Total quantity", required = true, dataType = "java.lang.long", example = "90", position = 5)
	private long totalquantity;
	
	@ApiModelProperty(value = "Unit price", required = true, dataType = "java.lang.long", example = "20", position = 6)
	private long unitPrice;
	
	@ApiModelProperty(value = "Total price for the particular item", required = true, dataType = "java.lang.long", example = "1800", position = 7)
	private long totalPricePerItem;
	
	@ApiModelProperty(value = "Supplier name", required = true, dataType = "java.lang.String", example = "Raja street", position = 8)
	private String supplierName;
	
	@ApiModelProperty(value = "Purchase order name", required = true, dataType = "java.lang.String", example = "PO121323", position = 9)
	private String purchaseOrder;
	
	@ApiModelProperty(value = "Lot number of the item", required = true, dataType = "java.lang.String", example = "lotmh12", position = 10)
	private String lotNumber;
	
	@ApiModelProperty(value = "Name of the godown", required = true, dataType = "java.lang.String", example = "jjgodown12", position = 11)
	private String godown;
	
	public static ItemView fromItem(Items input) {
		return ItemView.builder()
				.brand(input.getBrand()).variety(input.getVariety()).units(input.getUnits())
				.quantityPerUnit(input.getQuantityPerUnit()).totalquantity(input.getTotalquantity())
				.unitPrice(input.getUnitPrice()).totalPricePerItem(input.getTotalPricePerItem()).supplierName(input.getSupplierName())
				.purchaseOrder(input.getPurchaseOrder())
				.lotNumber(input.getGodown())
				.godown(input.getGodown()).build();
	}
	
	public Items toItem() {
		return Items.builder()
				.brand(this.getBrand()).variety(this.getVariety()).units(this.getUnits())
				.quantityPerUnit(this.getQuantityPerUnit()).totalquantity(this.getTotalquantity())
				.unitPrice(this.getUnitPrice()).totalPricePerItem(this.getTotalPricePerItem()).supplierName(this.getSupplierName())
				.purchaseOrder(this.getPurchaseOrder())
				.lotNumber(this.lotNumber)
				.godown(this.godown).build();
	}

}
