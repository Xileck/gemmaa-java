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

    public static EvaluacionDAO _evaluacionDAO = new EvaluacionDAO();

    public void crearEvaluacion(Evaluacion _evaluacion, List<Evaluador> _listaEvaluadores) {

        _evaluacionDAO.crearEvaluacion(_evaluacion);

        for (Evaluador e : _listaEvaluadores) {
            _evaluacionDAO.asignarEvaluador(e);
        }
    }

    public List<EvaluacionPendiente> evaluacionesPendientes(int nip_evaluador) {

        return _evaluacionDAO.evaluacionesPendientes(nip_evaluador);
    }

    public boolean evaluacionFinalizada(int id_evaluacion) {
        return _evaluacionDAO.evaluacionFinalizada(id_evaluacion);
    }

}

