package com.example.fazaii_denisa_calota;

import android.os.Parcel;
import android.os.Parcelable;


public class Linie implements Parcelable, Comparable {
    int numarLinie=0;
    String tipRuta="Nedefinita";
    float tarif=-1f;
    float nivelAglomeratie=0f;
    float rating=-1f;
    float oraAcordareRating=-1f;

    public Linie(int numarLinie, String tipRuta, float nivelAglomeratie, float rating, float oraAcordareRating) {
        this.numarLinie = numarLinie;
        this.tipRuta = tipRuta;

        if(this.tipRuta.equals("Express")){
            this.tarif=7;
        }else if(this.tipRuta.equals("Regionala")){
            this.tarif=1.5f;
        }else{
            this.tarif=1.3f;
        }

        this.nivelAglomeratie = nivelAglomeratie;
        this.rating = rating;
        this.oraAcordareRating = oraAcordareRating;
    }

    protected Linie(Parcel in) {
        numarLinie = in.readInt();
        tipRuta = in.readString();
        tarif = in.readFloat();
        nivelAglomeratie = in.readFloat();
        rating = in.readFloat();
        oraAcordareRating = in.readFloat();
    }

    public static final Creator<Linie> CREATOR = new Creator<Linie>() {
        @Override
        public Linie createFromParcel(Parcel in) {
            return new Linie(in);
        }

        @Override
        public Linie[] newArray(int size) {
            return new Linie[size];
        }
    };

    public int getNumarLinie() {
        return numarLinie;
    }

    public String getTipRuta() {
        return tipRuta;
    }

    public float getTarif() {
        return tarif;
    }

    public float getNivelAglomeratie() {
        return nivelAglomeratie;
    }

    public float getRating() {
        return rating;
    }

    public float getOraAcordareRating() {
        return oraAcordareRating;
    }

    public void setNumarLinie(int numarLinie) {
        this.numarLinie = numarLinie;
    }

    public void setTipRuta(String tipRuta) {
        this.tipRuta = tipRuta;
    }

    public void setTarif(float tarif) {
        this.tarif = tarif;
    }

    public void setNivelAglomeratie(float nivelAglomeratie) {
        this.nivelAglomeratie = nivelAglomeratie;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setOraAcordareRating(float oraAcordareRating) {
        this.oraAcordareRating = oraAcordareRating;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.numarLinie);
        dest.writeString(this.tipRuta);
        dest.writeFloat(this.tarif);
        dest.writeFloat(this.nivelAglomeratie);
        dest.writeFloat(this.oraAcordareRating);
        dest.writeFloat(this.rating);
    }

    @Override
    public int compareTo(Object o) {
        Linie comparCu = (Linie)o;
        if(this.getRating()>comparCu.getRating())
            return -1;
        else if (this.getRating()<comparCu.getRating()){
            return 1;
        } else return 0;
    }
}
