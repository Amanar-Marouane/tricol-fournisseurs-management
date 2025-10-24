package org.example.tricol.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "fournisseurs")
@Data
public class Fournisseur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String societe;
    private String adresse;
    private String contact;
    private String email;
    private String telephone;
    private String ville;
    private String ice;
}
