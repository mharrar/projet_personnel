package com.example.projet_industriel_1.controller;

import com.example.projet_industriel_1.model.match;
import com.example.projet_industriel_1.model.usersmodel;
import com.example.projet_industriel_1.repository.usersrepository;
import com.example.projet_industriel_1.service.userservice;
import com.example.projet_industriel_1.service.userservice1;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Service
@Controller
public class userscontroller {



    private final userservice userservices;
    private final userservice1 userservices1;

    public userscontroller(userservice userservices,userservice1 userservices1) {
    this.userservices=userservices;
    this.userservices1=userservices1;}
    //pour acceder au template HTML first_page(page de connection à l'application)
    @GetMapping(path = "/login")
    public String pagefirst(Model model){

        model.addAttribute("loginRequest",new usersmodel());

        return "first_page";}


    //pour acceder au template HTML second_page(la page d'enregistrement)
    @GetMapping(path = "/register")
    public String getloginpage(Model model)
    {model.addAttribute("registerRequest",new usersmodel());
        return "second_page";}

    //pour enregistrer les données concernant le template HTML second_page(la page d'enregistrement)
    @PostMapping(path = "/register")
    public String register(@ModelAttribute usersmodel usersmodels,Model model)
    {System.out.println("register request:"+usersmodels);
    usersmodel registerUser=userservices.registeruser(usersmodels.getLogin(),usersmodels.getPassword(),usersmodels.getEmail(),usersmodels.getFullname(),usersmodels.getNumero_telephone());
    model.addAttribute("userfullname",registerUser.getFullname());
    return registerUser == null ? "error_page" : "redirect:/login";}
    //pour enregistrer les données concernant le template HTML first_page(page de connection à l'application)
    @PostMapping(path = "/login")
    public String login(@ModelAttribute usersmodel usersmodels,Model model)
    {System.out.println("login request:"+usersmodels);
        usersmodel authenticated=userservices.authenticate(usersmodels.getLogin(),usersmodels.getPassword());


        if (authenticated!=null)
        {model.addAttribute("userlogin",authenticated.getLogin());
            return "personal_page";}
        else
        {return "error_page";}

    }
    //pour acceder au template HTML page_recherche(la page de recherche des matchs)
    @GetMapping(path = "/chercher")
    public String chercher(Model model)
    {model.addAttribute("findteam",new usersmodel());
    return "page_recherche";}

    //Pour acceder au template HTML personal_page(la page d'accueil)
    @GetMapping(path = "/accueil")
    public String accueil(Model model)
    {model.addAttribute("accueil",new usersmodel());
        return "personal_page";}
    //Pour acceder au template HTML liste_matchs(la page ou il y'a une liste de matchs et leur états)
    @GetMapping(path = "/liste_match")
    public String liste_match(Model model)
    {model.addAttribute("accueil",new usersmodel());
        return "liste_matchs";}

    //Pour acceder au template HTML
   /* @RequestMapping("/test")
    public String test(Model model) {
        String x="smatch";
        model.addAttribute("x",x);
        return "test";
    }*/
    @PostMapping(path = "/matching")
    public String matching(@ModelAttribute match m1,Model model)
    {System.out.println("register request:"+m1);
        match mcrit= userservices1.registerusere(m1.getHeure(),m1.getDate(),m1.getNbr_joueurs(),m1.getLogin());
        List<match> allMatches = userservices1.getAllMatches();
        model.addAttribute("matches", allMatches);
        System.out.println("Nombre de matches récupérés : " + allMatches.size());
        for (match match : allMatches) {
            System.out.println("Match ID : " + match.getId());
            System.out.println("Heure : " + match.getHeure());
            System.out.println("Date : " + match.getDate());
            System.out.println("Nombre de joueurs : " + match.getNbr_joueurs());
            // Ajoutez d'autres propriétés à afficher si nécessaire
        }
        return "redirect:/resultat";};

    @GetMapping(path = "/but")
    public String pagebut(Model model){
        model.addAttribute("loginRequest",new usersmodel());
        return "page_but";}
    @GetMapping(path = "/resultat")
    public String resultat(Model model){
        List<match> allMatches = userservices1.getAllMatches();
        model.addAttribute("matches", allMatches);
        return "resultat_recherche";}
    @GetMapping(path = "/resultat_neg")
    public String resneg(Model model){
        model.addAttribute("loginRequest",new usersmodel());
        return "page_neg";}







    }







