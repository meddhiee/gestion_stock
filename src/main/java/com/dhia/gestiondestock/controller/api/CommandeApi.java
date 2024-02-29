package com.dhia.gestiondestock.controller.api;

import com.dhia.gestiondestock.dto.CommandeDto;
import com.dhia.gestiondestock.dto.LigneCommandeDto;
import io.swagger.annotations.Api;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.dhia.gestiondestock.utils.Constants.APP_ROOT;

@Api("commandes")
public interface CommandeApi {


    @PostMapping(APP_ROOT + "/commandes/create")
    ResponseEntity<CommandeDto> save(@RequestBody CommandeDto dto);

    @GetMapping(APP_ROOT + "/commandes/{idCommande}")
    ResponseEntity<CommandeDto> findById(@PathVariable Integer idCommande);

    @GetMapping(APP_ROOT + "/commandes/filter/{codeCommande}")
    ResponseEntity<CommandeDto> findByCode(@PathVariable("codeCommande") String code);

    @GetMapping(APP_ROOT + "/commandes/all")
    ResponseEntity<List<CommandeDto>> findAll();

    @DeleteMapping(APP_ROOT + "/commandes/delete/{idCommande}")
    ResponseEntity<Void> delete(@PathVariable("idCommande") Integer id);

}