package com.study.resource;

import java.io.IOException;
import java.net.URI;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.service.ContaAzulService;

@RestController
@RequestMapping("/v1/contaazul")
public class ContaAzulResource {

	@Autowired
	private ContaAzulService contaAzulService;
	
	private final String REDIRECT_URI = "http://ivosolution.smn:8080/v1/contaazul/redirect";

	@GetMapping("/{clientId}/{scope}/{state}")
	public void requestAuthorization(
			@PathVariable("clientId") String clientId,
			@PathVariable("scope") String scope,
			@PathVariable("state") String state,
			HttpServletResponse response) throws IOException {
		
		
        response.sendRedirect(URI.create("https://api.contaazul.com/auth/authorize?redirect_uri="+ REDIRECT_URI +"&client_id="+ clientId +"&scope="+ scope +"&state=" + state).toString());
	}
	
	@GetMapping("/redirect")
	public ResponseEntity<?> redirectUrl(@RequestParam("code") String code, @RequestParam("state") String state) throws IOException {
		return new ResponseEntity<Object>(contaAzulService.requestToken(code, REDIRECT_URI), HttpStatus.OK);
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<?> getSaleById(@PathVariable("id") String id) {
		return null;
	}
	
}
