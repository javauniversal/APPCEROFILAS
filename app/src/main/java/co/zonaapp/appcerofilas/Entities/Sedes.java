package co.zonaapp.appcerofilas.Entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Sedes {

    @SerializedName("sedid")
    private int sedid;

    @SerializedName("sednombre")
    private String sednombre;

    @SerializedName("ubicaciones")
    private List<Ubicaciones> listUbicaciones;

    public int getSedid() {
        return sedid;
    }

    public void setSedid(int sedid) {
        this.sedid = sedid;
    }

    public String getSednombre() {
        return sednombre;
    }

    public void setSednombre(String sednombre) {
        this.sednombre = sednombre;
    }

    public List<Ubicaciones> getListUbicaciones() {
        return listUbicaciones;
    }

    public void setListUbicaciones(List<Ubicaciones> listUbicaciones) {
        this.listUbicaciones = listUbicaciones;
    }
}
