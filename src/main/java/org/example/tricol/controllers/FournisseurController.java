package org.example.tricol.controllers;

import org.example.tricol.models.Fournisseur;
import org.example.tricol.services.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/v1/fournisseurs")
public class FournisseurController {
    @Autowired
    private FournisseurService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Fournisseur> findAll() throws Exception {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Fournisseur> findById(@PathVariable("id") Long id) throws Exception {
        Fournisseur fournisseur = service.findById(id);
        if (fournisseur == null) {
            return notFound();
        }
        return ResponseEntity.ok(fournisseur);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Fournisseur> create(@RequestBody Fournisseur fournisseur) throws Exception {
        return ResponseEntity.ok(service.save(fournisseur));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) throws Exception {
        Fournisseur existingFournisseur = service.findById(id);
        if (existingFournisseur == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .header("Content-Type", "application/json")
                    .body(null);
        }
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Fournisseur> update(@PathVariable("id") Long id, @RequestBody Fournisseur fournisseur)
            throws Exception {
        Fournisseur existingFournisseur = service.findById(id);
        if (existingFournisseur == null) {
            return notFound();
        }
        fournisseur.setId(id);
        return ResponseEntity.ok(service.save(fournisseur));
    }

    private ResponseEntity<Fournisseur> notFound() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .header("Content-Type", "application/json")
                .body(null);
    }
}
