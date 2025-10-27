package org.example.tricol.services;

import org.example.tricol.models.Fournisseur;
import org.example.tricol.repositories.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FournisseurService {
    @Autowired
    private FournisseurRepository fournisseurRepository;

    public List<Fournisseur> findAll() {
        return fournisseurRepository.findAll();
    }

    public Fournisseur findById(Long id) {
        return fournisseurRepository.findById(id).orElse(null);
    }

    @Transactional
    public Fournisseur save(Fournisseur f) {
        return fournisseurRepository.save(f);
    }

    public void deleteById(Long id) {
        fournisseurRepository.deleteById(id);
    }
}
