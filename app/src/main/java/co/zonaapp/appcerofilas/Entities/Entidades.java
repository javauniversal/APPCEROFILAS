package co.zonaapp.appcerofilas.Entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Entidades {

    @SerializedName("uniid")
    private int idEntidad;

    @SerializedName("uninombre")
    private String nombre;

    @SerializedName("unidireccion")
    private String direccion;

    @SerializedName("unilatitud")
    private Double latitud;

    @SerializedName("unilongitud")
    private Double longitud;

    @SerializedName("uniestado")
    private int uniestado;

    @SerializedName("sedes")
    private List<Sedes> listSedes;

    public static Entidades entidadSelect;

    public int getIdEntidad() {
        return idEntidad;
    }

    public void setIdEntidad(int idEntidad) {
        this.idEntidad = idEntidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    public int getUniestado() {
        return uniestado;
    }

    public void setUniestado(int uniestado) {
        this.uniestado = uniestado;
    }

    public List<Sedes> getListSedes() { return listSedes; }

    public void setListSedes(List<Sedes> listSedes) { this.listSedes = listSedes; }

    public static Entidades getEntidadSelect() { return entidadSelect; }

    public static void setEntidadSelect(Entidades entidadSelect) { Entidades.entidadSelect = entidadSelect; }

}
