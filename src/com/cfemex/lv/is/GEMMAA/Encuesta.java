package com.cfemex.lv.is.GEMMAA;

import java.util.List;

/**
 * Created by JCDI on 31/10/2016.
 */
public class Encuesta {

    int idEncuesta;
    String nombre;
    List<Resultado_Esperado> resultados_esperados;
    List<Atributo> atributos;
    List<ComportamientoReactivoEscala> listaCRE;


    public List<Resultado_Esperado> getResultados_esperados() {
        return resultados_esperados;
    }

    public void setResultados_esperados(List<Resultado_Esperado> resultados_esperados) {
        this.resultados_esperados = resultados_esperados;
    }

    public List<Atributo> getAtributos() {
        return atributos;
    }

    public void setAtributos(List<Atributo> atributos) {
        this.atributos = atributos;
    }

    public List<ComportamientoReactivoEscala> getListaCRE() {
        return listaCRE;
    }

    public void setListaCRE(List<ComportamientoReactivoEscala> listaCRE) {
        this.listaCRE = listaCRE;
    }

    public int getIdEncuesta() {
        return idEncuesta;
    }

    public void setIdEncuesta(int idEncuesta) {
        this.idEncuesta = idEncuesta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
