package com.everis.account.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.everis.account.domain.Account;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface AccountCrudRepository extends ReactiveCrudRepository<Account, String> {

	//Create, FindAll, Update, Delete
	public Flux<Account> findAll();
	public Mono<Account> save(Account document);
	public Mono<Void> delete(Account document);
	public Mono<Void> deleteById(Account document);
	
}
