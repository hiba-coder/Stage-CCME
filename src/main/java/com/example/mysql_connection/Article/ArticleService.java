package com.example.mysql_connection.Article;

import com.example.mysql_connection.Domain.Domain;
import com.example.mysql_connection.Domain.DomainDAO;
import com.example.mysql_connection.Domain.DomainService;
import com.example.mysql_connection.Person.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleDAO articleDAO;
    @Autowired
    private DomainService domainService;

    public Article save (Article article) {
        return articleDAO.save(article);
    }

    public void registerArticle(MultipartFile file,String name,String Domain,String desc_domaine){
        Article a = new Article();
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if (fileName.contains("..")) {
            System.out.println("not a a valid file");
        }
        try {
            a.setImg(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        int id_Domain_Selected= 0;
        List<Domain> domainSelected = domainService.getALL();
        for(Domain d : domainSelected){
            if (d.getDomain().equals(Domain)) id_Domain_Selected= d.getId_Domain();
        }
        a.setId_Domain_Selected(id_Domain_Selected);
        a.setName(name);
        a.setDescription(desc_domaine);
        articleDAO.save(a);
    }


    public List<Article> getALLArticles(){
        return articleDAO.findAll();
    }


    public Article update(int id_article , Article article) {
        article.setId_article( id_article);
        return articleDAO.save(article);
    }


    public void delete(int id_article){
        articleDAO.deleteById(id_article);
    }
    public void deleteAll(){ articleDAO.deleteAll(); }

}
