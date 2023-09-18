package com.example.projet_industriel_1.service;

import com.example.projet_industriel_1.model.match;
import com.example.projet_industriel_1.model.usersmodel;
import com.example.projet_industriel_1.repository.usersmatch;
import com.example.projet_industriel_1.repository.usersrepository;
import com.fasterxml.jackson.databind.deser.DataFormatReaders;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class userservice1 {
    private final usersmatch usersmatche;



    public userservice1(usersmatch usersmatche) {
        this.usersmatche=usersmatche;
    }
    public match registerusere(String heure,String date,int nbr_joueurs,String login) {
        if (date == null || heure == null || (nbr_joueurs!=5 && nbr_joueurs!=6)) {
            return null;
        } else {
            match m1 = new match();
            m1.setHeure(heure);
            m1.setDate(date);
            m1.setNbr_joueurs(nbr_joueurs);
            m1.setLogin(login);
            return usersmatche.save(m1);
        }}
    public List<match> getAllMatches() {
        return usersmatche.findAll(); // Utilisez la méthode findAll() ou une méthode personnalisée selon votre modèle de données
    }








}
