package com.example.mysql_connection.Domain;

import com.example.mysql_connection.Article.Article;
import org.springframework.context.annotation.Bean;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DomainDAO extends JpaRepository<Domain,Integer> {
    //List<Domain> findByDomain(String Domain);
   // List<Domain> findByName(String name);


    //List<Domain> findByDomaine(String domain);

    @Override
    List<Domain> findAll();
}
