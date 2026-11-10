package com.example.douanetemporelle;

public class CleExtra {


    public static final String MATRICULE = "1234";

    public static String construireCle(String matricule, String nom) {
        return matricule + "_" + nom;
    }

    public static String nomVoyageur(String matricule) {
        return construireCle(matricule, "NOM_VOYAGEUR");
    }

    public static String anneeNaissance(String matricule) {
        return construireCle(matricule, "ANNEE_NAISSANCE");
    }

    public static String anneeDestination(String matricule) {
        return construireCle(matricule, "ANNEE_DESTINATION");
    }

    public static String motif(String matricule) {
        return construireCle(matricule, "MOTIF");
    }

    public static String verdict(String matricule) {
        return construireCle(matricule, "VERDICT");
    }
}