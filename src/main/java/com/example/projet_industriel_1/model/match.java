package com.example.projet_industriel_1.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "match_foot")
public class match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String heure;
    String date;

    String login;

    int nbr_joueurs;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getNbr_joueurs() {
        return nbr_joueurs;
    }

    public void setNbr_joueurs(int nbr_joueurs) {
        this.nbr_joueurs = nbr_joueurs;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public match(String heure, String date, int nbr_joueurs, String login) {
        this.login=login;
        this.heure = heure;
        this.date = date;
        this.nbr_joueurs = nbr_joueurs;
    }

    public match() {
    }
}
