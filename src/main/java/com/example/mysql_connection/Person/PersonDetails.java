package com.example.mysql_connection.Person;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class PersonDetails implements UserDetails {
    private int id; // à supprimer
    private String userName;
    private String password;
//    private boolean active;
    private List<GrantedAuthority> authorities;

    public PersonDetails(Person person){
        this.id=person.getId();// à supprimer
        this.userName = person.getUserName();
        this.password = person.getPassword();
//        this.active = person.isActive();
        this.authorities = Arrays.stream(person.getRoles().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    public int getId(){
        return id;// à supprimer
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
