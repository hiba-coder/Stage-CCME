package com.example.mysql_connection;

import com.example.mysql_connection.Article.ArticleDAO;
import com.example.mysql_connection.Domain.DomainDAO;
import com.example.mysql_connection.Person.PersonRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = {PersonRepo.class, ArticleDAO.class, DomainDAO.class})
public class MysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(MysqlApplication.class, args);
	}

}
