package com.example.sp2.controller;


import com.example.sp2.model.Acteur;
import com.example.sp2.services.ActeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/acteur")
public class ActeurController {

    @Autowired
    private ActeurService acteurService;

    @GetMapping("/list")
    public String listeActeur(Model model) {
        List<Acteur> acteurs = acteurService.findAll(); //DAO
        model.addAttribute("acteurs",acteurs);
        //liaison model/view
        System.out.println(acteurs);
        return("acteurs");
    }

    @GetMapping("/getOne/{id}")
    public String getOneActeur(@PathVariable("id") int Id_acteur, Model model) {
        Acteur act = acteurService.findById(Id_acteur);
        model.addAttribute("acteur",act);
        return("acteur");


    }

    @GetMapping("/ajoutacteur")
    public String ajouteracteur(){
        return("ajoutacteur");
    }

    @PostMapping("/ajoutacteur")
    public String ajoutacteur(@RequestParam String nom, @RequestParam String prenom, @RequestParam String photo) {
         Acteur newActeur = new Acteur();
                 newActeur.setNom(nom);
                 newActeur.setPrenom(prenom);
                 newActeur.setPhoto(photo);
        acteurService.ajoutActeur(newActeur);
        return ("ajoutacteur");
    }

    @GetMapping("/updateacteur")
    public String updateacteurs(){
        return("updateacteur");
    }

    @PutMapping("/updateacteur/{id}")
    public String updateacteur(@PathVariable("id") int Id_acteur,@RequestBody Acteur acteur) {
        Acteur act = acteurService.findById(Id_acteur);
        if(act == null) {
            return "redirect:/acteur/updateacteur/{id}";
        }
            act.setNom(acteur.getNom());
            act.setPrenom(acteur.getPrenom());
            act.setPhoto(acteur.getPhoto());
            acteurService.ajoutActeur(act);

        return ("updateacteur");
    }

    @DeleteMapping("/deleteacteur/{id}")
    public String deleteacteur(@PathVariable("id") int Id_acteur) {
        Acteur act = acteurService.findById(Id_acteur);
        if(act != null){
            acteurService.deleteById(Id_acteur);
        }else{
            System.out.println("this actor doesn't exist");
        }
        return("deleteacteur");
        }
}

