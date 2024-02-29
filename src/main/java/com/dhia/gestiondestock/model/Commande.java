package com.dhia.gestiondestock.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.List;


import java.time.Instant;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@Entity
@Table(name="commande")
public class Commande extends AbstractEntity{
    @Column(name = "code")
    private String code;
    @Column(name = "dateCommande")
    private Instant dateCommande;

    @OneToMany(mappedBy = "commande")
    private List<LigneCommande> ligneCommandes;
}
