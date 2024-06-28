package com.example.sp2.services;

import com.example.sp2.model.Acteur;
import com.example.sp2.repositories.ActeurRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
public class ActeurService {

    @Autowired
            /*
    @Autowired est une annotation de Spring utilisée pour l'injection automatique de dépendances.
    Cela signifie que Spring fournira automatiquement les dépendances requises pour votre classe
    sans que vous ayez à les créer explicitement.
    Lorsque vous annotez un champ, un constructeur ou une méthode setter avec @Autowired,
    Spring essaiera de trouver un bean correspondant (un objet géré par Spring) et de l'injecter.
    */

    ActeurRepo acteurRepo;

    public List<Acteur> findAll() { return acteurRepo.findAll();}

    public Acteur getOne(int Id_acteur) {
        return acteurRepo.getReferenceById(Id_acteur);
    }

    public Acteur ajoutActeur(Acteur newActeur) {
        return acteurRepo.save(newActeur);

    }
    public Acteur updateActeur(Acteur newActeur, int Id_acteur) {
        return acteurRepo.save(newActeur);
    }

    public Acteur findById(int Id_acteur) {
        return acteurRepo.findById(Id_acteur).get();
    }

    public void deleteById(int Id_acteur) {
        acteurRepo.deleteById(Id_acteur);
    }

}
