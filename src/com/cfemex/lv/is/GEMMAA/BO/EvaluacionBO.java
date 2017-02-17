package com.cfemex.lv.is.GEMMAA.BO;

import com.cfemex.lv.is.GEMMAA.DAO.EvaluacionDAO;
import com.cfemex.lv.is.GEMMAA.Evaluacion;
import com.cfemex.lv.is.GEMMAA.EvaluacionPendiente;
import com.cfemex.lv.is.GEMMAA.Evaluador;
import com.cfemex.lv.libs.seguridad.roles.negocio.UsuarioRolBO;

import java.util.List;

/**
 * Created by cfe on 01/12/2016.
 */
public class EvaluacionBO {

    public void crearEvaluacion(Evaluacion _evaluacion, List<Evaluador> _listaEvaluadores) {

        EvaluacionDAO.getInstance().crearEvaluacion(_evaluacion);

        for (Evaluador e : _listaEvaluadores) {
            EvaluacionDAO.getInstance().asignarEvaluador(e);
        }
    }

    public List<EvaluacionPendiente> evaluacionesPendientes(int nip_evaluador) {

        return EvaluacionDAO.getInstance().evaluacionesPendientes(nip_evaluador);
    }

    public boolean evaluacionFinalizada(int id_evaluacion) {
        return EvaluacionDAO.getInstance().evaluacionFinalizada(id_evaluacion);
    }

    public boolean checarSiGrupoEvaluacionTermino(int id_evaluacion) {
        return EvaluacionDAO.getInstance().checarSiGrupoEvaluacionTermino(id_evaluacion);
    }
}

