package com.example.mysql_connection.Article;

import javax.persistence.*;

@Entity
@Table
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_article;
    public int id_Domain_Selected ;
    public String name;
    private String description;
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String img;

    public int getId_article() {
        return id_article;
    }

    public void setId_article(int id_article) {
        this.id_article = id_article;
    }

    public int getId_Domain_Selected() {
        return id_Domain_Selected;
    }

    public void setId_Domain_Selected(int id_Domain_Selected) {
        this.id_Domain_Selected = id_Domain_Selected;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
