package com.example.douanetemporelle;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class VerificationActivity extends AppCompatActivity {

    // 1: Déclarer les éléments de l'interface
    TextView tvNom, tvAge, tvMotif;
    Button btnApprouver, btnRefuser;

    // 2: N5aznou esm el voyageur bech naba3thou lel écran thenya (ResultActivity)
    String nom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);

        // 3: Norbtou kol élément bel id mte3ou el mawjoud fi fichier XML
        tvNom = findViewById(R.id.tv_nom_gb);
        tvAge = findViewById(R.id.tv_age_gb);
        tvMotif = findViewById(R.id.tv_motif_resume_gb);
        btnApprouver = findViewById(R.id.btn_approuver_gb);
        btnRefuser = findViewById(R.id.btn_refuser_gb);

        // 4: Nesta9blou les informations eli ba3thathom el écran loula
        Intent intent = getIntent();
        String m = CleExtra.MATRICULE;
        nom = intent.getStringExtra(CleExtra.nomVoyageur(m));
        int naissance = intent.getIntExtra(CleExtra.anneeNaissance(m), 0);
        int destination = intent.getIntExtra(CleExtra.anneeDestination(m), 0);
        String motif = intent.getStringExtra(CleExtra.motif(m));

        // 5: N7asbou l'âge temporel = année destination - année naissance
        int age = destination - naissance;

        // 6: N'affichiw les informations fel écran
        tvNom.setText("Nom : " + nom);
        tvAge.setText("Âge temporel : " + age + " ans");
        tvMotif.setText("Motif : " + motif);

        // 7: Ken el motif "Modification du passé" wel âge nombre premier, na3tlou bouton approbation bil gris

        if (motif.equals("Modification du passé") && estPremier(age)) {
            btnApprouver.setEnabled(false);
            btnApprouver.setBackgroundTintList(
                    android.content.res.ColorStateList.valueOf(android.graphics.Color.GRAY));
            btnApprouver.setAlpha(0.6f);
        }

        // 8: Bouton approbation yeb3ath el décision true
        btnApprouver.setOnClickListener(v -> ouvrirResultat(true));

        // 9: Bouton refus yeb3ath el décision false
        btnRefuser.setOnClickListener(v -> ouvrirResultat(false));
    }

    // 10: Fonction t7el l'écran troisième (ResultActivity) w teb3ath el décision w esm el voyageur
    private void ouvrirResultat(boolean verdict) {
        Intent intent = new Intent(VerificationActivity.this, ResultActivity.class);
        String m = CleExtra.MATRICULE;
        intent.putExtra(CleExtra.verdict(m), verdict);
        intent.putExtra(CleExtra.nomVoyageur(m), nom);
        startActivity(intent);
    }

    // 11: Fonction tet2aked ken el nombre premier (ya9bel el 9isma ken 3la 1 w 3la rou7ou)
    private boolean estPremier(int n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}