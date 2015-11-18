package co.zonaapp.appcerofilas.Entities;


import com.google.gson.annotations.SerializedName;

public class Turno {

    @SerializedName("turid")
    private int turid;

    @SerializedName("ubifechahora")
    private String ubifechahora;

    @SerializedName("ubicacion_ubiid")
    private int ubicacion_ubiid;

    @SerializedName("empleados_idempleados")
    private int empleados_idempleados;

    @SerializedName("imei")
    private String imei;

    @SerializedName("estado")
    private int estado;

    @SerializedName("tipo")
    private String tipo;

    @SerializedName("ubinombre")
    private String ubinombre;

    public int getTurid() {
        return turid;
    }

    public void setTurid(int turid) {
        this.turid = turid;
    }

    public String getUbifechahora() {
        return ubifechahora;
    }

    public void setUbifechahora(String ubifechahora) {
        this.ubifechahora = ubifechahora;
    }

    public int getUbicacion_ubiid() {
        return ubicacion_ubiid;
    }

    public void setUbicacion_ubiid(int ubicacion_ubiid) {
        this.ubicacion_ubiid = ubicacion_ubiid;
    }

    public int getEmpleados_idempleados() {
        return empleados_idempleados;
    }

    public void setEmpleados_idempleados(int empleados_idempleados) {
        this.empleados_idempleados = empleados_idempleados;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUbinombre() {
        return ubinombre;
    }

    public void setUbinombre(String ubinombre) {
        this.ubinombre = ubinombre;
    }

}
