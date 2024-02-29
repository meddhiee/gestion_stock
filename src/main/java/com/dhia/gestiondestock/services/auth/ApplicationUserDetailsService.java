package com.dhia.gestiondestock.services.auth;

import java.util.ArrayList;
import java.util.List;

import com.dhia.gestiondestock.dto.UtilisateurDto;
import com.dhia.gestiondestock.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {

    @Autowired
    private UtilisateurService service;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UtilisateurDto utilisateur = service.findByEmail(email);


        return new ExtendedUser(utilisateur.getEmail(), utilisateur.getMotdepasse(), authorities);
    }
}