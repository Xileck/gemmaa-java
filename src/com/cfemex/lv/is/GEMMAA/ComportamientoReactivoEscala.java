package com.cfemex.lv.is.GEMMAA;

/**
 * Created by JCDI on 31/10/2016.
 */
public class ComportamientoReactivoEscala {
    int idAtributo;
    int idCRE;
    String comportamiento;
    String reactivo;
    String respuesta;
    float escala_a;
    float escala_b;
    float escala_c;
    float escala_d;
    boolean contestado;
    int promedio;

    public int getPromedio() {
        return promedio;
    }

    public void setPromedio(int promedio) {
        this.promedio = promedio;
    }

    public boolean isContestado() {
        return contestado;
    }

    public void setContestado(boolean contestado) {
        this.contestado = contestado;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public int getIdCRE() {
        return idCRE;
    }

    public void setIdCRE(int idCRE) {
        this.idCRE = idCRE;
    }

    public int getIdAtributo() {
        return idAtributo;
    }

    public void setIdAtributo(int idAtributo) {
        this.idAtributo = idAtributo;
    }

    public String getComportamiento() {
        return comportamiento;
    }

    public void setComportamiento(String comportamiento) {
        this.comportamiento = comportamiento;
    }

    public String getReactivo() {
        return reactivo;
    }

    public void setReactivo(String reactivo) {
        this.reactivo = reactivo;
    }

    public float getEscala_a() {
        return escala_a;
    }

    public void setEscala_a(float escala_a) {
        this.escala_a = escala_a;
    }

    public float getEscala_b() {
        return escala_b;
    }

    public void setEscala_b(float escala_b) {
        this.escala_b = escala_b;
    }

    public float getEscala_c() {
        return escala_c;
    }

    public void setEscala_c(float escala_c) {
        this.escala_c = escala_c;
    }

    public float getEscala_d() {
        return escala_d;
    }

    public void setEscala_d(float escala_d) {
        this.escala_d = escala_d;
    }
}
