package com.cfemex.lv.is.GEMMAA.BO;

import com.cfemex.lv.EmpleadoDAO;
import com.cfemex.lv.is.GEMMAA.DAO.ReportesDAO;
import com.cfemex.lv.is.GEMMAA.Encuesta;
import com.cfemex.lv.is.GEMMAA.Evaluador;
import com.cfemex.lv.is.GEMMAA.GrupoEvaluacion;
import com.cfemex.lv.is.GEMMAA.Promedios;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cfe on 05/01/2017.
 */
public class ReportesBO {
    public static ReportesDAO _reportesDAO = new ReportesDAO();
    public static ReportesBO _reportesBO = new ReportesBO();
    public static EmpleadoDAO _empleadoDAO = new EmpleadoDAO();
    public static EncuestaBO _encuestaBO = new EncuestaBO();
    public static UtilBO _utilBO = new UtilBO();

    public List<Number> getIdEvaluaciones(int nip_usuario) {
        return _reportesDAO.getIdEvaluaciones(nip_usuario);
    }

    public List<GrupoEvaluacion> getEvaluacionesDeUsuario(int nip) {
        List<Number> idEvaluaciones = _reportesDAO.getEvaluacionesDeUsuario(nip);
        List<GrupoEvaluacion> evaluaciones = new ArrayList<GrupoEvaluacion>();
        for (Number id : idEvaluaciones) {
            GrupoEvaluacion evaluacion = _reportesBO.getGrupoEvaluacionSimple(id.intValue());
            evaluaciones.add(evaluacion);
        }
        return evaluaciones;
    }

    public GrupoEvaluacion getGrupoEvaluacion(int id_evaluacion) {
        GrupoEvaluacion grupoEvaluacion = _reportesDAO.getDatosEvaluacion(id_evaluacion);
        grupoEvaluacion.setEvaluadores(_reportesDAO.getEvaluadoresDeEvaluacion(id_evaluacion));

        Encuesta enc = _encuestaBO.getEncuesta(grupoEvaluacion.getIdte());
        grupoEvaluacion.setPromedios(new Promedios(enc.getAtributos(), enc.getResultados_esperados(), enc.getListaCRE()));

        for (Evaluador e : grupoEvaluacion.getEvaluadores()) {
            e.setEncuesta(_reportesDAO.getEvaluacionContestada(grupoEvaluacion.getIdte(), e.getId_evaluador()));
        }

        grupoEvaluacion.setEvaluado(_empleadoDAO.seleccionarEmpleado(_utilBO.getInfoEvaluado(grupoEvaluacion.getNip_de_evaluado()).getRpe()));
        return grupoEvaluacion;
    }

    public GrupoEvaluacion getGrupoEvaluacionSimple(int id_evaluacion) {
        GrupoEvaluacion grupoEvaluacion = _reportesDAO.getDatosEvaluacion(id_evaluacion);
        grupoEvaluacion.setEvaluadores(_reportesDAO.getEvaluadoresDeEvaluacionSimple(id_evaluacion));

        Encuesta enc = _encuestaBO.getEncuesta(grupoEvaluacion.getIdte());
        grupoEvaluacion.setPromedios(new Promedios(enc.getAtributos(), enc.getResultados_esperados(), enc.getListaCRE()));


        return grupoEvaluacion;
    }
}