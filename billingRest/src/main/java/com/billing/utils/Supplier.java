package com.billing.utils;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Supplier {
	
	private String name;
	private String state;
	private String address;
	private long phoneNumber;
	private int stdCode;
	private LocalDate createdTime;
	private LocalDate modifiedTime;
}
