package com.cfemex.lv.is.GEMMAA.BO;

import com.cfemex.lv.is.GEMMAA.*;
import com.cfemex.lv.is.GEMMAA.DAO.EncuestaDAO;

import java.util.List;

/**
 * * Created by JCDI on 31/10/2016.
 **/
public class EncuestaBO {

    public static EncuestaBO instance = null;

    public static EncuestaBO getInstance() {
        if (instance == null) {
            instance = new EncuestaBO();
        }
        return instance;
    }

    public void insertarPonderados(Ponderados ponderados) {
        EncuestaDAO.getInstance().insertarPonderados(ponderados);
    }

    public List<Ponderados> getListaPonderados() {
        return EncuestaDAO.getInstance().getListaPonderados();
    }

    public String getNombreEncuesta(int id_tipo_encuesta) {
        return EncuestaDAO.getInstance().getNombreEncuesta(id_tipo_encuesta);
    }

    public Encuesta getEncuesta(int id_tipo_encuesta) {
        Encuesta encuesta = new Encuesta();
        encuesta.setNombre(EncuestaDAO.getInstance().getNombreEncuesta(id_tipo_encuesta));
        encuesta.setNombre(EncuestaDAO.getInstance().getNombreEncuesta(id_tipo_encuesta));
        encuesta.setIdEncuesta(id_tipo_encuesta);
        encuesta.setResultados_esperados(EncuestaDAO.getInstance().getResultadosEsperadosEncuesta(id_tipo_encuesta));
        encuesta.setAtributos(EncuestaDAO.getInstance().getAtributosEncuesta(id_tipo_encuesta));
        encuesta.setListaCRE(EncuestaDAO.getInstance().getComportamientosReactivosEscala(id_tipo_encuesta));
        return encuesta;
    }

    public void guardarEncuestaContestada(List<ComportamientoReactivoEscala> listaCRE, int id_evaluador) {
        EncuestaDAO.getInstance().guardarEncuestaContestada(listaCRE, id_evaluador);
    }

    public List<TipoEncuesta> getCatalogoEncuestas() {
        return EncuestaDAO.getInstance().getCatalogoEncuestas();
    }

    public void actualizarRegistroCRE(ComportamientoReactivoEscala cre) {
        EncuestaDAO.getInstance().actualizarRegistroCRE(cre);
    }

    public void agregarRegistroCRE(ComportamientoReactivoEscala cre) {
        EncuestaDAO.getInstance().agregarRegistroCRE(cre);
    }

    public void eliminarRegistroCRE(ComportamientoReactivoEscala cre) {
        EncuestaDAO.getInstance().eliminarRegistroCRE(cre);
    }

    public void actualizarRegistroAtributo(Atributo atr) {
        EncuestaDAO.getInstance().actualizarRegistroAtributo(atr);

    }

}