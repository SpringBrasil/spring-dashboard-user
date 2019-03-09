package br.com.springbrasil.user.rest;

import  br.com.springbrasil.user.service.ComercialUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/login")
public class LoginRest {

    @Autowired
    private ComercialUserDetailsService comercialUserDetailsService;

    @GetMapping("/{login}")
    public void login(@PathVariable String login) {
        System.out.println("oi");
        comercialUserDetailsService.loadUserByUsername(login);
    }
}
