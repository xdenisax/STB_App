package com.example.fazaii_denisa_calota;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Top extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);

        ArrayList<Linie> listaToateLiniile = new ArrayList<>();
        //populez temporar Listview
        Linie linie1 = new Linie(137, "Autobuz",50,3.2f,16);
        Linie linie2 = new Linie(41, "Tramvai",88,2.2f, 8);
        Linie linie3 = new Linie(750, "Express",20, 5,12);
        Linie linie4 = new Linie(432, "Regionala",44,4.8f,6);
        listaToateLiniile.add(linie1);
        listaToateLiniile.add(linie2);
        listaToateLiniile.add(linie3);
        listaToateLiniile.add(linie4);

        Collections.sort(listaToateLiniile);

        TopAdapter adapter =  new TopAdapter(getApplicationContext(), R.layout.layout_array_adapter,listaToateLiniile);
        ListView listView = (ListView) findViewById(R.id.listViewTop);
        listView.setAdapter(adapter);
    }
}
