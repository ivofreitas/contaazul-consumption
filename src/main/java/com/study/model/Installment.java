package com.study.model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Installment {
	
	@SerializedName("number")
	private Integer number;
	
	@SerializedName("value")
	private Integer value;
	
	@SerializedName("due_date")
	private String dueDate;
	
	@SerializedName("status")
	private String status;

}
