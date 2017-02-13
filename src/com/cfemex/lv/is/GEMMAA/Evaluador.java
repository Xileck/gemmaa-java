package com.cfemex.lv.is.GEMMAA;

import com.cfemex.lv.Empleado;

/**
 * Created by cfe on 29/11/2016.
 */
public class Evaluador {

    int id_evaluador;
    int id_evaluacion;
    int nip_evaluador;
    String tipo_de_evaluador;
    String fecha;
    String finalizo;
    Empleado empleado;
    Encuesta encuesta;
    String nombre_completo;
    String rpe;

    public String getRpe() {
        return rpe;
    }

    public void setRpe(String rpe) {
        this.rpe = rpe;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }


    public Encuesta getEncuesta() {
        return encuesta;
    }

    public void setEncuesta(Encuesta encuesta) {
        this.encuesta = encuesta;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public int getId_evaluador() {
        return id_evaluador;
    }

    public void setId_evaluador(int id_evaluador) {
        this.id_evaluador = id_evaluador;
    }

    public int getId_evaluacion() {
        return id_evaluacion;
    }

    public void setId_evaluacion(int id_evaluacion) {
        this.id_evaluacion = id_evaluacion;
    }

    public int getNip_evaluador() {
        return nip_evaluador;
    }

    public void setNip_evaluador(int nip_evaluador) {
        this.nip_evaluador = nip_evaluador;
    }

    public String getTipo_de_evaluador() {
        return tipo_de_evaluador;
    }

    public void setTipo_de_evaluador(String tipo_de_evaluador) {
        this.tipo_de_evaluador = tipo_de_evaluador;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFinalizo() {
        return finalizo;
    }

    public void setFinalizo(String finalizo) {
        this.finalizo = finalizo;
    }
}