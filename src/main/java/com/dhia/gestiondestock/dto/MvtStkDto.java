package com.dhia.gestiondestock.dto;

import com.dhia.gestiondestock.model.Article;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MvtStkDto {
    private Integer id;
    private Article article;
}
