package com.study.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "sales")
public class Sale {

	@Id
	@SerializedName("id")
	private String id;
	
	@SerializedName("number")
	private Integer number;
	
	@SerializedName("emission")
	private String emission;
	
	@SerializedName("status")
	private String status;
	
	@SerializedName("customer")
	private Customer customer;
	
	@SerializedName("discount")
	private Discount discount;
	
	@SerializedName("payment")
	private Payment payment;
	
	@SerializedName("notes")
	private String notes;
	
	@SerializedName("shipping_cost")
	private Integer shippingCost;
	
	@SerializedName("total")
	private Integer total;

}