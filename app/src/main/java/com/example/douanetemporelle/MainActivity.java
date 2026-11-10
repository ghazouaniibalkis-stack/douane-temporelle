package com.example.douanetemporelle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
//intent bech torbet lpage loula bil page thenya w budnle ihoot l'état mtaa l'écran

public class MainActivity extends AppCompatActivity {


    EditText etNom, etNaissance, etDestination;
    RadioGroup rgMotif;
    Button btnInspecter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //manghir set content view tji l'écran bidhaaa

        etNom = findViewById(R.id.et_nom_gb);
        etNaissance = findViewById(R.id.et_naissance_gb);
        etDestination = findViewById(R.id.et_destination_gb);
        rgMotif = findViewById(R.id.rg_motif_gb);
        btnInspecter = findViewById(R.id.btn_inspecter_gb);

        btnInspecter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // get texte hiya jib chkteb w get string badlo lstring
                String nom = etNom.getText().toString();
                String naissanceTxt = etNaissance.getText().toString();
                String destinationTxt = etDestination.getText().toString();

                if (nom.isEmpty() || naissanceTxt.isEmpty() || destinationTxt.isEmpty()) {
                    Toast.makeText(MainActivity.this,
                            "Veuillez remplir tous les champs",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                int naissance = Integer.parseInt(naissanceTxt);
                int destination = Integer.parseInt(destinationTxt);

                String motif;
                int idChoisi = rgMotif.getCheckedRadioButtonId();
                if (idChoisi == R.id.rb_tourisme_gb) {
                    motif = "Tourisme";
                } else if (idChoisi == R.id.rb_modification_gb) {
                    motif = "Modification du passé";
                } else {
                    motif = "Fuite";
                }

                // bech temchi mil interface loula li thenya
                Intent intent = new Intent(MainActivity.this, VerificationActivity.class);

                String m = CleExtra.MATRICULE;
                intent.putExtra(CleExtra.nomVoyageur(m), nom);
                intent.putExtra(CleExtra.anneeNaissance(m), naissance);
                intent.putExtra(CleExtra.anneeDestination(m), destination);
                intent.putExtra(CleExtra.motif(m), motif);


                startActivity(intent);
            }
        });
    }
}