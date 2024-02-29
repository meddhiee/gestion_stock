package com.dhia.gestiondestock.services.imp;

import com.dhia.gestiondestock.dto.*;
import com.dhia.gestiondestock.exception.EntityNotFoundException;
import com.dhia.gestiondestock.exception.ErrorCodes;
import com.dhia.gestiondestock.exception.InvalidEntityException;
import com.dhia.gestiondestock.model.Article;
import com.dhia.gestiondestock.model.Commande;
import com.dhia.gestiondestock.model.LigneCommande;
import com.dhia.gestiondestock.repository.ArticleRepository;
import com.dhia.gestiondestock.repository.CommandeRepository;
import com.dhia.gestiondestock.repository.LigneCommandeRepository;
import com.dhia.gestiondestock.services.CommandeService;
import com.dhia.gestiondestock.validator.CategoryValidator;
import com.dhia.gestiondestock.validator.CommandeValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CommandeServiceImpl implements CommandeService {
    private CommandeRepository commandeRepository;
    private ArticleRepository articleRepository;

    private LigneCommandeRepository ligneCommandeRepository;

    @Autowired
    public CommandeServiceImpl(CommandeRepository commandeRepository,
                               ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
        this.commandeRepository = commandeRepository;
    }

    @Override
    public CommandeDto save(CommandeDto dto) {
        List<String> errors = CommandeValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Commande is not valid {}", dto);
            throw new InvalidEntityException("La commande n'est pas valide", ErrorCodes.COMMANDE_NOT_VALID, errors);
        }
        List<String> articleErrors = new ArrayList<>();

        if (dto.getLigneCommande() != null) {
            dto.getLigneCommande().forEach(ligCmdClt -> {
                if (ligCmdClt.getArticle() != null) {
                    Optional<Article> article = articleRepository.findById(ligCmdClt.getArticle().getId());
                    if (article.isEmpty()) {
                        articleErrors.add("L'article avec l'ID " + ligCmdClt.getArticle().getId() + " n'existe pas");
                    }
                } else {
                    articleErrors.add("Impossible d'enregister une commande avec un aticle NULL");
                }
            });
        }

        if (!articleErrors.isEmpty()) {
            log.warn("");
            throw new InvalidEntityException("Article n'existe pas dans la BDD", ErrorCodes.ARTICLE_NOT_FOUND, articleErrors);
        }
        dto.setDateCommande(Instant.now());
        Commande savedCmdClt = commandeRepository.save(CommandeDto.toEntity(dto));

        if (dto.getLigneCommande() != null) {
            dto.getLigneCommande().forEach(ligCmdClt -> {
                LigneCommande ligneCommandeClient = LigneCommandeDto.toEntity(ligCmdClt);
                ligneCommandeClient.setCommande(savedCmdClt);
                ligneCommandeRepository.save(ligneCommandeClient);

            });
        }

        return CommandeDto.fromEntity(savedCmdClt);
    }

    @Override
    public CommandeDto findById(Integer id) {
        if (id == null) {
            log.error("Category IO is null");
            return null;
        }
        return commandeRepository.findById(id)
                .map(CommandeDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucune commande avec L'ID = "+ id +"ete trouve dans la BDD",
                        ErrorCodes.COMMANDE_NOT_FOUND)
                );
    }

    @Override
    public CommandeDto findByCode(String code) {
        return null;
    }

    @Override
    public List<CommandeDto> findAll() {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
