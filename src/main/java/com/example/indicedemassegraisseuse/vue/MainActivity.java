package com.example.indicedemassegraisseuse.vue;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.indicedemassegraisseuse.R;
import com.example.indicedemassegraisseuse.controleur.Controle;

public class MainActivity<message> extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        this.controle = Controle.getInstance();
    }

    /**
     * Proprités
     */
    private EditText txtPoids;
    private EditText txtTaille;
    private EditText txtAge;
    private RadioButton rdHomme;
    private TextView lblIMG;
    private ImageView imgSmiley;
    private Button btnCalc;
    private Controle controle;



    // Propriétes
    private void init() {
        txtPoids = (EditText) findViewById(R.id.txtPoids);
        txtTaille = (EditText) findViewById(R.id.txtTaille);
        txtAge = (EditText) findViewById(R.id.txtAge);
        rdHomme = (RadioButton) findViewById(R.id.rdHomme);
        btnCalc = (Button) findViewById(R.id.btnCalc);
        lblIMG = (TextView) findViewById(R.id.lblIMG);
        imgSmiley = (ImageView) findViewById(R.id.imgSmiley);
        ecouteCalcul();
    }

    /**
     * Method Ecoute CAlcul
     */
    private void ecouteCalcul() {
        ((Button) findViewById(R.id.btnCalc)).setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {

                //Toast.makeText(MainActivity.this, "Test", Toast.LENGTH_SHORT).show();
                // Log.d("message", "LICK OK SUR LECOUTE" ); // Affichage dans le Logcat;

                Integer poids = 0;
                Integer taille = 0;
                Integer age = 0;
                Integer sexe = 0;

                // Recupération des données saisies
                try {
                    poids = Integer.parseInt(txtPoids.getText().toString());
                    taille = Integer.parseInt(txtTaille.getText().toString());
                    age = Integer.parseInt(txtAge.getText().toString());
                } catch (Exception e) {}

                if (rdHomme.isChecked()) {
                    sexe = 1;
                }

                // Controle de Saisie
                if (poids == 0 || taille == 0 || age == 0) {
                    Toast.makeText(MainActivity.this, "Sasie Incorrecte !", Toast.LENGTH_SHORT).show();
                } else {
                    afficheResult(poids,taille,age,sexe);
                }

            }

        });

    }

    /**
     * Affichage de IMG / Message / Image
     *
     * @param poids
     * @param taille
     * @param age
     * @param sexe
     */
    public void afficheResult(Integer poids, Integer taille, Integer age, Integer sexe){

        this.controle.creerProfil(poids, taille, age, sexe);
        float img = this.controle.getImg();
        String message = this.controle.getMessage();

        // Affichage;
        if (message == "normal") {
            imgSmiley.setImageResource(R.drawable.minnce2);
            lblIMG.setTextColor(android.R.color.holo_green_light);
        } else {

            lblIMG.setTextColor(android.R.color.holo_red_light);
            if (message == "trop maigre") {
                imgSmiley.setImageResource(R.drawable.maigre2);
            } else {
                imgSmiley.setImageResource(R.drawable.gros2);
            }
        }
        lblIMG.setText(String.format(img + " IMG " + message));
    }
}

