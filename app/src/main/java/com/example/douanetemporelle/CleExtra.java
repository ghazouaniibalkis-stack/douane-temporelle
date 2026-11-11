package com.example.douanetemporelle;

public class CleExtra {

    // Nestaamlou les 4 derniers chiffres de la CIN comme début de chaque clé, w nkawenou les clés b méthode static
    public static final String MATRICULE = "6747";

     //aatit lformes li bech ihez beha les données
    public static String construireCle(String matricule, String champ) {
        return matricule + "_" + champ;
    }

    //méthode hedhi hiya bech tkhazen lesm bel est3ml mtaa matricule bech nfar9o bineto w bin lbe9ii
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