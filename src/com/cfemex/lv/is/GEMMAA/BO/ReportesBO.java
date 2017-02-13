package com.cfemex.lv.is.GEMMAA.BO;

import com.cfemex.lv.EmpleadoDAO;
import com.cfemex.lv.is.GEMMAA.DAO.BitacoraDAO;
import com.cfemex.lv.is.GEMMAA.DAO.ReportesDAO;
import com.cfemex.lv.is.GEMMAA.DAO.UtilDAO;
import com.cfemex.lv.is.GEMMAA.Encuesta;
import com.cfemex.lv.is.GEMMAA.Evaluador;
import com.cfemex.lv.is.GEMMAA.GrupoEvaluacion;
import com.cfemex.lv.is.GEMMAA.Promedios;
import com.cfemex.lv.is.apps.intranet.Empl;
import com.cfemex.lv.is.apps.intranet.UsuarioDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cfe on 05/01/2017.
 */
public class ReportesBO {

    public static ReportesBO instance = null;

    public static ReportesBO getInstance() {
        if (instance == null) {
            instance = new ReportesBO();
        }
        return instance;
    }

    public List<Number> getIdEvaluaciones(int nip_usuario) {
        return ReportesDAO.getInstance().getIdEvaluaciones(nip_usuario);
    }

    public List<GrupoEvaluacion> getEvaluacionesDeUsuario(int nip) {
        List<Number> idEvaluaciones = ReportesDAO.getInstance().getEvaluacionesDeUsuario(nip);
        List<GrupoEvaluacion> evaluaciones = new ArrayList<GrupoEvaluacion>();
        for (Number id : idEvaluaciones) {
            GrupoEvaluacion evaluacion = ReportesBO.getInstance().getGrupoEvaluacionSimple(id.intValue());
            evaluaciones.add(evaluacion);
        }
        return evaluaciones;
    }

    // Evaluaciones que se participo como jefe
    public List<GrupoEvaluacion> getEvaluacionesParticipadas(int nip) {
        List<Number> idEvaluaciones = ReportesDAO.getInstance().getEvaluacionesQueParticipoUsuario(nip);
        List<GrupoEvaluacion> evaluaciones = new ArrayList<GrupoEvaluacion>();
        for (Number id : idEvaluaciones) {
            GrupoEvaluacion evaluacion = ReportesBO.getInstance().getGrupoEvaluacionSimple(id.intValue());
            evaluacion.setEvaluado(EmpleadoDAO.getInstance().seleccionarEmpleado(UtilDAO.getInstance().getInfoEvaluado(nip).getRpe()));
            evaluaciones.add(evaluacion);
        }
        return evaluaciones;
    }

    public GrupoEvaluacion getGrupoEvaluacion(int id_evaluacion) {
        GrupoEvaluacion grupoEvaluacion = ReportesDAO.getInstance().getDatosEvaluacion(id_evaluacion);
        grupoEvaluacion.setEvaluadores(ReportesDAO.getInstance().getEvaluadoresDeEvaluacion(id_evaluacion));

        Encuesta enc = EncuestaBO.getInstance().getEncuesta(grupoEvaluacion.getIdte());
        grupoEvaluacion.setPromedios(new Promedios(enc.getAtributos(), enc.getResultados_esperados(), enc.getListaCRE()));

        for (Evaluador e : grupoEvaluacion.getEvaluadores()) {
            e.setEncuesta(ReportesDAO.getInstance().getEvaluacionContestada(grupoEvaluacion.getIdte(), e.getId_evaluador()));
        }

        grupoEvaluacion.setEvaluado(EmpleadoDAO.getInstance().seleccionarEmpleado(UtilBO.getInstance().getInfoEvaluado(grupoEvaluacion.getNip_de_evaluado()).getRpe()));
        return grupoEvaluacion;
    }

    public GrupoEvaluacion getGrupoEvaluacionSimple(int id_evaluacion) {
        GrupoEvaluacion grupoEvaluacion = ReportesDAO.getInstance().getDatosEvaluacion(id_evaluacion);
        grupoEvaluacion.setEvaluadores(ReportesDAO.getInstance().getEvaluadoresDeEvaluacionSimple(id_evaluacion));

        Encuesta enc = EncuestaBO.getInstance().getEncuesta(grupoEvaluacion.getIdte());
        grupoEvaluacion.setPromedios(new Promedios(enc.getAtributos(), enc.getResultados_esperados(), enc.getListaCRE()));

        return grupoEvaluacion;
    }

    public List<GrupoEvaluacion> getGruposEvaluacionEmpleado(String nombre_rpe) {
        List<Number> idEvaluaciones = ReportesDAO.getInstance().buscarIdEvaluacionesEmpleado(nombre_rpe);
        List<GrupoEvaluacion> grupos = new ArrayList<GrupoEvaluacion>();
        for (Number n : idEvaluaciones) {
            grupos.add(getGrupoEvaluacion(n.intValue()));
        }
        return grupos;
    }
}