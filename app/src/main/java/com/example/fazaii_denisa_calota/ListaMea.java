package com.example.fazaii_denisa_calota;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ListaMea extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_mea);

        ArrayList<Linie> favorite;
        detalii det = new detalii();
        favorite= det.getFavorite();

        LiniileMeleAdapter adapter = new LiniileMeleAdapter(this, R.layout.layout_liniilemele_adapter, favorite);
        ListView listView = (ListView) findViewById(R.id.listviewListaMea);
        listView.setAdapter(adapter);

//        Button buttonAdaugaDetalii = (Button) findViewById(R.id.ButtonAdaugaDetalii);
//        buttonAdaugaDetalii.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), Modifica.class);
////                intent.putExtra("dinAdapter", onContextItemSelected() );
//            }
//        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
}
