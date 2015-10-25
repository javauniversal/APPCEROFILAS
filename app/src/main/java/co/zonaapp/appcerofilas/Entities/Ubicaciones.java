package co.zonaapp.appcerofilas.Entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Ubicaciones {

    @SerializedName("uninombre")
    private String uninombre;

    @SerializedName("sednombre")
    private String sednombre;

    @SerializedName("ubiid")
    private int ubiid;

    @SerializedName("ubinombre")
    private String ubinombre;

    @SerializedName("horhorai")
    private String horhorai;

    @SerializedName("horhoraf")
    private String horhoraf;

    @SerializedName("hordiai")
    private String hordiai;

    @SerializedName("hordiaf")
    private String hordiaf;

    @SerializedName("protiempo")
    private int protiempo;

    @SerializedName("proformato")
    private String proformato;

    @SerializedName("turno")
    private int turno;

    public String getUninombre() {
        return uninombre;
    }

    public void setUninombre(String uninombre) {
        this.uninombre = uninombre;
    }

    public String getSednombre() {
        return sednombre;
    }

    public void setSednombre(String sednombre) {
        this.sednombre = sednombre;
    }

    public int getUbiid() {
        return ubiid;
    }

    public void setUbiid(int ubiid) {
        this.ubiid = ubiid;
    }

    public String getUbinombre() {
        return ubinombre;
    }

    public void setUbinombre(String ubinombre) {
        this.ubinombre = ubinombre;
    }

    public String getHorhorai() {
        return horhorai;
    }

    public void setHorhorai(String horhorai) {
        this.horhorai = horhorai;
    }

    public String getHorhoraf() {
        return horhoraf;
    }

    public void setHorhoraf(String horhoraf) {
        this.horhoraf = horhoraf;
    }

    public String getHordiai() {
        return hordiai;
    }

    public void setHordiai(String hordiai) {
        this.hordiai = hordiai;
    }

    public String getHordiaf() {
        return hordiaf;
    }

    public void setHordiaf(String hordiaf) {
        this.hordiaf = hordiaf;
    }

    public int getProtiempo() {
        return protiempo;
    }

    public void setProtiempo(int protiempo) {
        this.protiempo = protiempo;
    }

    public String getProformato() {
        return proformato;
    }

    public void setProformato(String proformato) {
        this.proformato = proformato;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

}
