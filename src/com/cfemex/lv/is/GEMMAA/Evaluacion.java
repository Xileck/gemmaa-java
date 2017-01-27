package com.cfemex.lv.is.GEMMAA;

/**
 * Created by cfe on 30/11/2016.
 */
public class Evaluacion {

    int id_evaluacion;
    int idte;
    int idp;
    int nip_de_evaluado;
    String fecha;
    String finalizada;

    public int getId_evaluacion() {
        return id_evaluacion;
    }

    public void setId_evaluacion(int id_evaluacion) {
        this.id_evaluacion = id_evaluacion;
    }

    public int getIdte() {
        return idte;
    }

    public void setIdte(int idte) {
        this.idte = idte;
    }

    public int getIdp() {
        return idp;
    }

    public void setIdp(int idp) {
        this.idp = idp;
    }

    public int getNip_de_evaluado() {
        return nip_de_evaluado;
    }

    public void setNip_de_evaluado(int nip_de_evaluado) {
        this.nip_de_evaluado = nip_de_evaluado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFinalizada() {
        return finalizada;
    }

    public void setFinalizada(String finalizada) {
        this.finalizada = finalizada;
    }
}
