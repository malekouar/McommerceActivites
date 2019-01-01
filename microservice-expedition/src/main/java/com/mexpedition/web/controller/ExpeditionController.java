package com.mexpedition.web.controller;

import com.mexpedition.dao.ExpeditionDao;
import com.mexpedition.model.Expedition;
import com.mexpedition.web.exceptions.ExpeditionNotFoudException;
import com.mexpedition.web.exceptions.ImpossibleAjouterExpeditionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ExpeditionController {

    @Autowired
    ExpeditionDao expeditionDao;

    @PostMapping(value = "/expeditions")
    public ResponseEntity<Expedition> ajouterExpedition(@RequestBody Expedition expedition) throws ImpossibleAjouterExpeditionException {

        Expedition nouvelleExpedition = expeditionDao.save(expedition);

        if (nouvelleExpedition == null)
            throw new ImpossibleAjouterExpeditionException("Impossible d'ajouter cette expedition");

        return new ResponseEntity<Expedition>(expedition, HttpStatus.CREATED);
    }

    @GetMapping(value = "/expeditions/{id}")
    public Optional<Expedition> recupererUneExpedition(@PathVariable int id) throws ExpeditionNotFoudException {

        Optional<Expedition> expedition = expeditionDao.findById(id);

        if (!expedition.isPresent()) throw new ExpeditionNotFoudException("Cette expedition n'existe pas");

        return expedition;
    }

    @GetMapping(value = "/expeditions/commande/{idCommande}")
    public Expedition recupererUneExpeditionCommande(@PathVariable int idCommande) throws ExpeditionNotFoudException {

        Expedition expedition = expeditionDao.findByidCommande(idCommande);

        if (expedition == null)
            throw new ExpeditionNotFoudException("Cette expedition (ou cette commande) n'existe pas");

        return expedition;
    }

    @PutMapping(value = "/expeditions")
    public void updateExpedition(@RequestBody Expedition expedition) {

        expeditionDao.save(expedition);
    }
}
