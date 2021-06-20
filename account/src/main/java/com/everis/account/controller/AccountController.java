package com.everis.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
	
    @GetMapping(path= "/findAll", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<Account> findAll() {		
    	return business.findAll();
    }
	
	@PostMapping(value = "/save")
	@ResponseStatus(value = HttpStatus.CREATED)
    public Mono<Account> saveOrUpdateAccount(@RequestBody Account account) {
		return business.save(account);
    }
}
