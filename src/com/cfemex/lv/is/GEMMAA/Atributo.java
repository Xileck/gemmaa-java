package com.cfemex.lv.is.GEMMAA;
/**
 * Created by JCDI on 31/10/2016.
 */
public class Atributo {
    int idAtributo;
    int idResultadoEsperado;
    String nombre;
    String descripcion;
    float promedio;

    public float getPromedio() {
        return promedio;
    }

    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }

    public int getIdAtributo() {
        return idAtributo;
    }

    public void setIdAtributo(int idAtributo) {
        this.idAtributo = idAtributo;
    }

    public int getIdResultadoEsperado() {
        return idResultadoEsperado;
    }

    public void setIdResultadoEsperado(int idResultadoEsperado) {
        this.idResultadoEsperado = idResultadoEsperado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}

