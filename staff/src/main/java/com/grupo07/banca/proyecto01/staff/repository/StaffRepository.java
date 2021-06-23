package com.grupo07.banca.proyecto01.staff.repository;

import com.grupo07.banca.proyecto01.staff.Staff;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
//import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface StaffRepository extends ReactiveMongoRepository<Staff, String> {

    public Mono<Staff> findByDni(String dni);

    //@Query("{ 'sex': ?0, 'age' gt ?1}")
    Flux<Staff> findBySexAndAgeGreaterThan(String sex, Integer age);

    @Query("{ 'sex' : ?0, 'age' : { '$gt' : ?1}}") //greater than=gt
    Flux<Staff> findUsingQuery(String sex, Integer age);
}
