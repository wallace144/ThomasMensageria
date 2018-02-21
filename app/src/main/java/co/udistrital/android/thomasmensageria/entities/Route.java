package co.udistrital.android.thomasmensageria.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by wisuarez on 19/02/2018.
 */




public class Route {

    @JsonIgnore
    int id;

    @JsonIgnore
    int idmensajero;
    int idproducto;
    String fecha_envio;
    String direccion;
    String barrio;
    String estado;
    String observacion;
    String telefono;

    public Route(){
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdmensajero() {
        return idmensajero;
    }

    public void setIdmensajero(int idmensajero) {
        this.idmensajero = idmensajero;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public String getFecha_envio() {
        return fecha_envio;
    }

    public void setFecha_envio(String fecha_envio) {
        this.fecha_envio = fecha_envio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
