package com.grupo07.banca.proyecto01.staff.repository;

import com.grupo07.banca.proyecto01.staff.Staff;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface StaffRepository extends ReactiveMongoRepository<Staff, String>  {

    public Mono<Staff> findByDni(String dni);

    //@Query("{ 'sexo': ?0, 'edad' gt ?1}")
    Flux<Staff> findBySexoAndEdadGreaterThan(String sexo, Integer edad);

    @Query("{ 'sexo' : ?0, 'edad' : { '$gt' : ?1}}") //greater than=gt
    Flux<Staff> findUsingQuery(String sexo, Integer edad);
}
