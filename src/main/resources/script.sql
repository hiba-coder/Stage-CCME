create database app_spring;
create table Person (
                        id INT NOT NULL AUTO_INCREMENT ,
                        full_name  VARCHAR(30),
                        user_name VARCHAR(30),
                        password VARCHAR(30),
                        roles VARCHAR(30),
                        description VARCHAR(300),
                        email VARCHAR(300),
                        image LONGBLOB,
                        CONSTRAINT PK_ART primary key (id)
);
create table Domain(
                       id_Domain INT NOT NULL AUTO_INCREMENT,
                       domain  VARCHAR(30),
                       CONSTRAINT PK_ART primary key (id_Domain)
);

create table Article (
                         id_article INT NOT NULL AUTO_INCREMENT ,
                         id_Domain_Selected INT ,
                         name  VARCHAR(30),
                         description VARCHAR(300),
                         img LONGBLOB,
                         CONSTRAINT PK_ART primary key (id_article)
);
INSERT INTO Person VALUES (1,'User1','User1','pass','ROLE_USER','eleve ingenieur','uer1@gmail.com','');

INSERT INTO Domain VALUES (1,'Economique');
INSERT INTO Domain VALUES (NULL,'Informatique');
INSERT INTO Domain VALUES (NULL,'Education');
INSERT INTO Domain VALUES (NULL,'Medcine');
INSERT INTO Domain VALUES (NULL,'Travail');
