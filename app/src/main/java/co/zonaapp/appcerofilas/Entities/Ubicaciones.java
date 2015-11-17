package co.zonaapp.appcerofilas.Entities;

import com.google.gson.annotations.SerializedName;

public class Ubicaciones {

    @SerializedName("uninombre")
    private String uninombre;

    @SerializedName("sednombre")
    private String sednombre;

    @SerializedName("nombreArea")
    private String nombreArea;

    @SerializedName("ubinombre")
    private String ubinombre;

    @SerializedName("ubiid")
    private String ubiid;

    @SerializedName("latitud")
    private Double latitud;

    @SerializedName("longitud")
    private Double longitud;

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

    public static Ubicaciones ubicaciones;

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

    public String getNombreArea() {
        return nombreArea;
    }

    public void setNombreArea(String nombreArea) {
        this.nombreArea = nombreArea;
    }

    public String getUbinombre() {
        return ubinombre;
    }

    public void setUbinombre(String ubinombre) {
        this.ubinombre = ubinombre;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
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

    public static Ubicaciones getUbicaciones() {
        return ubicaciones;
    }

    public static void setUbicaciones(Ubicaciones ubicaciones) {
        Ubicaciones.ubicaciones = ubicaciones;
    }

    public String getUbiid() {
        return ubiid;
    }

    public void setUbiid(String ubiid) {
        this.ubiid = ubiid;
    }

}
