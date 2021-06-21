package com.everis.account.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.everis.account.domain.Account;

import reactor.core.publisher.Mono;

@Repository
public interface AccountCrudRepository extends ReactiveMongoRepository<Account, String>, 
		ReactiveCrudRepository<Account, String> {
	
	public Mono<Account> findByNumberAccount(String numberAccount);
	
}
