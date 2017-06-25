package com.apps.bksystem.appbinnacle.DataBasePackage.Core_Binacle.Entitys;

/**
 * Created by jcarl on 20/03/2017.
 */

public class TipoActividadEntity {
    private int id;
    private String tipo;
    private String descripcion;
    private int status;

    public TipoActividadEntity(int id, String tipo, String descripcion, int status) {
        this.id = id;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
