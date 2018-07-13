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
public class Discount {

	@SerializedName("measure_unit")
	public String measureUnit;
	
	@SerializedName("rate")
	public Integer rate;

}
