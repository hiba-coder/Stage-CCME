package com.example.mysql_connection.Person;

import com.example.mysql_connection.Article.Article;
import com.example.mysql_connection.Article.ArticleService;
import com.example.mysql_connection.Domain.Domain;
import com.example.mysql_connection.Domain.DomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@Controller
public class PersonController {

    @Autowired
    private PersonService personservice;
    @Autowired
    private DomainService domainService;
    @Autowired
    private ArticleService articleService;

    @Autowired
    private PersonDetailsService personDetailsService;

    @GetMapping("/admin")
    public String admin (){
        return("<h1> Welcome amin </h1>");
    }


    @GetMapping("/user")
    public String user (){
        return("<h1> Welcome user </h1>");
    }

    @GetMapping("/")
    public String home(){
        return "Home";
    }

    /*@GetMapping("/Chat")
    public String chat(){
        return "Chat";
    }*/

    @GetMapping("/login")
    public String login(){
        return "Login";
    }
    @GetMapping("/logout")
    public String logout(){
        return "logout";
    }
//    @PostMapping("/Login")
//    public String login(){
//        return "redirect:/indexID";
//    }

    @GetMapping("/MyProfilID")
    public String goMyProfilID(Model model){
        model.addAttribute("persons",personservice.getPerson(personDetailsService.getId()));
        return "MyProfil";
    }

    @GetMapping("/ReadID")
    public String goReadID(Model model){
        model.addAttribute("persons",personservice.getPerson(personDetailsService.getId()));
        return "Read";
    }
    @GetMapping("/indexID")
    public String goindexID(Model model){
        model.addAttribute("Domains",domainService.getALL());
        model.addAttribute("Articles",articleService.getALLArticles());
        model.addAttribute("persons",personservice.getPerson(personDetailsService.getId()));
        return "index";
    }

    @GetMapping("/in")
    public String goi(Model model){
        model.addAttribute("Domains",domainService.getALL());
        model.addAttribute("Articles",articleService.getALLArticles());
        model.addAttribute("persons",personservice.getPerson(personDetailsService.getId()));
        return "indexID";
    }

    @GetMapping("/Pr")
    public String gopr(Model model){
        model.addAttribute("Domains",domainService.getALL());
        model.addAttribute("Articles",articleService.getALLArticles());
        model.addAttribute("persons",personservice.getPerson(personDetailsService.getId()));
        return "profilID";
    }



    @GetMapping("/ThemeID")
    public String goThemeID(Model model){
        Domain domain = new Domain();
        model.addAttribute("Domain",domain);
        Article article = new Article();
        model.addAttribute("Article",article);
        model.addAttribute("persons",personservice.getPerson(personDetailsService.getId()));
        model.addAttribute("Domains",domainService.getALL());
        return "Theme";
    }
    @GetMapping("/ThemeIDAdmin")
    public String goThemeIDAdmin(Model model){
        Domain domain = new Domain();
        model.addAttribute("Domain",domain);
        model.addAttribute("persons",personservice.getPerson(personDetailsService.getId()));
        model.addAttribute("Domains",domainService.getALL());
        return "ThemeAdmin";
    }

    @GetMapping("/MyAccountID")
    public String getMyProfilID(Model model){
        model.addAttribute("persons",personservice.getPerson(personDetailsService.getId()));
        return "MyAccount";
    }
/*************************ALLUsser*******************************/

    @GetMapping("/Chat")
    public String goChat(Model model){
        model.addAttribute("persons",personservice.getALLPerson());
        return "Chat";
    }

    @GetMapping("/MyProfil")
    public String goMyProfil(Model model){
        model.addAttribute("persons",personservice.getALLPerson());
        return "MyProfil";
    }
    @GetMapping("/Read")
    public String goRead(Model model){
        model.addAttribute("persons",personservice.getALLPerson());
        return "Read";
    }
    @GetMapping("/index")
    public String goindex(Model model){
        model.addAttribute("persons",personservice.getALLPerson());
        return "index";
    }
    @GetMapping("/Theme")
    public String goTheme(Model model){
        model.addAttribute("persons",personservice.getALLPerson());
        return "Theme";
    }

    @GetMapping("/MyAccount")
    public String getMyProfil(Model model){
        model.addAttribute("persons",personservice.getALLPerson());
        return "MyAccount";
    }

    @GetMapping("/register")
    public String register(Model model){
        Person person = new Person();
        model.addAttribute("person",person);
        return "registerPage";
    }
//    @PostMapping("/CreateAccount")
//    public String saveAccount(@ModelAttribute("person") Person person){
//        personservice.registerPerson(person);
//        return "MyAccount";
//    }


//    @PostMapping("/CreateAccount")
//    public String saveUser(@RequestParam("file") MultipartFile file,
//                           @RequestParam("fullname") String fullname,
//                           @RequestParam("username") String username,
//                           @RequestParam("description") String description){
//        personservice.registerPerson(file,fullname,username,description);
//
//        return "MyAccount";
//
//    }
    @PostMapping("/CreateAccount")
    public String saveUser(@RequestParam("file") MultipartFile file,
                           @RequestParam("fullName") String fullname,
                           @RequestParam("userName") String username,
                           @RequestParam("password") String password,
                           @RequestParam("email") String email){
        personservice.registerPerson(file,fullname,username,password,email);

        return "redirect:/login";

    }
}
