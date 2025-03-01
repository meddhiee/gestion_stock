package com.dhia.gestiondestock.exception;

public enum ErrorCodes {
    ARTICLE_NOT_FOUND (1000),
    ARTICLE_NOT_VALID(1001),
    ARTICLE_ALREADY_IN_USE(1002),

    CATEGORY_NOT_FOUND(2000),
    CATEGORY_NOT_VALID(2001),
    CATEGORY_ALREADY_IN_USE(2002),

    COMMANDE_NOT_FOUND(3000),
    COMMANDE_NOT_VALID(3001),
    COMMANDE_CLIENT_NOT_FOUND(4000),
    COMMANDE_CLIENT_NOT_VALID(4001),
    COMMANDE_CLIENT_NON_MODIFIABLE(4002),
    COMMANDE_CLIENT_ALREADY_IN_USE(4003),
    LIGNE_COMMANDE_NOT_FOUND(4000),
    MVT_STK_NOT_FOUND (5000),
    MVT_STK_NOT_VALID (5001),
    UTILISATEUR_NOT_FOUND(6000),
    UTILISATEUR_NOT_VALID(6001),

    UTILISATEUR_ALREADY_EXISTS(12002),
    BAD_CREDENTIALS(12003),
    VENTE_NOT_FOUND(13000),
    VENTE_NOT_VALID(13001),
    VENTE_ALREADY_IN_USE(13002),
    // Liste des exception techniaues
    UPDATE_PHOTO_EXCEPTION(14000),
    UNKNOWN_CONTEXT(14001)
    ;
    private int code;
    ErrorCodes(int code) { this.code = code; }
    public int getCode() { return code; }

}
