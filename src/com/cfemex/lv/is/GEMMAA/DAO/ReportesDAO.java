package com.cfemex.lv.is.GEMMAA.DAO;

import com.cfemex.lv.EmpleadoDAO;
import com.cfemex.lv.is.GEMMAA.*;
import com.cfemex.lv.is.GEMMAA.BO.UtilBO;
import com.cfemex.lv.libs.informix.Informix;

import java.sql.ResultSet;
import java.util.*;

/**
 * Created by cfe on 05/01/2017.
 */
public class ReportesDAO {

    public static ReportesDAO instance = null;

    public static ReportesDAO getInstance() {
        if (instance == null) {
            instance = new ReportesDAO();
        }
        return instance;
    }

    public List<Number> getIdEvaluaciones(int nip_usuario) {
        Informix q1 = new Informix("GEMMAA360", "Informix/GEMMAA360");
        List<Number> listaIdEvaluaciones = new ArrayList<Number>() {
        };
        ResultSet rs = null;

        StringBuilder qry = new StringBuilder();
        qry.append(" SELECT gemmaa_evaluaciones.id_evaluacion ");
        qry.append(" FROM gemmaa_evaluaciones, gemmaa_evaluadores ");
        qry.append(" WHERE gemmaa_evaluaciones.id_evaluacion = gemmaa_evaluadores.id_evaluacion ");
        qry.append(" AND gemmaa_evaluadores.nip_evaluador = " + nip_usuario + " ");

        try {
            q1.setQry(qry.toString());
            q1.setPreparaSelect();
            rs = q1.getSelect();

            while (rs.next()) {
                listaIdEvaluaciones.add(rs.getInt(1));
            }


        } catch (Exception ex) {

        } finally {
            q1.desconectarBD();
        }
        return listaIdEvaluaciones;
    }

    public Ponderados getPonderadosEvaluacion(int id_ponderado) {
        Informix q1 = new Informix("GEMMAA360", "Informix/GEMMAA360");
        Ponderados ponderado = new Ponderados();
        ResultSet rs = null;
        StringBuilder qry = new StringBuilder();
        qry.append(" SELECT * ");
        qry.append(" FROM gemmaa_ponderados ");
        qry.append(" WHERE idp = " + id_ponderado + " ");

        try {
            q1.setQry(qry.toString());
            q1.setPreparaSelect();
            rs = q1.getSelect();

            while (rs.next()) {
                ponderado.setIdp(rs.getInt(1));
                ponderado.setJefe(rs.getInt(2));
                ponderado.setColaborador(rs.getInt(3));
                ponderado.setPar(rs.getInt(4));
                ponderado.setEvaluado(rs.getInt(5));
                ponderado.setCliente(rs.getInt(6));
            }


        } catch (Exception ex) {

        } finally {
            q1.desconectarBD();
        }
        return ponderado;

    }

    public List<Number> getEvaluacionesDeUsuario(int nip) {
        Informix q1 = new Informix("GEMMAA360", "Informix/GEMMAA360");
        List<Number> lista = new ArrayList<Number>();
        ResultSet rs = null;
        StringBuilder qry = new StringBuilder();
        qry.append(" SELECT gemmaa_evaluaciones.id_evaluacion ");
        qry.append(" FROM gemmaa_evaluaciones ");
        qry.append(" WHERE gemmaa_evaluaciones.nip_de_evaluado = " + nip + "; ");

        try {
            q1.setQry(qry.toString());
            q1.setPreparaSelect();
            rs = q1.getSelect();
            while (rs.next()) {
                lista.add(rs.getInt(1));
            }

        } catch (Exception ex) {

        } finally {
            q1.desconectarBD();
        }
        return lista;
    }

    public List<Number> getEvaluacionesQueParticipoUsuario(int nip) {
        Informix q1 = new Informix("GEMMAA360", "Informix/GEMMAA360");
        List<Number> lista = new ArrayList<Number>();
        ResultSet rs = null;
        StringBuilder qry = new StringBuilder();
        qry.append(" SELECT gemmaa_evaluaciones.id_evaluacion ");
        qry.append(" FROM gemmaa_evaluaciones, gemmaa_evaluadores ");
        qry.append(" WHERE gemmaa_evaluaciones.id_evaluacion = gemmaa_evaluadores.id_evaluacion ");
        qry.append(" and gemmaa_evaluadores.tipo_de_evaluador = 'JEFE' ");
        qry.append(" AND gemmaa_evaluadores.nip_evaluador = " + nip + " ");

        try {
            q1.setQry(qry.toString());
            q1.setPreparaSelect();
            rs = q1.getSelect();
            while (rs.next()) {
                lista.add(rs.getInt(1));
            }

        } catch (Exception ex) {

        } finally {
            q1.desconectarBD();
        }
        return lista;
    }

    public GrupoEvaluacion getDatosEvaluacion(int id_evaluacion) {
        Informix q1 = new Informix("GEMMAA360", "Informix/GEMMAA360");
        GrupoEvaluacion grupoEvaluacion = new GrupoEvaluacion();
        ResultSet rs = null;
        StringBuilder qry = new StringBuilder();
        qry.append(" SELECT gemmaa_evaluaciones.id_evaluacion, gemmaa_evaluaciones.idte, gemmaa_evaluaciones.nip_de_evaluado, gemmaa_tipo_encuestas.descripcion, gemmaa_evaluaciones.fecha, gemmaa_evaluaciones.finalizada, gemmaa_ponderados.idp ");
        qry.append("  FROM gemmaa_tipo_encuestas, gemmaa_evaluaciones, gemmaa_ponderados ");
        qry.append("  WHERE gemmaa_evaluaciones.id_evaluacion = " + id_evaluacion + " ");
        qry.append("  and gemmaa_evaluaciones.idte = gemmaa_tipo_encuestas.idte ");
        qry.append("  and gemmaa_ponderados.idp = gemmaa_evaluaciones.idp; ");

        try {
            q1.setQry(qry.toString());
            q1.setPreparaSelect();
            rs = q1.getSelect();

            while (rs.next()) {
                grupoEvaluacion.setId_evaluacion(rs.getInt(1));
                grupoEvaluacion.setIdte(rs.getInt(2));
                grupoEvaluacion.setNip_de_evaluado(rs.getInt(3));
                grupoEvaluacion.setDescripcionEncuesta(rs.getString(4));
                grupoEvaluacion.setFecha(rs.getString(5));
                grupoEvaluacion.setFinalizada(rs.getString(6));
                grupoEvaluacion.setPonderados(ReportesDAO.getInstance().getPonderadosEvaluacion(rs.getInt(7)));
            }


        } catch (Exception ex) {

        } finally {
            q1.desconectarBD();
        }
        return grupoEvaluacion;

    }

    public void updatePonderado(int id_evaluacion, int id_ponderado) {
        Informix q1 = new Informix("GEMMAA360", "Informix/GEMMAA360");
        StringBuilder qry = new StringBuilder();

        qry.append(" update gemmaa_evaluaciones ");
        qry.append(" set idp = " + id_ponderado + " ");
        qry.append(" where id_evaluacion = " + id_evaluacion + "; ");

        try {
            q1.setQrypreparaUpdate(qry.toString());
            q1.getInsert();
        } catch (Exception ex) {

        } finally {
            q1.desconectarBD();
        }
    }

    public List<Evaluador> getEvaluadoresDeEvaluacion(int id_evaluacion) {
        Informix q1 = new Informix("GEMMAA360", "Informix/GEMMAA360");
        ResultSet rs = null;
        List<Evaluador> evaluadores = new ArrayList<Evaluador>();
        StringBuilder qry = new StringBuilder();
        qry.append(" SELECT gemmaa_evaluadores.nip_evaluador, gemmaa_evaluadores.tipo_de_evaluador, gemmaa_evaluadores.id_evaluador, gemmaa_evaluadores.finalizo, gemmaa_evaluadores.fecha  ");
        qry.append(" FROM gemmaa_tipo_encuestas, gemmaa_evaluaciones, gemmaa_evaluadores ");
        qry.append(" WHERE gemmaa_evaluaciones.id_evaluacion = " + id_evaluacion + " ");
        qry.append(" and gemmaa_evaluadores.id_evaluacion = gemmaa_evaluaciones.id_evaluacion ");
        qry.append(" and gemmaa_evaluaciones.idte = gemmaa_tipo_encuestas.idte ");

        try {
            q1.setQry(qry.toString());
            q1.setPreparaSelect();
            rs = q1.getSelect();

            while (rs.next()) {
                Evaluador consulta = new Evaluador();
                consulta.setNip_evaluador(rs.getInt(1));
                consulta.setTipo_de_evaluador(rs.getString(2));
                consulta.setId_evaluador(rs.getInt(3));
                consulta.setFinalizo(rs.getString(4));
                consulta.setFecha(rs.getString(5));
                consulta.setEmpleado(EmpleadoDAO.getInstance().seleccionarEmpleado(UtilDAO.getInstance().getInfoEvaluado(consulta.getNip_evaluador()).getRpe()));
                evaluadores.add(consulta);
            }


        } catch (Exception ex) {

        } finally {
            q1.desconectarBD();
        }
        return evaluadores;
    }

    public List<Evaluador> getEvaluadoresDeEvaluacionSimple(int id_evaluacion) {
        Informix q1 = new Informix("GEMMAA360", "Informix/GEMMAA360");
        ResultSet rs = null;
        List<Evaluador> evaluadores = new ArrayList<Evaluador>();
        StringBuilder qry = new StringBuilder();
        qry.append(" SELECT gemmaa_evaluadores.nip_evaluador, gemmaa_evaluadores.tipo_de_evaluador, gemmaa_evaluadores.id_evaluador, gemmaa_evaluadores.finalizo, gemmaa_evaluadores.fecha ");
        qry.append(" FROM gemmaa_tipo_encuestas, gemmaa_evaluaciones, gemmaa_evaluadores ");
        qry.append(" WHERE gemmaa_evaluaciones.id_evaluacion = " + id_evaluacion + " ");
        qry.append(" and gemmaa_evaluadores.id_evaluacion = gemmaa_evaluaciones.id_evaluacion ");
        qry.append(" and gemmaa_evaluaciones.idte = gemmaa_tipo_encuestas.idte ");

        try {
            q1.setQry(qry.toString());
            q1.setPreparaSelect();
            rs = q1.getSelect();

            while (rs.next()) {
                Evaluador consulta = new Evaluador();
                consulta.setNip_evaluador(rs.getInt(1));
                consulta.setTipo_de_evaluador(rs.getString(2));
                consulta.setId_evaluador(rs.getInt(3));
                consulta.setFinalizo(rs.getString(4));
                consulta.setFecha(rs.getString(5));
                consulta.setNombre_completo(UtilBO.getInstance().getNombreCompleto(rs.getInt(1)));
                evaluadores.add(consulta);
            }

        } catch (Exception ex) {

        } finally {
            q1.desconectarBD();
        }
        return evaluadores;
    }

    public Encuesta getEvaluacionContestada(int id_tipo_encuesta, int id_evaluador) {
        Encuesta encuesta = new Encuesta();
        encuesta.setNombre(EncuestaDAO.getInstance().getNombreEncuesta(id_tipo_encuesta));
        encuesta.setNombre(EncuestaDAO.getInstance().getNombreEncuesta(id_tipo_encuesta));
        encuesta.setIdEncuesta(id_tipo_encuesta);
        encuesta.setResultados_esperados(EncuestaDAO.getInstance().getResultadosEsperadosEncuesta(id_tipo_encuesta));
        encuesta.setAtributos(EncuestaDAO.getInstance().getAtributosEncuesta(id_tipo_encuesta));
        encuesta.setListaCRE(EncuestaDAO.getInstance().getComportamientosReactivosEscalaRespuesta(id_tipo_encuesta, id_evaluador));
        return encuesta;
    }

    public List<Number> buscarIdEvaluacionesEmpleado(String nombre_rpe) {
        Informix q1 = new Informix("GEMMAA360", "Informix/GEMMAA360");
        ResultSet rs = null;
        List<Number> idEvaluaciones = new ArrayList<Number>();
        String[] words = nombre_rpe.toUpperCase().split(" ");
        StringBuilder qry = new StringBuilder();
        qry.append(" SELECT gemmaa_evaluaciones.id_evaluacion ");
        qry.append(" FROM pers1, empl, gemmaa_evaluaciones, gemmaa_evaluadores ");
        qry.append(" WHERE pers1.nip = empl.nip ");
        qry.append(" AND gemmaa_evaluadores.nip_evaluador = empl.nip ");
        qry.append(" AND gemmaa_evaluaciones.id_evaluacion = gemmaa_evaluadores.id_evaluacion ");
        for (String word : words) {
            qry.append(" AND (pers1.appat matches '*" + word + "*' or pers1.apmat matches '*" + word + "*'  OR pers1.nombre matches '*" + word + "*' OR empl.rpe matches '*" + word + "*') ");
        }

        try {
            q1.setQry(qry.toString());
            q1.setPreparaSelect();
            rs = q1.getSelect();

            while (rs.next()) {
                Number consulta = rs.getInt(1);
                if (!idEvaluaciones.contains(consulta))
                    idEvaluaciones.add(consulta);
            }


        } catch (Exception ex) {

        } finally {
            q1.desconectarBD();
        }
        return idEvaluaciones;
    }
}