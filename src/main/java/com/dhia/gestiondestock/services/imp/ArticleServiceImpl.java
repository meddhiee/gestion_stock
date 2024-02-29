package com.dhia.gestiondestock.services.imp;

import com.dhia.gestiondestock.dto.ArticleDto;
import com.dhia.gestiondestock.exception.EntityNotFoundException;
import com.dhia.gestiondestock.exception.InvalidEntityException;
import com.dhia.gestiondestock.exception.ErrorCodes;
import com.dhia.gestiondestock.model.Article;
import com.dhia.gestiondestock.repository.ArticleRepository;
import com.dhia.gestiondestock.services.ArticleService;
import com.dhia.gestiondestock.validator.ArticleValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public ArticleDto save(ArticleDto dto) {
        List<String> errors = ArticleValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Article is not valid {}", dto);
            throw new InvalidEntityException("L'article n'est pas valide", ErrorCodes.ARTICLE_NOT_VALID, errors);
        }

        Article savedArticle = articleRepository.save(ArticleDto.toEntity(dto));
        return ArticleDto.fromEntity(savedArticle);
    }

    @Override
    public ArticleDto findById(Integer id) {
        if (id == null) {
            log.error("Article ID is null");
            throw new IllegalArgumentException("Article ID cannot be null");
        }

        Optional<Article> articleOptional = articleRepository.findById(id);
        if (articleOptional.isEmpty()) {
            throw new EntityNotFoundException("Aucun article avec l'ID = " + id + " n'a été trouvé dans la BDD",
                    ErrorCodes.ARTICLE_NOT_FOUND);
        }

        return ArticleDto.fromEntity(articleOptional.get());
    }

    @Override
    public ArticleDto findByCodeArticle(String codeArticle) {
        if (!StringUtils.hasLength(codeArticle)) {
            log.error("Article CODE is null or empty");
            throw new IllegalArgumentException("Article CODE cannot be null or empty");
        }

        Optional<Article> articleOptional = articleRepository.findArtcileByCodeArticle(codeArticle);
        if (articleOptional.isEmpty()) {
            throw new EntityNotFoundException("Aucun article avec le CODE = " + codeArticle + " n'a été trouvé dans la BDD",
                    ErrorCodes.ARTICLE_NOT_FOUND);
        }

        return ArticleDto.fromEntity(articleOptional.get());
    }

    @Override
    public List<ArticleDto> findAll() {
        return articleRepository.findAll().stream()
                .map(ArticleDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Article ID is null");
            throw new IllegalArgumentException("Article ID cannot be null");
        }

        articleRepository.deleteById(id);
    }
}