package com.cfemex.lv.is.GEMMAA;

/**
 * Created by cfe on 06/12/2016.
 */
public class EvaluacionPendiente {
    int id_evaluacion;
    int id_evaluador;
    int idte;
    String nombre_encuesta;
    String tipo_de_evaluador;
    int nip_evaluador;
    int nip_de_evaluado;
    String finalizo;

    public String getFinalizo() {
        return finalizo;
    }

    public void setFinalizo(String finalizo) {
        this.finalizo = finalizo;
    }

    public int getId_evaluador() {
        return id_evaluador;
    }

    public void setId_evaluador(int id_evaluador) {
        this.id_evaluador = id_evaluador;
    }

    public String getTipo_de_evaluador() {
        return tipo_de_evaluador;
    }

    public void setTipo_de_evaluador(String tipo_de_evaluador) {
        this.tipo_de_evaluador = tipo_de_evaluador;
    }

    public String getNombre_encuesta() {
        return nombre_encuesta;
    }

    public void setNombre_encuesta(String nombre_encuesta) {
        this.nombre_encuesta = nombre_encuesta;
    }

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

    public int getNip_evaluador() {
        return nip_evaluador;
    }

    public void setNip_evaluador(int nip_evaluador) {
        this.nip_evaluador = nip_evaluador;
    }

    public int getNip_de_evaluado() {
        return nip_de_evaluado;
    }

    public void setNip_de_evaluado(int nip_de_evaluado) {
        this.nip_de_evaluado = nip_de_evaluado;
    }
}
