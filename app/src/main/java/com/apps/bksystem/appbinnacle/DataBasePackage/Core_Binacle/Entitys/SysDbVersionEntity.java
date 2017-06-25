package com.apps.bksystem.appbinnacle.DataBasePackage.Core_Binacle.Entitys;

/**
 * Created by jcarl on 13/03/2017.
 */

public class SysDbVersionEntity {

    private int id;
    private String fecha;
    private String descripcion;
    private int tableOficinas;
    private int tableColaboradores;
    private int tableRutas;
    private int tableActividades;
    private int tableTiposActividades;

    public SysDbVersionEntity(int id, String fecha, String descripcion, int tableOficinas, int tableColaboradores, int tableRutas, int tableActividades, int tableTiposActividades) {
        this.id = id;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.tableOficinas = tableOficinas;
        this.tableColaboradores = tableColaboradores;
        this.tableRutas = tableRutas;
        this.tableActividades = tableActividades;
        this.tableTiposActividades = tableTiposActividades;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getTableOficinas() {
        return tableOficinas;
    }

    public void setTableOficinas(int tableOficinas) {
        this.tableOficinas = tableOficinas;
    }

    public int getTableColaboradores() {
        return tableColaboradores;
    }

    public void setTableColaboradores(int tableColaboradores) {
        this.tableColaboradores = tableColaboradores;
    }

    public int getTableRutas() {
        return tableRutas;
    }

    public void setTableRutas(int tableRutas) {
        this.tableRutas = tableRutas;
    }

    public int getTableActividades() {
        return tableActividades;
    }

    public void setTableActividades(int tableActividades) {
        this.tableActividades = tableActividades;
    }

    public int getTableTiposActividades() {
        return tableTiposActividades;
    }

    public void setTableTiposActividades(int tableTiposActividades) {
        this.tableTiposActividades = tableTiposActividades;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
