package com.everis.account;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.everis.account.domain.Account;
import com.everis.account.repository.AccountCrudRepository;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@SpringBootTest
class AccountTest{
	
	
	@Autowired
	AccountCrudRepository repository;
	
	@Test
	public void testSaveAccount() {
		
	    repository.save(new Account("1","CND-263232323","Aura","Moreyra",Date.valueOf("01-01-2020"))).block();
	    Flux<Account> accountFlux = repository.findAll();

	    StepVerifier
	      .create(accountFlux)
	      .assertNext(account -> {
	          //assertEquals("Bill", account.getOwner());
	    	  //assertEquals("Aura", account.);
	      })
	      .expectComplete()
	      .verify();
	}
	
	

}
