package org.example.tricol.controllers;

import org.example.tricol.models.Fournisseur;
import org.example.tricol.services.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/fournisseurs")
public class FournisseurController {
    @Autowired
    private FournisseurService service;

    @GetMapping
    public List<Fournisseur> findAll()
        throws Exception {
        return service.findAll();
    }
}
