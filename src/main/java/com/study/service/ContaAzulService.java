package com.study.service;

import java.io.IOException;
import java.util.Base64;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.study.model.ContaAzulTokenRequest;
import com.study.model.ContaAzulTokenResponse;
import com.study.model.Sale;
import com.study.repository.ContaAzulRepository;

import okhttp3.OkHttpClient;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Component
public class ContaAzulService {
	
	@Autowired
	private ContaAzulRepository contaAzulRepository;

	private ContaAzul contaAzul;

	private final String CLIENT_ID = "Vm85W79vAIajv0MJqDWLwzE2NR7q4kFK";

	private final String CLIENT_SECRET = "8iEnmm9FShK9W9R4sLR7gjvsNKE6jhG4";
	
	private final String HEADER = "Basic " + Base64.getEncoder().encodeToString((CLIENT_ID + ":" + CLIENT_SECRET).getBytes());

	/**
	 * GERA UM OBJETO RETROFIT PARA A INTERFACE CONTAAZUL
	 */
	public ContaAzulService() {
		
		OkHttpClient client = new OkHttpClient
				.Builder()
				.addInterceptor(new CallInterceptor())
				.build();
		
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("https://api.contaazul.com/")
				.addConverterFactory(factory())
				.client(client)
				.build();
		
		contaAzul = retrofit.create(ContaAzul.class);
	}

	/**
	 * CONVERTER OS RETORNOS DO CONSUMO DA API NO FORMATO JSON
	 * 
	 * @return
	 */
	public GsonConverterFactory factory() {
		Gson gson = new GsonBuilder()
				.setLenient()
				.setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
				.enableComplexMapKeySerialization().create();
		return GsonConverterFactory.create(gson);
	}

	public Optional<ContaAzulTokenResponse> requestToken(String code, String redirectUri)
			throws IOException {
		
		ContaAzulTokenRequest request = ContaAzulTokenRequest
				.builder()
				.authorizationCode(code)
				.redirectUri(redirectUri)
				.grantType("authorization_code")
				.build();
		
//		if(contaAzulRepository.findFirstByOrderByCreatedOnDesc() != null) {
//			LocalDateTime recordDate = contaAzulRepository.findFirstByOrderByCreatedOnDesc().getCreatedOn();
//			
//			if (recordDate.until(LocalDateTime.now(), ChronoUnit.SECONDS) < 3600) {
//				return Optional.ofNullable(contaAzulRepository.findFirstByOrderByCreatedOnDesc());
//			}
//			else {
//				
//			}
//		}
		
		Response<ContaAzulTokenResponse> response = contaAzul.requestToken(HEADER, request).execute();
		
		if(response.raw().code() == 200) {
			
			contaAzulRepository.save(response.body());
			
			return Optional.ofNullable(response.body());
		}else {
			return Optional.empty();
		}

	}
	
	public Optional<Sale> getSaleById(String id) throws IOException {
		
		Response<Sale> response = contaAzul.getSaleById(HEADER, id).execute();
		
		if (response.raw().code() == 200) {
			return Optional.ofNullable(response.body());
		}else {
			return Optional.empty();
		}
	}

}
