package com.grupo07.banca.proyecto01.staff;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Staff {
    @Id
    private String   id;
    private String  dni;
    private String  name;
    private String  sex;
    private Integer age;


}