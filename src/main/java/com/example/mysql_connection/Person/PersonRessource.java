package com.example.mysql_connection.Person;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/AllUsers")
@CrossOrigin(origins ="*")
public class PersonRessource {

    @Autowired
    private PersonService personservice;

    @Autowired
    private PersonDetailsService personDetailsService;


    @GetMapping
    public List<Person> getPresenteurs(){
        return  personservice.getALLPerson();
    }

    @GetMapping("/returnUser")
    public Person returnUser(){
        Person person = personservice.getPerson(personDetailsService.getId()) ;
        return  person ;
    }
}
