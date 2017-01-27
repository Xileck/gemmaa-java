package com.cfemex.lv.is.GEMMAA;

import com.cfemex.lv.Empleado;

import java.util.*;

/**
 * Created by cfe on 05/01/2017.
 */
public class GrupoEvaluacion {
    List<Evaluador> evaluadores;
    int idte;
    int nip_de_evaluado;
    String descripcionEncuesta;
    int id_evaluacion;
    String fecha;
    String finalizada;
    Empleado evaluado;
    Ponderados ponderados;
    Promedios promedios;

    public Promedios getPromedios() {
        return promedios;
    }

    public void setPromedios(Promedios promedios) {
        this.promedios = promedios;
    }

    public Ponderados getPonderados() {
        return ponderados;
    }

    public void setPonderados(Ponderados ponderados) {
        this.ponderados = ponderados;
    }

    public Empleado getEvaluado() {
        return evaluado;
    }

    public void setEvaluado(Empleado evaluado) {
        this.evaluado = evaluado;
    }

    public int getNip_de_evaluado() {
        return nip_de_evaluado;
    }

    public void setNip_de_evaluado(int nip_de_evaluado) {
        this.nip_de_evaluado = nip_de_evaluado;
    }

    public List<Evaluador> getEvaluadores() {
        return evaluadores;
    }

    public void setEvaluadores(List<Evaluador> evaluadores) {
        this.evaluadores = evaluadores;
    }

    public int getIdte() {
        return idte;
    }

    public void setIdte(int idte) {
        this.idte = idte;
    }

    public String getDescripcionEncuesta() {
        return descripcionEncuesta;
    }

    public void setDescripcionEncuesta(String descripcionEncuesta) {
        this.descripcionEncuesta = descripcionEncuesta;
    }

    public int getId_evaluacion() {
        return id_evaluacion;
    }

    public void setId_evaluacion(int id_evaluacion) {
        this.id_evaluacion = id_evaluacion;
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
