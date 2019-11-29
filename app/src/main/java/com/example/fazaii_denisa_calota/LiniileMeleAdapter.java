package com.example.fazaii_denisa_calota;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class LiniileMeleAdapter extends ArrayAdapter<Linie> {
    private int resourceId;

    public LiniileMeleAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Linie> objects) {
        super(context, resource, objects);
        this.resourceId=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final Linie linie = getItem(position);
        LayoutInflater inflater = LayoutInflater.from(getContext());
        final View view= inflater.inflate(resourceId,null);

        TextView textViewNrLinie = (TextView) view.findViewById(R.id.NrLinie);
        Button buttonAdaugaDetalii = (Button) view.findViewById(R.id.ButtonAdaugaDetalii);
        Button buttonVeziDetalii = (Button) view.findViewById(R.id.ButtonVeziDetalii);

        buttonAdaugaDetalii.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Modifica.class);
                intent.putExtra("dinLiniileMele", linie);
                getContext().startActivity(intent);
            }
        });

        buttonVeziDetalii.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), detalii.class);
                intent.putExtra("dinLiniileMele", linie);
                getContext().startActivity(intent);
            }
        });

        textViewNrLinie.setText(linie.getNumarLinie()+"");
        return view;
    }
}
