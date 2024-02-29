package com.dhia.gestiondestock.services;

import com.dhia.gestiondestock.dto.ArticleDto;
import com.dhia.gestiondestock.dto.CommandeDto;

import java.util.List;

public interface CommandeService {
    CommandeDto save(CommandeDto dto);
    CommandeDto findById(Integer id);
    CommandeDto findByCode(String code);
    List<CommandeDto> findAll();
    void delete(Integer id);
}
