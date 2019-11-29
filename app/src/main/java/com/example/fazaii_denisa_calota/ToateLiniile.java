package com.example.fazaii_denisa_calota;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ToateLiniile extends AppCompatActivity {

    ArrayList<Linie> listaToateLiniile;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toateliniile);

        listaToateLiniile = new ArrayList<>();

        GetJSON json = new GetJSON(){
            @Override
            protected void onPostExecute(ArrayList<Linie> linies) {
                listaToateLiniile = linies;
                Toast.makeText(getApplicationContext(), linies.size()+"",Toast.LENGTH_LONG).show();
            }
        };
        json.execute( "https://api.myjson.com/bins/n96re");

        //populez temporar Listview
//        Linie linie1 = new Linie(137, "Autobuz",50,3.2f,16);
//        Linie linie2 = new Linie(41, "Tramvai",88,2.2f, 8);
//        Linie linie3 = new Linie(750, "Express",20, 5,12);
//        Linie linie4 = new Linie(432, "Regionala",44,4.8f,6);
//        listaToateLiniile.add(linie1);
//        listaToateLiniile.add(linie2);
//        listaToateLiniile.add(linie3);
//        listaToateLiniile.add(linie4);

        LinieAdapter adapter = new LinieAdapter(this,R.layout.layout_array_adapter, listaToateLiniile);
        final ListView listViewToateLiniile = (ListView) findViewById(R.id.listViewToateLiniile);
        listViewToateLiniile.setAdapter(adapter);



        listViewToateLiniile.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Linie linie= listaToateLiniile.get(position);

                Intent intent = new Intent(getApplicationContext(), detalii.class);
                intent.putExtra("dinToateLiniile",linie);
                startActivityForResult(intent,1);
            }
        });
    }



}
