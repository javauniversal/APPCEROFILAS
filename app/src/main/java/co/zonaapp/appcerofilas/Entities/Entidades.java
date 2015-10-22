package co.zonaapp.appcerofilas.Entities;

/**
 * Created by IngenieroGerman on 18/10/2015.
 */
public class Entidades {

    private int idEntidad;
    private String nombre;
    private String direccion;
    private Double latitud;
    private Double longitud;

    public Entidades(int idEntidad, String nombre, String direccion, Double latitud, Double longitud) {
        this.idEntidad = idEntidad;
        this.nombre = nombre;
        this.direccion = direccion;
        this.latitud = latitud;
        this.longitud = longitud;
    }

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
}
