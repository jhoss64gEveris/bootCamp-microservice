package com.everis.account.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.account.domain.Account;
import com.everis.account.repository.AccountCrudRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AccountBusiness {
	
	@Autowired
	AccountCrudRepository repository;
	
	public Mono<Account> save(Account document){
		return repository.save(document);
	}
	
	public Flux<Account> findAll(){
		return repository.findAll();
	}
	
}
