package com.example.fazaii_denisa_calota;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonVeziToateLiniile = (Button) findViewById(R.id.buttonVeziiToateLiniile);

        buttonVeziToateLiniile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(getApplicationContext(), ToateLiniile.class);
                startActivity(intent );
            }
        });

        Button liniileMele = (Button) findViewById(R.id.buttonLiniileMele);
        liniileMele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ListaMea.class);
                startActivity(intent);
            }
        });

        Button top = (Button)findViewById(R.id.buttonTop);
        top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=  new Intent(getApplicationContext(), Top.class);
                startActivity(intent);
            }
        });
    }
}
