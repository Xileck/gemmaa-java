package com.cfemex.lv.is.GEMMAA;

import java.util.List;

/**
 * Created by cfe on 12/01/2017.
 */
public class Promedios {
    List<Atributo> atributos;
    List<Resultado_Esperado> resultados_esperados;
    List<ComportamientoReactivoEscala> listaCRE;

    public Promedios(List<Atributo> a, List<Resultado_Esperado> re, List<ComportamientoReactivoEscala> cre) {
        atributos = a;
        resultados_esperados = re;
        listaCRE = cre;
    }

    public List<Atributo> getAtributos() {
        return atributos;
    }

    public void setAtributos(List<Atributo> atributos) {
        this.atributos = atributos;
    }

    public List<Resultado_Esperado> getResultados_esperados() {
        return resultados_esperados;
    }

    public void setResultados_esperados(List<Resultado_Esperado> resultados_esperados) {
        this.resultados_esperados = resultados_esperados;
    }

    public List<ComportamientoReactivoEscala> getListaCRE() {
        return listaCRE;
    }

    public void setListaCRE(List<ComportamientoReactivoEscala> listaCRE) {
        this.listaCRE = listaCRE;
    }
}
