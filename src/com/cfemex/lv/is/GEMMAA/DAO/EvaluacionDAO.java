package com.cfemex.lv.is.GEMMAA.DAO;

import com.cfemex.lv.is.GEMMAA.Evaluacion;
import com.cfemex.lv.is.GEMMAA.EvaluacionPendiente;
import com.cfemex.lv.is.GEMMAA.Evaluador;
import com.cfemex.lv.is.GEMMAA.TipoEncuesta;
import com.cfemex.lv.libs.informix.Informix;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cfe on 01/12/2016.
 */
public class EvaluacionDAO {

    public static EvaluacionDAO instance = null;

    public static EvaluacionDAO getInstance() {
        if (instance == null) {
            instance = new EvaluacionDAO();
        }
        return instance;
    }

    public void crearEvaluacion(Evaluacion _evaluacion) {
        Informix q1 = new Informix("GEMMAA360", "Informix/GEMMAA360");
        StringBuilder qry = new StringBuilder();
        qry.append(" INSERT INTO gemmaa_evaluaciones (id_evaluacion, idte, idp,  nip_de_evaluado, fecha, finalizada) ");
        qry.append(" VALUES ((SELECT MAX(id_evaluacion) + 1 FROM gemmaa_evaluaciones), " + _evaluacion.getIdte() + ", " + _evaluacion.getIdp() + ", " + _evaluacion.getNip_de_evaluado() + ", current, '" + _evaluacion.getFinalizada() + "'); ");

        try {
            q1.setQrypreparaUpdate(qry.toString());
            q1.getInsert();
        } catch (Exception ex) {

        } finally {
            q1.desconectarBD();
        }

    }

    public void asignarEvaluador(Evaluador _evaluador) {
        Informix q1 = new Informix("GEMMAA360", "Informix/GEMMAA360");
        StringBuilder qry = new StringBuilder();
        qry.append(" INSERT INTO gemmaa_evaluadores (id_evaluador,id_evaluacion,nip_evaluador,tipo_de_evaluador,fecha, finalizo) ");
        qry.append(" VALUES ((SELECT MAX(id_evaluador) + 1 FROM gemmaa_evaluadores), (SELECT MAX(id_evaluacion) FROM gemmaa_evaluaciones), " + _evaluador.getNip_evaluador() + ", '" + _evaluador.getTipo_de_evaluador() + "',current, '" + _evaluador.getFinalizo() + "'); ");

        try {
            q1.setQrypreparaUpdate(qry.toString());
            q1.getInsert();
        } catch (Exception ex) {

        } finally {
            q1.desconectarBD();
        }
    }
    public boolean evaluacionFinalizada(int id_evaluador) {
        Informix q1 = new Informix("GEMMAA360", "Informix/GEMMAA360");
        boolean resultado = false;
        ResultSet rs = null;

        StringBuilder qry = new StringBuilder();
        qry.append(" SELECT gemmaa_evaluadores.finalizo ");
        qry.append(" FROM gemmaa_evaluadores ");
        qry.append(" WHERE gemmaa_evaluadores.id_evaluador = " + id_evaluador + " ");
        try {
            q1.setQry(qry.toString());
            q1.setPreparaSelect();
            rs = q1.getSelect();

            while (rs.next()) {
                if (rs.getBoolean(1) == true)
                    resultado = true;
                else
                    resultado = false;
            }


        } catch (Exception ex) {

        } finally {
            q1.desconectarBD();
        }
        return resultado;
    }
    public List<EvaluacionPendiente> evaluacionesPendientes(int nip_evaluador) {
        Informix q1 = new Informix("GEMMAA360", "Informix/GEMMAA360");
        EvaluacionPendiente evaluacionPendiente = null;
        List<EvaluacionPendiente> listaEvaPendientes = new ArrayList<EvaluacionPendiente>();
        ResultSet rs = null;

        StringBuilder qry = new StringBuilder();
        qry.append(" SELECT gemmaa_evaluadores.nip_evaluador, gemmaa_evaluaciones.id_evaluacion, gemmaa_evaluaciones.idte, gemmaa_evaluaciones.nip_de_evaluado, gemmaa_tipo_encuestas.descripcion, gemmaa_evaluadores.tipo_de_evaluador, gemmaa_evaluadores.id_evaluador, gemmaa_evaluadores.finalizo ");
        qry.append(" FROM gemmaa_tipo_encuestas, gemmaa_evaluaciones, gemmaa_evaluadores ");
        qry.append(" WHERE gemmaa_evaluadores.nip_evaluador = " + nip_evaluador + " ");
        qry.append(" and gemmaa_evaluaciones.id_evaluacion = gemmaa_evaluadores.id_evaluacion ");
        qry.append(" and gemmaa_evaluadores.finalizo = 'F' ");
        qry.append(" and gemmaa_evaluaciones.idte = gemmaa_tipo_encuestas.idte ");

        try {
            q1.setQry(qry.toString());
            q1.setPreparaSelect();
            rs = q1.getSelect();

            while (rs.next()) {
                evaluacionPendiente = new EvaluacionPendiente();
                evaluacionPendiente.setNip_evaluador(rs.getInt(1));
                evaluacionPendiente.setId_evaluacion(rs.getInt(2));
                evaluacionPendiente.setIdte(rs.getInt(3));
                evaluacionPendiente.setNip_de_evaluado(rs.getInt(4));
                evaluacionPendiente.setNombre_encuesta(rs.getString(5));
                evaluacionPendiente.setTipo_de_evaluador(rs.getString(6));
                evaluacionPendiente.setId_evaluador(rs.getInt(7));
                evaluacionPendiente.setFinalizo(rs.getString(8));
                listaEvaPendientes.add(evaluacionPendiente);
            }


        } catch (Exception ex) {

        } finally {
            q1.desconectarBD();
        }
        return listaEvaPendientes;
    }

}
