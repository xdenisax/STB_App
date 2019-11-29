package com.example.fazaii_denisa_calota;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;

public class Modifica extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifica);

        Intent intent = getIntent();
        final Linie linieDeModificat= intent.getParcelableExtra("dinLiniileMele");

        Button salveaza= (Button) findViewById(R.id.buttonSalveaza);
        TextView nrLinie  = (TextView) findViewById(R.id.textViewNrLinie);
        final SeekBar nivelAglomeratie  = (SeekBar) findViewById(R.id.seekBar);
        final RatingBar rating = (RatingBar) findViewById(R.id.ratingBar);
        final Switch now = (Switch) findViewById(R.id.switchIntroduseAcum);
        final TimePicker timePicker= (TimePicker) findViewById(R.id.timePicker);
        timePicker.setVisibility(View.INVISIBLE);

        now.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(now.isChecked()){
                    timePicker.setVisibility(View.INVISIBLE);
                }
                if(!now.isChecked()){
                    timePicker.setVisibility(View.VISIBLE);
                }
            }
        });

        salveaza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linieDeModificat.setNivelAglomeratie(nivelAglomeratie.getProgress());
                linieDeModificat.setRating(rating.getRating());
                linieDeModificat.setOraAcordareRating(timePicker.getHour());
                Intent intent = new Intent(getApplicationContext(),ListaMea.class);
                startActivity(intent);
            }
        });

    }
}
