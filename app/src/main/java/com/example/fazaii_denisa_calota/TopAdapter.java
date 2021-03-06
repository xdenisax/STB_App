package com.example.fazaii_denisa_calota;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class TopAdapter extends ArrayAdapter<Linie> {
    int resourceID;
    public TopAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Linie> objects) {
        super(context, resource, objects);
        resourceID=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Linie linie = getItem(position);
        LayoutInflater inflater= LayoutInflater.from(getContext());
        View view= inflater.inflate(resourceID, null);

        TextView textViewNrLinie = (TextView) view.findViewById(R.id.numarLinie);
        TextView textViewRating = (TextView) view.findViewById(R.id.tipRuta);

        textViewNrLinie.setText(linie.getNumarLinie()+"");
        textViewRating.setText(linie.getRating()+"/5");

        return view;
    }
}
