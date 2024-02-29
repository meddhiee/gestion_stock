package com.dhia.gestiondestock.controller;

import java.math.BigDecimal;
import java.util.List;

import com.dhia.gestiondestock.controller.api.CommandeApi;
import com.dhia.gestiondestock.dto.CommandeDto;
import com.dhia.gestiondestock.dto.LigneCommandeDto;
import com.dhia.gestiondestock.services.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommandeController implements CommandeApi {

    private CommandeService commandeClientService;

    @Autowired
    public CommandeController(CommandeService commandeClientService) {
        this.commandeClientService = commandeClientService;
    }

    @Override
    public ResponseEntity<CommandeDto> save(CommandeDto dto) {
        return ResponseEntity.ok(commandeClientService.save(dto));
    }



    @Override
    public ResponseEntity<CommandeDto> findById(Integer id) {
        return ResponseEntity.ok(commandeClientService.findById(id));
    }

    @Override
    public ResponseEntity<CommandeDto> findByCode(String code) {
        return ResponseEntity.ok(commandeClientService.findByCode(code));
    }

    @Override
    public ResponseEntity<List<CommandeDto>> findAll() {
        return ResponseEntity.ok(commandeClientService.findAll());
    }

    @Override
    public ResponseEntity<Void> delete(Integer id) {
        commandeClientService.delete(id);
        return ResponseEntity.ok().build();
    }
}