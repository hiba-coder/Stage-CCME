package com.example.mysql_connection.Domain;


import com.example.mysql_connection.Person.Person;
import com.example.mysql_connection.Domain.DomainDAO;
import com.sun.javafx.sg.prism.NGTriangleMesh;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
public class DomainService {

    @Autowired
    private DomainDAO domainDAO;

    public Domain  save (Domain domain) {
        return domainDAO.save(domain);
    }

    public void registerDomain(String domain){
        Domain d = new Domain();
        d.setDomain(domain);
        domainDAO.save(d);
    }

    public List<Domain> getALL(){
        return domainDAO.findAll();
    }


    public Domain update(int id_Domain , Domain domain) {
        domain.setId_Domain( id_Domain);
        return domainDAO.save(domain);
    }


    public void delete(int id_Domain){
        domainDAO.deleteById(id_Domain);
    }
    public void deleteAll(){ domainDAO.deleteAll(); }
    @Bean
    public boolean NGTriangleMesh(){
       return true;
    }
}
