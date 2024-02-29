package com.dhia.gestiondestock.dto;

import com.dhia.gestiondestock.model.Commande;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Builder
@Data
public class CommandeDto {
    private Integer id;
    private String code;

    private Instant dateCommande;

    private List<LigneCommandeDto> ligneCommande;

    public static CommandeDto fromEntity(Commande commande){
        if(commande==null){
            return null;
        }
        return CommandeDto.builder()
                .id(commande.getId())
                .code(commande.getCode())
                .dateCommande(commande.getDateCommande())
                .build();
    }
    public static Commande toEntity(CommandeDto dto){
        if(dto==null){
            return null;
        }
        Commande commande=new Commande();
        commande.setId(dto.getId());
        commande.setCode(dto.getCode());
        commande.setDateCommande(dto.getDateCommande());

        return commande;
    }
}
