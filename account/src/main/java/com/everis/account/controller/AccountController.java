package com.everis.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.everis.account.business.AccountBusiness;
import com.everis.account.domain.Account;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin("*")
@RequestMapping(value="/account")
public class AccountController {

	@Autowired
	AccountBusiness business;
	
    @GetMapping(path= "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<Account> findAll() {		
    	return business.findAll();
    }
	
    @GetMapping(path= "/findByNumberAccount/{numberAccount}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public Mono<Account> findByNumberAccount(@PathVariable("numberAccount") final String numberAccount) {		
    	return business.findByNumberAccount(numberAccount);
    }
    
	@PostMapping(value = "/save")
	@ResponseStatus(value = HttpStatus.CREATED)
    public Mono<Account> saveOrUpdateAccount(@RequestBody Account account) {
		return business.save(account);
    }
	
	@PostMapping(value = "/saveAll")
	@ResponseStatus(value = HttpStatus.CREATED)
    public Flux<Account> saveAccountAll(@RequestBody Iterable<Account> accounts) {
		return business.saveAll(accounts);
    }
	
	//@GetMapping(path= "/findAll", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
}
