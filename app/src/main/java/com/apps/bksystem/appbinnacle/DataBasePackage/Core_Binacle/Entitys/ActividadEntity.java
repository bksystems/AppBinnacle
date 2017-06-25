package com.apps.bksystem.appbinnacle.DataBasePackage.Core_Binacle.Entitys;

/**
 * Created by jcarl on 20/03/2017.
 */

public class ActividadEntity {

    private int id;
    private String actividad;
    private String descripcion;
    private int sys_actividad_tipo_id;

    public ActividadEntity(int id, String actividad, String descripcion, int sys_actividad_tipo_id) {
        this.id = id;
        this.actividad = actividad;
        this.descripcion = descripcion;
        this.sys_actividad_tipo_id = sys_actividad_tipo_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getSys_actividad_tipo_id() {
        return sys_actividad_tipo_id;
    }

    public void setSys_actividad_tipo_id(int sys_actividad_tipo_id) {
        this.sys_actividad_tipo_id = sys_actividad_tipo_id;
    }
}
