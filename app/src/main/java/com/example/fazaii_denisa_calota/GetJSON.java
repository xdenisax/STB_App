package com.example.fazaii_denisa_calota;

import android.os.AsyncTask;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class GetJSON extends AsyncTask<String, Void, ArrayList<Linie>> {
    @Override
    protected ArrayList<Linie> doInBackground(String... strings) {
        ArrayList<Linie> linii = new ArrayList<>();

        try {
            URL url = new URL(strings[0]);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            InputStream inputStream = http.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String line= null;
            StringBuilder builder = new StringBuilder();

            while((line=bufferedReader.readLine())!=null){
                builder.append(line);
            }

            String json = builder.toString();
            JSONObject object = new JSONObject(json);
            JSONArray array = object.getJSONArray("linii");
            int i=0;
            while(array.getJSONObject(i)!=null){
                JSONObject linieCitita=  array.getJSONObject(i);
                int nr = linieCitita.getInt("numar");
                String tip = linieCitita.getString("tip");
                Linie linie = new Linie(nr, tip, 0,0,0);
                linii.add(linie);
                i++;
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return linii;
    }
}
