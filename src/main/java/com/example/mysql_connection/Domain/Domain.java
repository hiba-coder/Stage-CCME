package com.example.mysql_connection.Domain;


import com.example.mysql_connection.Article.Article;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Domain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//GenerationType.AUTO
    private int id_Domain;
    public String Domain;
    //public List<Article> articleSelected = new List<Article>();



    public int getId_Domain() {
        return id_Domain;
    }

    public void setId_Domain(int id_Domain) {
        this.id_Domain = id_Domain;
    }

    public String getDomain() {
        return Domain;
    }

    public void setDomain(String domain) {
        Domain = domain;
    }
}
