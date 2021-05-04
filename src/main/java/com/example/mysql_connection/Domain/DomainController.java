package com.example.mysql_connection.Domain;


import com.example.mysql_connection.Article.Article;
import com.example.mysql_connection.Article.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/D")
@CrossOrigin(origins ="*")
public class DomainController {

    @Autowired
    private DomainDAO domainDAO;

    @Autowired
    private ArticleService articleService;

    @PostMapping("/addDomain")
    public String  addDomain(@RequestBody Domain domain) {
        domainDAO.save(domain);
        return "hi";
    }

    @GetMapping("/getAllDomain")
    public List<Domain> getAllDomain() {
        return domainDAO.findAll();
    }


//
//    @GetMapping("/findDomainByname/{domain}")
//    public List<Domain> findDomain(@PathVariable String domain) {
//        return domainDAO.findByDomain(domain);
//    }



    @DeleteMapping("/cancelDomain/{id_Domain}")
    public List<Domain> cancelDomain(@PathVariable int id_Domain) {
        domainDAO.deleteById(id_Domain);
        return domainDAO.findAll();
    }

    @GetMapping("/getArticleSelected")
    public Article getArticleSelected(Domain domain){
        List<Article> articleSelected = articleService.getALLArticles();
        for(Article a : articleSelected){
            if(a.getId_Domain_Selected()== domain.getId_Domain()){
                return a;
            }
        }
        return null;
    }


}
