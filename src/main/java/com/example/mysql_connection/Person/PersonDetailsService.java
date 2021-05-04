package com.example.mysql_connection.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonDetailsService implements UserDetailsService {
    int id;// à supprimer
    @Autowired
    PersonRepo personRepo;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<Person> user =personRepo.findByUserName(userName);
        id = user.map(PersonDetails::new).get().getId();// à supprimer
        user.orElseThrow(()-> new UsernameNotFoundException("Not found"+ userName));
        return user.map(PersonDetails::new).get();
    }
    public int getId(){
        return id ;// à supprimer
    }
}
