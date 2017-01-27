package com.cfemex.lv.is.GEMMAA.DAO;

import com.cfemex.lv.is.GEMMAA.Atributo;
import com.cfemex.lv.is.GEMMAA.ComportamientoReactivoEscala;
import com.cfemex.lv.is.GEMMAA.Encuesta;
import com.cfemex.lv.is.GEMMAA.Resultado_Esperado;
import com.cfemex.lv.is.GEMMAA.TipoEncuesta;
import com.cfemex.lv.libs.informix.Informix;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JCDI on 31/10/2016.
 */


public class EncuestaDAO {


    public String getNombreEncuesta(int id_tipo_encuesta) {
        Informix q1 = new Informix("GEMMAA360", "Informix/GEMMAA360");
        String consulta = null;
        ResultSet rs = null;

        StringBuilder qry = new StringBuilder();
        qry.append(" SELECT gemmaa_tipo_encuestas.descripcion ");
        qry.append(" FROM gemmaa_tipo_encuestas ");
        qry.append(" WHERE gemmaa_tipo_encuestas.idte = " + id_tipo_encuesta + " ");
        try {
            q1.setQry(qry.toString());
            q1.setPreparaSelect();
            rs = q1.getSelect();

            while (rs.next()) {
                consulta = new String();
                consulta = rs.getString(1);
            }

        } catch (Exception ex) {

        } finally {
            q1.desconectarBD();
        }
        return consulta;
    }

    public List<Resultado_Esperado> getResultadosEsperadosEncuesta(int id_tipo_encuesta) {
        Informix q1 = new Informix("GEMMAA360", "Informix/GEMMAA360");
        Resultado_Esperado consulta = null;
        List<Resultado_Esperado> consulta_list = new ArrayList<Resultado_Esperado>();
        ResultSet rs = null;

        StringBuilder qry = new StringBuilder();
        qry.append(" SELECT gemmaa_resultado_esperado.idre, TRIM(gemmaa_resultado_esperado.descripcion) descripcion ");
        qry.append(" FROM gemmaa_resultado_esperado, gemmaa_tipo_encuestas ");
        qry.append(" WHERE gemmaa_resultado_esperado.idte = " + id_tipo_encuesta + " and gemmaa_resultado_esperado.idte = gemmaa_tipo_encuestas.idte ");
        try {
            q1.setQry(qry.toString());
            q1.setPreparaSelect();
            rs = q1.getSelect();

            while (rs.next()) {
                consulta = new Resultado_Esperado();
                consulta.setIdResultadoEsperado(rs.getInt(1));
                consulta.setDescripcion(rs.getString(2));
                consulta_list.add(consulta);
            }

        } catch (Exception ex) {

        } finally {
            q1.desconectarBD();
        }
        return consulta_list;
    }

    public List<Atributo> getAtributosEncuesta(int id_tipo_encuesta) {
        Informix q1 = new Informix("GEMMAA360", "Informix/GEMMAA360");
        Atributo consulta = null;
        List<Atributo> consulta_list = new ArrayList<Atributo>();
        ResultSet rs = null;

        StringBuilder qry = new StringBuilder();
        qry.append(" SELECT gemmaa_atributos.ida,  gemmaa_atributos.idre,  TRIM(gemmaa_atributos.nombre) nombre, TRIM(gemmaa_atributos.descripcion) descripcion ");
        qry.append(" FROM gemmaa_resultado_esperado, gemmaa_tipo_encuestas, gemmaa_atributos ");
        qry.append(" WHERE gemmaa_resultado_esperado.idte = " + id_tipo_encuesta + " and gemmaa_resultado_esperado.idte = gemmaa_tipo_encuestas.idte and gemmaa_atributos.idre = gemmaa_resultado_esperado.idre ");
        try {
            q1.setQry(qry.toString());
            q1.setPreparaSelect();
            rs = q1.getSelect();

            while (rs.next()) {
                consulta = new Atributo();
                consulta.setIdAtributo(rs.getInt(1));
                consulta.setIdResultadoEsperado(rs.getInt(2));
                consulta.setNombre(rs.getString(3));
                consulta.setDescripcion(rs.getString(4));
                consulta_list.add(consulta);
            }

        } catch (Exception ex) {

        } finally {
            q1.desconectarBD();
        }

        return consulta_list;
    }

    public List<ComportamientoReactivoEscala> getComportamientosReactivosEscala(int id_tipo_encuesta) {
        Informix q1 = new Informix("GEMMAA360", "Informix/GEMMAA360");
        ComportamientoReactivoEscala consulta = null;
        List<ComportamientoReactivoEscala> consulta_list = new ArrayList<ComportamientoReactivoEscala>();
        ResultSet rs = null;

        StringBuilder qry = new StringBuilder();
        qry.append(" SELECT gemmaa_comportamientos_reactivos.idcr, gemmaa_atributos.ida, TRIM(gemmaa_comportamientos_reactivos.comportamiento) comportamiento, TRIM(gemmaa_comportamientos_reactivos.reactivo) reactivo, gemmaa_escala.respuesta_a, gemmaa_escala.respuesta_b, gemmaa_escala.respuesta_c, gemmaa_escala.respuesta_d ");
        qry.append(" FROM gemmaa_resultado_esperado, gemmaa_tipo_encuestas, gemmaa_atributos, gemmaa_comportamientos_reactivos, gemmaa_escala ");
        qry.append(" WHERE gemmaa_resultado_esperado.idte = " + id_tipo_encuesta + " ");
        qry.append(" and gemmaa_resultado_esperado.idte = gemmaa_tipo_encuestas.idte ");
        qry.append(" and gemmaa_atributos.idre = gemmaa_resultado_esperado.idre ");
        qry.append(" and gemmaa_atributos.ida = gemmaa_comportamientos_reactivos.ida ");
        qry.append(" and gemmaa_comportamientos_reactivos.idcr = gemmaa_escala.idcr ");
        try {
            q1.setQry(qry.toString());
            q1.setPreparaSelect();
            rs = q1.getSelect();

            while (rs.next()) {
                consulta = new ComportamientoReactivoEscala();
                consulta.setIdCRE(rs.getInt(1));
                consulta.setIdAtributo(rs.getInt(2));
                consulta.setComportamiento(rs.getString(3));
                consulta.setReactivo(rs.getString(4));
                consulta.setEscala_a(rs.getFloat(5));
                consulta.setEscala_b(rs.getFloat(6));
                consulta.setEscala_c(rs.getFloat(7));
                consulta.setEscala_d(rs.getFloat(8));
                consulta_list.add(consulta);
            }

        } catch (Exception ex) {

        } finally {
            q1.desconectarBD();
        }
        return consulta_list;
    }

    public List<ComportamientoReactivoEscala> getComportamientosReactivosEscalaRespuesta(int id_tipo_encuesta, int id_evaluador) {
        Informix q1 = new Informix("GEMMAA360", "Informix/GEMMAA360");
        ComportamientoReactivoEscala consulta = null;
        List<ComportamientoReactivoEscala> consulta_list = new ArrayList<ComportamientoReactivoEscala>();
        ResultSet rs = null;

        StringBuilder qry = new StringBuilder();
        qry.append(" SELECT gemmaa_comportamientos_reactivos.idcr, gemmaa_atributos.ida, TRIM(gemmaa_comportamientos_reactivos.comportamiento) comportamiento, TRIM(gemmaa_comportamientos_reactivos.reactivo) reactivo, gemmaa_escala.respuesta_a, gemmaa_escala.respuesta_b, gemmaa_escala.respuesta_c, gemmaa_escala.respuesta_d, gemmaa_respuestas.respuesta ");
        qry.append(" FROM gemmaa_resultado_esperado, gemmaa_tipo_encuestas, gemmaa_atributos, gemmaa_comportamientos_reactivos, gemmaa_escala , gemmaa_respuestas, gemmaa_evaluadores ");
        qry.append(" WHERE gemmaa_resultado_esperado.idte = gemmaa_tipo_encuestas.idte ");
        qry.append(" and gemmaa_atributos.idre = gemmaa_resultado_esperado.idre ");
        qry.append(" and gemmaa_atributos.ida = gemmaa_comportamientos_reactivos.ida ");
        qry.append(" and gemmaa_comportamientos_reactivos.idcr = gemmaa_escala.idcr ");
        qry.append(" and gemmaa_escala.ide = gemmaa_respuestas.ide ");
        qry.append(" and gemmaa_respuestas.id_evaluador = gemmaa_evaluadores.id_evaluador ");
        qry.append(" and gemmaa_respuestas.id_evaluador = " + id_evaluador + "; ");
        try {
            q1.setQry(qry.toString());
            q1.setPreparaSelect();
            rs = q1.getSelect();

            while (rs.next()) {
                consulta = new ComportamientoReactivoEscala();
                consulta.setIdCRE(rs.getInt(1));
                consulta.setIdAtributo(rs.getInt(2));
                consulta.setComportamiento(rs.getString(3));
                consulta.setReactivo(rs.getString(4));
                consulta.setEscala_a(rs.getFloat(5));
                consulta.setEscala_b(rs.getFloat(6));
                consulta.setEscala_c(rs.getFloat(7));
                consulta.setEscala_d(rs.getFloat(8));
                consulta.setRespuesta(rs.getString(9));
                consulta_list.add(consulta);
            }

        } catch (Exception ex) {

        } finally {
            q1.desconectarBD();
        }
        return consulta_list;
    }

    public List<TipoEncuesta> getCatalogoEncuestas() {
        Informix q1 = new Informix("GEMMAA360", "Informix/GEMMAA360");
        TipoEncuesta Encuesta = null;
        List<TipoEncuesta> listaCatalogo = new ArrayList<TipoEncuesta>();
        ResultSet rs = null;

        StringBuilder qry = new StringBuilder();
        qry.append(" SELECT * FROM gemmaa_tipo_encuestas ");

        try {
            q1.setQry(qry.toString());
            q1.setPreparaSelect();
            rs = q1.getSelect();

            while (rs.next()) {
                Encuesta = new TipoEncuesta();
                Encuesta.setIdte(rs.getInt(1));
                Encuesta.setDescripcion(rs.getString(2));
                listaCatalogo.add(Encuesta);
            }


        } catch (Exception ex) {

        } finally {
            q1.desconectarBD();
        }
        return listaCatalogo;
    }

    //-------------------------------------------------------------------------------------------------------//
    //----------------------------Guardar encuesta-----------------------------------------------------------//
    //-------------------------------------------------------------------------------------------------------//


    public void crearNuevaEncuesta(Encuesta encuesta) {
        Informix q1 = new Informix("GEMMAA360", "Informix/GEMMAA360");
        StringBuilder qry = new StringBuilder();
        qry.append(" INSERT INTO gemmaa_tipo_encuestas (idte, descripcion ) VALUES ((SELECT MAX(idte) + 1 FROM gemmaa_tipo_encuestas), '" + encuesta.getNombre() + "'); ");

        for (Resultado_Esperado re : encuesta.getResultados_esperados()) {
            qry.append(" INSERT INTO gemmaa_resultado_esperado (idre,idte,descripcion) VALUES ((SELECT MAX(idre) + 1 FROM gemmaa_resultado_esperado),(SELECT MAX(idte) FROM gemmaa_tipo_encuestas), '" + re.getDescripcion() + "'); ");
            for (Atributo atr : encuesta.getAtributos()) {
                if (atr.getIdResultadoEsperado() == re.getIdResultadoEsperado()) {
                    qry.append(" INSERT INTO gemmaa_atributos (ida, idre, nombre, descripcion) VALUES ((SELECT MAX(ida) + 1 FROM gemmaa_atributos), (SELECT MAX(idre) FROM gemmaa_resultado_esperado),'" + atr.getNombre() + "' ,'" + atr.getDescripcion() + "'); ");
                    for (ComportamientoReactivoEscala CRE : encuesta.getListaCRE()) {
                        if (CRE.getIdAtributo() == atr.getIdAtributo() && atr.getIdResultadoEsperado() == re.getIdResultadoEsperado()) {
                            qry.append(" INSERT INTO gemmaa_comportamientos_reactivos (idcr, ida, comportamiento, reactivo) VALUES ((SELECT MAX(idcr) + 1 FROM gemmaa_comportamientos_reactivos), (SELECT MAX(ida) FROM gemmaa_atributos), '" + CRE.getComportamiento() + "',  '" + CRE.getReactivo() + "'); ");
                            qry.append(" INSERT INTO gemmaa_escala (ide, idcr, respuesta_a,respuesta_b,respuesta_c,respuesta_d) VALUES ((SELECT MAX(ide) + 1 FROM gemmaa_escala), (SELECT MAX(idcr) FROM gemmaa_comportamientos_reactivos), " + CRE.getEscala_a() + ", " + CRE.getEscala_b() + ", " + CRE.getEscala_c() + ", " + CRE.getEscala_d() + "  ); ");
                        }
                    }
                }

            }
        }
        try {
            q1.setQrypreparaUpdate(qry.toString());
            q1.getInsert();
        } catch (Exception ex) {

        } finally {
            q1.desconectarBD();
        }
    }

    public void guardarEncuestaContestada(List<ComportamientoReactivoEscala> listaCRE, int id_evaluador) {
        Informix q1 = new Informix("GEMMAA360", "Informix/GEMMAA360");
        StringBuilder qry = new StringBuilder();

        for (ComportamientoReactivoEscala cre : listaCRE) {
            qry.append(" INSERT INTO gemmaa_respuestas(idr,ide,id_evaluador,respuesta) VALUES ((SELECT MAX(idr) + 1 FROM gemmaa_respuestas)," + cre.getIdCRE() + "," + id_evaluador + ",'" + cre.getRespuesta() + "'); ");
        }
        qry.append(" update gemmaa_evaluadores ");
        qry.append(" set finalizo = 'T', fecha = current ");
        qry.append(" where id_evaluador = " + id_evaluador + "; ");

        try {
            q1.setQrypreparaUpdate(qry.toString());
            q1.getInsert();
        } catch (Exception ex) {

        } finally {
            q1.desconectarBD();
        }
    }


//    public void guardarEncuestaContestada(int ide, int id_evaluador, String respuesta) {
//        Informix q1 = new Informix("GEMMAA360", "Informix/GEMMAA360");
//        StringBuilder qry = new StringBuilder();
//
//        qry.append(" INSERT INTO gemmaa_respuestas(idr,ide,id_evaluador,respuesta) VALUES ((SELECT MAX(idr) + 1 FROM gemmaa_respuestas)," + ide + "," + id_evaluador + ",'" + respuesta + "'); ");
//
//        try {
//            q1.setQrypreparaUpdate(qry.toString());
//            q1.getInsert();
//        } catch (Exception ex) {
//
//        } finally {
//            q1.desconectarBD();
//        }
//    }

    public void actualizarRegistroCRE(ComportamientoReactivoEscala cre) {
        Informix q1 = new Informix("GEMMAA360", "Informix/GEMMAA360");
        StringBuilder qry = new StringBuilder();

        qry.append(" UPDATE gemmaa_comportamientos_reactivos ");
        qry.append(" SET  comportamiento = '" + cre.getComportamiento() + "',reactivo ='" + cre.getReactivo() + "' ");
        qry.append(" WHERE gemmaa_comportamientos_reactivos.idcr =  " + cre.getIdCRE() + ";");

        qry.append(" UPDATE gemmaa_escala ");
        qry.append(" SET  respuesta_a = " + cre.getEscala_a() + ", respuesta_b = " + cre.getEscala_b() + ", respuesta_c = " + cre.getEscala_c() + ", respuesta_d = " + cre.getEscala_d() + " ");
        qry.append(" WHERE gemmaa_escala.idcr = " + cre.getIdCRE() + "; ");
        try {
            q1.setQrypreparaUpdate(qry.toString());
            q1.getUpdate();
        } catch (Exception ex) {

        } finally {
            q1.desconectarBD();
        }


    }

    public void actualizarRegistroAtributo(Atributo atr) {
        Informix q1 = new Informix("GEMMAA360", "Informix/GEMMAA360");
        StringBuilder qry = new StringBuilder();

        qry.append(" UPDATE gemmaa_atributos ");
        qry.append(" SET  nombre = '" + atr.getNombre() + "',descripcion ='" + atr.getDescripcion() + "' ");
        qry.append(" WHERE gemmaa_atributos.ida =  " + atr.getIdAtributo() + "; ");

        try {
            q1.setQrypreparaUpdate(qry.toString());
            q1.getUpdate();
        } catch (Exception ex) {

        } finally {
            q1.desconectarBD();
        }


    }

    public void agregarRegistroCRE(ComportamientoReactivoEscala cre) {
        Informix q1 = new Informix("GEMMAA360", "Informix/GEMMAA360");
        StringBuilder qry = new StringBuilder();

        qry.append(" INSERT INTO gemmaa_comportamientos_reactivos (idcr, ida, comportamiento, reactivo) ");
        qry.append(" VALUES ((SELECT max(idcr) + 1 FROM gemmaa_comportamientos_reactivos), " + cre.getIdAtributo() + ", '" + cre.getComportamiento() + "', '" + cre.getReactivo() + "' ); ");

        qry.append(" INSERT INTO gemmaa_escala (ide, idcr, respuesta_a, respuesta_b, respuesta_c, respuesta_d) ");
        qry.append(" VALUES ((SELECT max(ide) + 1 FROM gemmaa_escala), (SELECT max(idcr) FROM gemmaa_comportamientos_reactivos), " + cre.getEscala_a() + ", " + cre.getEscala_b() + ", " + cre.getEscala_c() + ", " + cre.getEscala_d() + " ); ");


        try {
            q1.setQrypreparaUpdate(qry.toString());
            q1.getInsert();

        } catch (Exception ex) {

        } finally {
            q1.desconectarBD();
        }


    }

    public void eliminarRegistroCRE(ComportamientoReactivoEscala cre) {
        Informix q1 = new Informix("GEMMAA360", "Informix/GEMMAA360");
        StringBuilder qry = new StringBuilder();

        qry.append(" DELETE FROM gemmaa_comportamientos_reactivos ");
        qry.append(" WHERE gemmaa_comportamientos_reactivos.idcr = " + cre.getIdCRE() + " ");

        try {
            q1.setQrypreparaUpdate(qry.toString());
            q1.getInsert();

        } catch (Exception ex) {

        } finally {
            q1.desconectarBD();
        }


    }
/*
    public void editarEncuesta(Encuesta encuesta) {
        Informix q1 = new Informix("GEMMAA", "Informix/Practicas");
        StringBuilder qry = new StringBuilder();
        qry.append(" UPDATE tipo_encuestas SET  tipo_encuestas.descripcion = '" + "prueba2" + "' where idte = 1 ");
        for (int i = 0;  i < encuesta.getResultado_esperados().size() ; i++) {
            qry.append(" UPDATE resultado_esperado ");
            qry.append(" SET resultado_esperado.descripcion = 'prueba2' ");
            qry.append(" where idte = 1 ");
           *//* for (Atributo atr : re.getAtributos()) {
                qry.append("  ");
                for (ComportamientoReactivoEscala CRE : atr.getComportamientoReactivoEscalas()) {
                    qry.append("  ");
                }
            }*//*
        }
        qry.append("  ");
        try {
            q1.setQry(qry.toString());
            q1.setPreparaUpdate();
            q1.getUpdate();
        } catch (Exception ex) {

        } finally {
            q1.desconectarBD();
        }

    }*/

}