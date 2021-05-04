package com.example.mysql_connection.Article;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleDAO extends JpaRepository<Article,Integer> {


    @Override
    List<Article> findAll();
}
