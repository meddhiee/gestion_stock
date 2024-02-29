package com.dhia.gestiondestock.dto;

import com.dhia.gestiondestock.model.Article;
import com.dhia.gestiondestock.model.Category;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Builder
@Data
public class ArticleDto {
    private Integer id;
    private String codeArticle;

    private BigDecimal In_stock;

    private CategoryDto category;

    private BigDecimal Budget_total;

    private BigDecimal PrixVente;

    private BigDecimal PrixAchat;
    private String photo;

    public static ArticleDto fromEntity(Article article){
        if(article==null){
            return null;
        }
        return ArticleDto.builder()
                .id(article.getId())
                .codeArticle(article.getCodeArticle())
                .In_stock(article.getIn_stock())
                .Budget_total(article.getBudget_total())
                .PrixVente(article.getPrixVente())
                .PrixAchat(article.getPrixAchat())
                .build();
    }
    public static Article toEntity(ArticleDto articleDto){
        if(articleDto==null){
            return null;
        }
        Article article=new Article();
        article.setId(articleDto.getId());
        article.setCodeArticle(articleDto.getCodeArticle());
        article.setIn_stock(articleDto.getIn_stock());
        article.setBudget_total(articleDto.getBudget_total());
        article.setPrixVente(articleDto.getPrixVente());
        article.setPrixAchat(articleDto.getPrixAchat());

        return article;
    }
}
