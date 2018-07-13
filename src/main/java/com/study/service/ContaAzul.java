package com.study.service;

import com.study.model.ContaAzulTokenRequest;
import com.study.model.ContaAzulTokenResponse;
import com.study.model.Sale;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ContaAzul {

	@POST("oauth2/token")
	Call<ContaAzulTokenResponse> requestToken(@Header("Authorization") String header, @Body ContaAzulTokenRequest request);
	
	@GET("v1/sales/{id}")
	Call<Sale> getSaleById(@Header("Authorization") String header, @Path("id") String id);

}
