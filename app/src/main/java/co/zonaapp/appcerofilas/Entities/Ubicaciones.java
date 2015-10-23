package co.zonaapp.appcerofilas.Entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Ubicaciones {

    @SerializedName("ubiid")
    private int idUbicacion;

    @SerializedName("ubinombre")
    private String nombre;

    public Ubicaciones(int idUbicacion, String nombre) {
        this.idUbicacion = idUbicacion;
        this.nombre = nombre;
    }

    public int getIdUbicacion() {
        return idUbicacion;
    }

    public void setIdUbicacion(int idUbicacion) {
        this.idUbicacion = idUbicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
