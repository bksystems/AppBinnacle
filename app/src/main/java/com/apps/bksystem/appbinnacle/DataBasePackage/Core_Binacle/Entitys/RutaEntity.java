package com.apps.bksystem.appbinnacle.DataBasePackage.Core_Binacle.Entitys;

/**
 * Created by jcarl on 13/03/2017.
 */

public class RutaEntity {

    private int id;
    private int cc;
    private String oficina;
    private int nomina;
    private String colaborador;
    private String ruta;

    public RutaEntity(int id, int cc, String oficina, int nomina, String colaborador, String ruta) {
        this.id = id;
        this.cc = cc;
        this.oficina = oficina;
        this.nomina = nomina;
        this.colaborador = colaborador;
        this.ruta = ruta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCc() {
        return cc;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }

    public String getOficina() {
        return oficina;
    }

    public void setOficina(String oficina) {
        this.oficina = oficina;
    }

    public int getNomina() {
        return nomina;
    }

    public void setNomina(int nomina) {
        this.nomina = nomina;
    }

    public String getColaborador() {
        return colaborador;
    }

    public void setColaborador(String colaborador) {
        this.colaborador = colaborador;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
}
