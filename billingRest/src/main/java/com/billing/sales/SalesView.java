package com.billing.sales;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.billing.common.LocalDateAsMonthSerializer;
import com.billing.common.LocalDateDeserializer;
import com.billing.purchase.ItemView;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SalesView {
	
	@ApiModelProperty(value = "sales order id", required = true, dataType = "java.lang.String", example = "SO18190", position = 1)
	private String salesOrderId;
	
	@ApiModelProperty(value = "sales date", required = true, dataType = "java.lang.Date", example = "2019-01-06T07:46:25", position = 2)
	@JsonSerialize(using = LocalDateAsMonthSerializer.class)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	private LocalDate salesDate;
	
	@ApiModelProperty(value = "sales type", required = true, dataType = "java.lang.String", example = "cash", position = 3)
	private String salesType;
	
	@ApiModelProperty(position = 4)
	private List<ItemView> items;
	
	@ApiModelProperty(value = "Total price", required = true, dataType = "java.lang.long", example = "1000", position = 5)
	private long totalPrice;
	
	@ApiModelProperty(value = "Amonut paid", required = true, dataType = "java.lang.long", example = "800", position = 6)
	private long amountPaid;
	
	@ApiModelProperty(value = "Receivables", required = true, dataType = "java.lang.long", example = "200", position = 7)
	private long recevables;
	
	@ApiModelProperty(value = "Customize flag", required = true, dataType = "java.lang.boolean", example = "true", position = 8)
	private boolean customizeBagFlag;
	
	@ApiModelProperty(value = "Bill number", required = true, dataType = "java.lang.long", example = "123123", position = 9)
	private long billNumber;
	
	public static SalesView fromSales(Sales sales) {
		return SalesView.builder()
			.salesOrderId(sales.getSalesOrderId()).salesDate(sales.getSalesDate()).salesType(sales.getSalesType())
			.items(sales.getItems().stream().map(ItemView::fromItem).collect(Collectors.toList()))
			.totalPrice(sales.getTotalPrice()).amountPaid(sales.getAmountPaid()).recevables(sales.getRecevables())
			.customizeBagFlag(sales.isCustomizeBagFlag()).billNumber(sales.getBillNumber())
				.build();
	}
	
	public Sales toSales() {
		return Sales.builder()
				.salesOrderId(this.getSalesOrderId()).salesDate(this.getSalesDate()).salesType(this.getSalesType())
				.items(this.getItems().stream().map(ItemView::toItem).collect(Collectors.toList()))
				.totalPrice(this.getTotalPrice()).amountPaid(this.getAmountPaid()).recevables(this.getRecevables())
				.customizeBagFlag(this.isCustomizeBagFlag()).billNumber(this.getBillNumber())
				.build();
	}
}
