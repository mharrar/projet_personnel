package com.example.projet_industriel_1.service;

import com.example.projet_industriel_1.model.match;
import com.example.projet_industriel_1.model.usersmodel;
import com.example.projet_industriel_1.repository.usersmatch;
import com.example.projet_industriel_1.repository.usersrepository;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;


@Service
public class userservice {
    private final usersrepository usersrepo;



    public userservice(usersrepository usersrepo) {
        this.usersrepo = usersrepo;
    }

    public usersmodel registeruser(String login, String password, String email,String fullname,String numero_telephone) {
        if (login == null || password == null) {
            return null;
        } else {
            usersmodel usersmode = new usersmodel();
            usersmode.setLogin(login);
            usersmode.setEmail(email);
            usersmode.setPassword(password);
            usersmode.setFullname(fullname);
            usersmode.setNumero_telephone(numero_telephone);
            return usersrepo.save(usersmode);
        }}




    public usersmodel authenticate(String login, String password)
    {return usersrepo.findByloginAndPassword(login,password).orElse(null);
    }
}