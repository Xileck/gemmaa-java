package com.cfemex.lv.is.GEMMAA.BO;

import com.cfemex.lv.is.GEMMAA.Atributo;
import com.cfemex.lv.is.GEMMAA.ComportamientoReactivoEscala;
import com.cfemex.lv.is.GEMMAA.Encuesta;
import com.cfemex.lv.is.GEMMAA.DAO.EncuestaDAO;
import com.cfemex.lv.is.GEMMAA.TipoEncuesta;

import java.util.List;

/**
 * * Created by JCDI on 31/10/2016.
 **/
public class EncuestaBO {
    public static EncuestaDAO _encuestaDAO = new EncuestaDAO();

    public String getNombreEncuesta(int id_tipo_encuesta) {
        return _encuestaDAO.getNombreEncuesta(id_tipo_encuesta);
    }

    public Encuesta getEncuesta(int id_tipo_encuesta) {
        Encuesta encuesta = new Encuesta();
        encuesta.setNombre(_encuestaDAO.getNombreEncuesta(id_tipo_encuesta));
        encuesta.setNombre(_encuestaDAO.getNombreEncuesta(id_tipo_encuesta));
        encuesta.setIdEncuesta(id_tipo_encuesta);
        encuesta.setResultados_esperados(_encuestaDAO.getResultadosEsperadosEncuesta(id_tipo_encuesta));
        encuesta.setAtributos(_encuestaDAO.getAtributosEncuesta(id_tipo_encuesta));
        encuesta.setListaCRE(_encuestaDAO.getComportamientosReactivosEscala(id_tipo_encuesta));
        return encuesta;
    }

    public void guardarEncuestaContestada(List<ComportamientoReactivoEscala> listaCRE, int id_evaluador) {
        _encuestaDAO.guardarEncuestaContestada(listaCRE, id_evaluador);
    }

    public List<TipoEncuesta> getCatalogoEncuestas() {
        return _encuestaDAO.getCatalogoEncuestas();
    }

    public void actualizarRegistroCRE(ComportamientoReactivoEscala cre) {
        _encuestaDAO.actualizarRegistroCRE(cre);
    }

    public void agregarRegistroCRE(ComportamientoReactivoEscala cre) {
        _encuestaDAO.agregarRegistroCRE(cre);
    }

    public void eliminarRegistroCRE(ComportamientoReactivoEscala cre) {
        _encuestaDAO.eliminarRegistroCRE(cre);
    }

    public void actualizarRegistroAtributo(Atributo atr) {
        _encuestaDAO.actualizarRegistroAtributo(atr);

    }

}