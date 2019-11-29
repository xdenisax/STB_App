package com.example.fazaii_denisa_calota;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class detalii extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalii);

        Button adauga= (Button) findViewById(R.id.buttonAdauga);
        Button elimina = (Button) findViewById(R.id.buttonElimina);
        TextView nrLinie= (TextView) findViewById(R.id.textViewNrLinie);
        TextView tipLinie= (TextView) findViewById(R.id.textViewTipRuta);
        TextView tarif = (TextView) findViewById(R.id.textViewTarif);
        TextView nivelAglomeratie= (TextView) findViewById(R.id.textViewNivelAglomeratie);
        TextView rating= (TextView) findViewById(R.id.textViewRating);
        TextView oraVarf= (TextView) findViewById(R.id.textViewOraVarf);

        Intent intent = getIntent();
        Bundle bundle = getIntent().getExtras();
        final Linie liniePrimita=intent.getParcelableExtra("dinToateLiniile");
        Linie liniePrimita2=intent.getParcelableExtra("dinLiniileMele");

        if(bundle.containsKey("dinToateLiniile")){
            nrLinie.setText(liniePrimita.getNumarLinie()+"");
            tipLinie.setText("Categorie: "+liniePrimita.getTipRuta());
            tarif.setText("Tarif: "+liniePrimita.getTarif()+" lei");
            adauga.setVisibility(View.VISIBLE);
            elimina.setVisibility(View.INVISIBLE);
        }

        adauga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),liniePrimita.getNumarLinie()+" a fost adaugata cu succes in Liniile Mele.", Toast.LENGTH_LONG).show();
            }
        });

        if(bundle.containsKey("dinLiniileMele")){
            nrLinie.setText(liniePrimita2.getNumarLinie()+"");
            tipLinie.setText("Categorie: "+liniePrimita2.getTipRuta());
            tarif.setText("Tarif: "+liniePrimita2.getTarif()+" lei");
            adauga.setVisibility(View.INVISIBLE);
            elimina.setVisibility(View.VISIBLE);
            nivelAglomeratie.setText("Nivel mediu de aglomeratie: "+liniePrimita2.getNivelAglomeratie()+"%");
            rating.setText("Rating: "+ liniePrimita2.getRating() + "/5");
            oraVarf.setText("De cele mai multe ori, aceasta linie este aglomerata la ora "+liniePrimita2.getOraAcordareRating());

        }
    }

    ArrayList<Linie> favorite = new ArrayList<Linie>();
    public detalii() {
        favorite.add(new Linie(137, "Autobuz",50,3.2f,16));
    }
    public ArrayList<Linie> getFavorite() {
        return favorite;
    }
    public void setFavorite(ArrayList<Linie> favorite) {
        this.favorite = favorite;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = getIntent();
        Bundle bundle = getIntent().getExtras();
        if(bundle.containsKey("dinLiniileMele")){
            Intent intent2 = new Intent(getApplicationContext(), ListaMea.class);
            startActivity(intent2);
        }
    }
}
