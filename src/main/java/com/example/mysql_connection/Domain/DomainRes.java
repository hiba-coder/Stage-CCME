package com.example.mysql_connection.Domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class DomainRes {
    @Autowired
    private DomainService domainService;

    @PostMapping("/DomainSave")
    public String saveDomain ( @RequestParam("Domain") String domain){
        domainService.registerDomain(domain);

        return "redirect:/ThemeID";

    }


    @PostMapping("/DomainSaveAdmin")
    public String saveDomainAdmin ( @RequestParam("Domain") String domain){
        domainService.registerDomain(domain);

        return "redirect:/ThemeIDAdmin";

    }

    @DeleteMapping("/cancelDomain/{id_Domain}")
    public String cancelDomain(@PathVariable int id_Domain) {
        domainService.delete(id_Domain);
        return "redirect:ThemeID";
    }
}
