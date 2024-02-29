package com.dhia.gestiondestock.exception;

public enum ErrorCodes {
    ARTICLE_NOT_FOUND (1000),
    ARTICLE_NOT_VALID(1001),
    CATEGORY_NOT_FOUND(2000),
    CATEGORY_NOT_VALID(2001),
    // TODO complete the rest of the Error Codes

    COMMANDE_NOT_FOUND(3000),
    COMMANDE_NOT_VALID(3001),
    LIGNE_COMMANDE_NOT_FOUND(4000),
    MVT_STK_NOT_FOUND (5000),
    MVT_STK_NOT_VALID (5001),
    UTILISATEUR_NOT_FOUND(6000),
    UTILISATEUR_NOT_VALID(6001),
    BAD_CREDENTIALS(12003),
    ;
    private int code;
    ErrorCodes(int code) { this.code = code; }
    public int getCode() { return code; }

}
