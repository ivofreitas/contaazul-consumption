package com.study.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "tokens")
public class ContaAzulTokenResponse implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7556341034370103115L;
	
	@Id
	private String id;
	
	@CreatedDate
	private LocalDateTime createdOn;
	
	@SerializedName("refresh_token")
	public String refreshToken;
	
	@SerializedName("token_type")
	public String tokenType;
	
	@SerializedName("access_token")
	public String accessToken;
	
	@SerializedName("expires_in")
	public Integer expiresIn;


}
