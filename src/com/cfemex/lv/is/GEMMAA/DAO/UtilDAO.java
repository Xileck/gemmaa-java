package com.cfemex.lv.is.GEMMAA.DAO;

import com.cfemex.lv.Area;
import com.cfemex.lv.Empleado;
import com.cfemex.lv.is.GEMMAA.Evaluado;
import com.cfemex.lv.is.apps.intranet.Empl;
import com.cfemex.lv.is.apps.intranet.EmplDAO;
import com.cfemex.lv.libs.informix.Informix;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cfemex.lv.libs.Utilerias;

/**
 * Created by cfe on 07/12/2016.
 */
public class UtilDAO {

    public Evaluado getInfoEvaluado(int nip) {
        Informix q1 = new Informix("GEMMAA360", "Informix/Libsflex");
        Evaluado ev = new Evaluado();
        ResultSet rs = null;

        StringBuilder qry = new StringBuilder();
        qry.append(" SELECT stp_emplrpenip(nip), stp_emplfoto(rpe) ");
        qry.append(" FROM empl ");
        qry.append(" WHERE nip = '" + nip + "'; ");

        try {
            q1.setQry(qry.toString());
            q1.setPreparaSelect();
            rs = q1.getSelect();

            while (rs.next()) {

                ev.setRpe(rs.getString(1));
                ev.setFoto(rs.getBytes(2));
            }


        } catch (Exception ex) {

        } finally {
            q1.desconectarBD();
        }
        return ev;
    }

    public Empl getInfoEmpleado(int nip) {
        Informix q1 = new Informix("GEMMAA360", "Informix/Libsflex");
        Empl emp = new Empl();
        ResultSet rs = null;
        EmplDAO _emplDAO = new EmplDAO();
        StringBuilder qry = new StringBuilder();
        qry.append(" SELECT e.rpe,trim(stp_emplnombre(stp_emplrpenip(p.nip))) AS persona, trim(a.descarea) AS descarea,password AS password, e.nip ");
        qry.append(" FROM empl e, pers1 p, area a ");
        qry.append(" WHERE e.cvearea = a.cvearea ");
        qry.append(" AND e.nip = p.nip ");
        qry.append(" AND p.nip = " + nip + "; ");

        try {
            q1.setQry(qry.toString());
            q1.setPreparaSelect();
            rs = q1.getSelect();

            while (rs.next()) {
                emp.setRpe(rs.getString(1));
                emp.setNombreCompleto(rs.getString(2));
                emp.setArea(rs.getString(3));
                String pass = _emplDAO.getInstance().Encriptacion(Utilerias.getValor((rs.getString(4))));
                if (pass != null && pass.length() > 0)
                    emp.setPassword(pass);
                emp.setNip(rs.getString(5));
            }
        } catch (Exception ex) {

        } finally {
            q1.desconectarBD();
        }
        return emp;
    }

    public List<Empl> getListaEmpleadosProyecto(List<Number> lista_nips) {
        Informix q1 = new Informix("GEMMAA360", "Informix/Libsflex");
        List<Empl> lista_emp = new ArrayList<Empl>();
        for (Number nip : lista_nips) {
            try {
                lista_emp.add(this.getInfoEmpleado(nip.intValue()));

            } catch (Exception ex) {

            }
        }
        return lista_emp;
    }

    public List<Number> getListaNipEmpleadosProyecto(String nombre_proyecto) {
        Informix q1 = new Informix("GEMMAA360", "Informix/Libsflex");
        List<Number> lista = new ArrayList<Number>();

        ResultSet rs = null;

        StringBuilder qry = new StringBuilder();
        qry.append(" SELECT nip ");
        qry.append(" FROM usuariosrol ");
        qry.append(" WHERE cveproy = '" + nombre_proyecto + "'; ");

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
}
