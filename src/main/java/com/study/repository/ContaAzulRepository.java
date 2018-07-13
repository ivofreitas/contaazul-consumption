package com.study.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.study.model.ContaAzulTokenResponse;

@Repository
public interface ContaAzulRepository extends MongoRepository<ContaAzulTokenResponse, Long>{
	
	ContaAzulTokenResponse findFirstByOrderByCreatedOnDesc();

}
