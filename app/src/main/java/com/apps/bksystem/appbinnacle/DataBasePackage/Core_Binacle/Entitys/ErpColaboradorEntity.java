package com.apps.bksystem.appbinnacle.DataBasePackage.Core_Binacle.Entitys;

/**
 * Created by jcarl on 13/03/2017.
 */

public class ErpColaboradorEntity {

    private int id;
    private int cc;
    private int nomina;
    private String colaborador;
    private String puesto;

    public ErpColaboradorEntity(int id, int cc, int nomina, String colaborador, String puesto) {
        this.id = id;
        this.cc = cc;
        this.nomina = nomina;
        this.colaborador = colaborador;
        this.puesto = puesto;
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

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
}
