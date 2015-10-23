package co.zonaapp.appcerofilas.Entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by IngenieroGerman on 18/10/2015.
 */
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

    @SerializedName("ubicacion")
    private List<Ubicaciones> listUbicaciones;

    static List<Entidades> staticEntidades;

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

    public List<Ubicaciones> getListUbicaciones() {
        return listUbicaciones;
    }

    public void setListUbicaciones(List<Ubicaciones> listUbicaciones) {
        this.listUbicaciones = listUbicaciones;
    }

    public static List<Entidades> getStaticEntidades() {
        return staticEntidades;
    }

    public static void setStaticEntidades(List<Entidades> staticEntidades) {
        Entidades.staticEntidades = staticEntidades;
    }

}
