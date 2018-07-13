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
public class ContaAzulTokenRequest {
	
	@SerializedName("grant_type")
	private String grantType;
	
	@SerializedName("redirect_uri")
	private String redirectUri;
	
	@SerializedName("code")
	private String authorizationCode;
}
