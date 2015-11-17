package co.zonaapp.appcerofilas.Entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Sedes {

    @SerializedName("sedid")
    private int sedid;

    @SerializedName("sednombre")
    private String sednombre;

    @SerializedName("sedestado")
    private int estado;

    @SerializedName("entidad_uniid")
    private int entidad_uniid;

    @SerializedName("areas")
    private List<Areas> lisAreas;

    public static List<Areas> listAreasStatic;

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

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getEntidad_uniid() {
        return entidad_uniid;
    }

    public void setEntidad_uniid(int entidad_uniid) {
        this.entidad_uniid = entidad_uniid;
    }

    public List<Areas> getLisAreas() { return lisAreas; }

    public void setLisAreas(List<Areas> lisAreas) { this.lisAreas = lisAreas; }

    public static List<Areas> getListAreasStatic() { return listAreasStatic; }

    public static void setListAreasStatic(List<Areas> listAreasStatic) { Sedes.listAreasStatic = listAreasStatic; }

}
