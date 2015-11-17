package co.zonaapp.appcerofilas.Entities;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Areas {

    @SerializedName("idarea")
    private int idarea;

    @SerializedName("nombre")
    private String nombre;

    @SerializedName("estado")
    private int estado;

    @SerializedName("sede_sedid")
    private int sede_sedid;

    @SerializedName("ubicaciones")
    private List<Ubicaciones> listUbicaciones;

    public static List<Ubicaciones> listUbicacionStatic;

    public int getIdarea() {
        return idarea;
    }

    public void setIdarea(int idarea) {
        this.idarea = idarea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getSede_sedid() {
        return sede_sedid;
    }

    public void setSede_sedid(int sede_sedid) {
        this.sede_sedid = sede_sedid;
    }

    public List<Ubicaciones> getListUbicaciones() { return listUbicaciones; }

    public void setListUbicaciones(List<Ubicaciones> listUbicaciones) { this.listUbicaciones = listUbicaciones; }

    public static List<Ubicaciones> getListUbicacionStatic() {
        return listUbicacionStatic;
    }

    public static void setListUbicacionStatic(List<Ubicaciones> listUbicacionStatic) {
        Areas.listUbicacionStatic = listUbicacionStatic;
    }

}
