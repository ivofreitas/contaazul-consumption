package com.study.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Payment {

	@SerializedName("type")
	private String type;
	
	@SerializedName("installments")
	private List<Installment> installments;

}
