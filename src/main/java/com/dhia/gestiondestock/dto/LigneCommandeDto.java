package com.dhia.gestiondestock.dto;

import com.dhia.gestiondestock.model.Article;
import com.dhia.gestiondestock.model.Category;
import com.dhia.gestiondestock.model.Commande;
import com.dhia.gestiondestock.model.LigneCommande;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Builder
@Data
public class LigneCommandeDto {
    private Integer id;

    private ArticleDto article;

    @JsonIgnore
    private CommandeDto commandeClient;

    private BigDecimal quantite;

    private BigDecimal prixUnitaire;

    private Integer idEntreprise;

    public static LigneCommandeDto fromEntity(LigneCommande ligneCommandeClient) {
        if (ligneCommandeClient == null) {
            return null;
        }
        return LigneCommandeDto.builder()
                .id(ligneCommandeClient.getId())
                .article(ArticleDto.fromEntity(ligneCommandeClient.getArticle()))
                .quantite(ligneCommandeClient.getQuantite())
                .prixUnitaire(ligneCommandeClient.getPrixUnitaire())
                .build();
    }

    public static LigneCommande toEntity(LigneCommandeDto dto) {
        if (dto == null) {
            return null;
        }

        LigneCommande ligneCommandeClient = new LigneCommande();
        ligneCommandeClient.setId(dto.getId());
        ligneCommandeClient.setArticle(ArticleDto.toEntity(dto.getArticle()));
        ligneCommandeClient.setPrixUnitaire(dto.getPrixUnitaire());
        ligneCommandeClient.setQuantite(dto.getQuantite());
        return ligneCommandeClient;
    }

}