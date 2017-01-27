package com.cfemex.lv.is.GEMMAA;

/**
 * Created by JCDI on 31/10/2016.
 */
public class Resultado_Esperado {
    int idResultadoEsperado;
    String descripcion;
    float promedio;

    public int getIdResultadoEsperado() {
        return idResultadoEsperado;
    }

    public float getPromedio() {
        return promedio;
    }

    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }

    public void setIdResultadoEsperado(int idResultadoEsperado) {
        this.idResultadoEsperado = idResultadoEsperado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}