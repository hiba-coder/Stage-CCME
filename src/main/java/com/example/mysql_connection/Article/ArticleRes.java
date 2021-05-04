package com.example.mysql_connection.Article;

import com.example.mysql_connection.Domain.Domain;
import com.example.mysql_connection.Domain.DomainDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class ArticleRes {
    @Autowired
    private ArticleService articleService;


    @PostMapping("/ArticleSave")
    public String saveArticle ( @RequestParam("file") MultipartFile file,
                                @RequestParam("name") String name,
                                @RequestParam("domain") String domain,
                                @RequestParam("description") String description){
        articleService.registerArticle(file,name, domain, description);

        return "redirect:/ThemeID";

    }


}
