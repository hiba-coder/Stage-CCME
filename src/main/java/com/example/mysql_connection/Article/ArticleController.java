package com.example.mysql_connection.Article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/A")
@CrossOrigin(origins ="*")
public class ArticleController {

    @Autowired
    private ArticleDAO articleDAO;

//    @PostMapping("/addArticle")
//    public Article addArticle(@RequestBody Article article) {
//        articleDAO.save(article);
//        return article;
//    }

    @PostMapping("/addArticle")
    public Article addArticle(@RequestBody Article article,int id_Domain) {
        article.setId_Domain_Selected(id_Domain);
        articleDAO.save(article);
        return article;
    }


    @GetMapping("/getAllArticles")
    public List<Article> getAllArticles() {
        return articleDAO.findAll();
    }


//
//    @GetMapping("/findDomainByname/{domain}")
//    public List<Domain> findDomain(@PathVariable String domain) {
//        return domainDAO.findByDomain(domain);
//    }



    @DeleteMapping("/cancelArticle/{id_article}")
    public List<Article> cancelArticle(@PathVariable int id_article) {
        articleDAO.deleteById(id_article);
        return articleDAO.findAll();
    }
}
