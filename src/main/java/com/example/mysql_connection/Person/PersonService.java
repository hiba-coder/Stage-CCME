package com.example.mysql_connection.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;



@Service
public class PersonService {
    @Autowired
    PersonRepo personRepo;

    /*public Optional<Person> getPerson(int id ){
        return  personRepo.findById(id);
    }*////à revenir
    public List<Person> getALLPerson(){
        return personRepo.findAll();
    }
//
//    public void registerPerson(Person person){
//        personRepo.save(person);
//    }


//    public void registerPerson(MultipartFile file, String fullname, String username, String Description) {
//
//        Person person = new Person();
//        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//        if (fileName.contains("..")) {
//            System.out.println("not a a valid file");
//        }
//        try {
//            person.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        person.setFullName(fullname);
//        person.setUserName(username);
//        person.setDescription(Description);
//        personRepo.save(person);
//    }
    public void registerPerson(MultipartFile file, String fullname, String username,String password, String email) {

        Person person = new Person();
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if (fileName.contains("..")) {
            System.out.println("not a a valid file");
        }
        try {
            person.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        person.setFullName(fullname);
        person.setUserName(username);
        person.setPassword(password);
        person.setEmail(email);
    //    person.setDescription("Description");
        personRepo.save(person);
    }

    public Person getPerson(int id){
        return personRepo.findById(id).get();// à supprimer
    }
}
