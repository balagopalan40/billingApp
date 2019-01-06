package com.billing.purchase;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.billing.common.*;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class PurchaseView {

	@ApiModelProperty(value = "purchase order id", required = true, dataType = "java.lang.String", example = "PO18190", position = 1)
	private String purchaseOrderId;
	
	@ApiModelProperty(value = "purchase order date", required = true, dataType = "java.lang.Date", example = "22-02-2018", position = 2)
    @JsonSerialize(using = LocalDateAsMonthSerializer.class)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	private LocalDate purchaseDate;
	
	@ApiModelProperty(value = "purchase type", required = true, dataType = "java.lang.String", example = "cash / credit", position = 3)
	private String purchaseType;
	
	@ApiModelProperty(position = 5)
	private List<ItemView> items;
	
	@ApiModelProperty(value = "Total price", required = true, dataType = "java.lang.long", example = "10000", position = 7)
	private long totalPrice;
	
	@ApiModelProperty(value = "Amount paid while purchase", required = true, dataType = "java.lang.long", example = "1000", position = 8)
	private long amountPaid;
	
	@ApiModelProperty(value = "Amount pending and payables towards the end", required = true, dataType = "java.lang.long", example = "1000", position = 9)
	private long payables;
	
	@ApiModelProperty(value = "Flag fr bag customization", required = true, dataType = "java.lang.boolean", example = "true", position = 10)
	private boolean customizeBagFlag;
	
	@ApiModelProperty(value="Bill number generated", required = true, dataType = "java.lang.long", example = "2132123", position = 11)
	private long billNumber;
	
	public static PurchaseView fromPurchase(Purchase input) {
		return PurchaseView.builder()
				.purchaseOrderId(input.getPurchaseOrderId())
				.purchaseDate(input.getPurchaseDate())
				.purchaseType(input.getPurchaseType())
				.items(input.getItems().stream().map(ItemView::fromItem).collect(Collectors.toList()))
				.totalPrice(input.getTotalPrice())
				.amountPaid(input.getAmountPaid())
				.payables(input.getPayables())
				.customizeBagFlag(input.isCustomizeBagFlag())
				.billNumber(input.getBillNumber()).build();
	}
	
	public Purchase toPurchase() {
		return Purchase.builder()
				.purchaseOrderId(this.getPurchaseOrderId())
				.purchaseDate(this.getPurchaseDate())
				.purchaseType(this.getPurchaseType())
				.items(this.getItems().stream().map(ItemView::toItem).collect(Collectors.toList()))
				.totalPrice(this.getTotalPrice())
				.amountPaid(this.getAmountPaid())
				.payables(this.getPayables())
				.customizeBagFlag(this.isCustomizeBagFlag())
				.billNumber(this.getBillNumber()).build();
	}
}
