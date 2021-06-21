package com.grupo07.banca.proyecto01.staff.controller;

import com.grupo07.banca.proyecto01.staff.Staff;
import com.grupo07.banca.proyecto01.staff.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping(path = "/staff")
public class StaffController {

    @Autowired
    private StaffRepository StaffRepository;

    @GetMapping(value = "/getStaffs")
    public @ResponseBody
    Flux<Staff> getStaffs() {
        return StaffRepository.findAll();
    }

    @PostMapping(value = "/postStaffs")
    public @ResponseBody
    Mono<Staff> postStaffs(@RequestBody Staff Staff) {
        return StaffRepository.save(Staff);
    }

    @GetMapping(value = "/getStaffsMayores18/{sexo}/{edad}")
    public @ResponseBody
    Flux<Staff> getStaffsMayores18(@PathVariable String sexo, @PathVariable Integer edad) {
        return StaffRepository.findUsingQuery(sexo,edad);
    }

    @PutMapping(value = "/putStaffs")
    public @ResponseBody
    Mono<Staff> putStaffs(@RequestBody Staff Staff) {
        return StaffRepository.findByDni(Staff.getDni()).flatMap(
                dbStaff -> {
                    dbStaff.setName(Staff.getName());
                    return StaffRepository.save(dbStaff);
                });
    }

    @DeleteMapping(value = "/deleteStaffs")
    public Mono<Void> deleteStaffs(@RequestBody Staff Staff){
        return  StaffRepository.delete(Staff);
    }
}
