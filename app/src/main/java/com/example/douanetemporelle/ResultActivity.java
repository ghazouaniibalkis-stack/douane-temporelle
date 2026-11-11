package com.example.douanetemporelle;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    // Déclarer les éléments de l'interface (tvIcone bech najem nista3mel el emoji ✈️ , 🚨)
    LinearLayout layoutMain;
    TextView tvMessage, tvIcone;
    Button btnNouveau;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // norbtou el Java bel XML
        // findViewById() t3awen bech nrecuperiw les éléments XML grâce à leurs identifiants (id)
        layoutMain = findViewById(R.id.main);
        tvMessage = findViewById(R.id.tv_message_gb);
        tvIcone = findViewById(R.id.tv_icone_gb);
        btnNouveau = findViewById(R.id.btn_nouveau_gb);

        // Houni nesta9blou les informations eli mab3outhin men l'interface thenya
        // esm lbutton verdict : True = approuvé, False = refusé
        Intent intent = getIntent();
        String m = CleExtra.MATRICULE;
        String nom = intent.getStringExtra(CleExtra.nomVoyageur(m));
        boolean verdict = intent.getBooleanExtra(CleExtra.verdict(m), false);

        // Ken s7i7, iraja3li el background 5adhra
        if (verdict) {
            layoutMain.setBackgroundColor(Color.parseColor("#2E7D32"));
            tvMessage.setText("Bon voyage " + nom);
            tvIcone.setText("✈️");
        }
        // Sinon 7amra
        else {
            layoutMain.setBackgroundColor(Color.parseColor("#C62828"));
            tvMessage.setText(nom + " est en état d'arrestation temporelle");
            tvIcone.setText("🚨");
        }

        // Bouton yarja3 lel interface loula w ysakker les interfaces el 9dom
        btnNouveau.setOnClickListener(v -> {
            Intent retour = new Intent(ResultActivity.this, MainActivity.class);
            retour.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(retour);
        });
    }
}