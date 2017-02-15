package com.cfemex.lv.is.GEMMAA.DAO;

import com.cfemex.lv.Area;
import com.cfemex.lv.Empleado;
import com.cfemex.lv.is.GEMMAA.BO.UtilBO;
import com.cfemex.lv.is.GEMMAA.Evaluado;
import com.cfemex.lv.is.GEMMAA.Ponderados;
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

    public static UtilDAO instance = null;

    public static UtilDAO getInstance() {
        if (instance == null) {
            instance = new UtilDAO();
        }
        return instance;
    }

    public Evaluado getInfoEvaluado(int nip) {
        Informix q1 = new Informix("GEMMAA360", "Informix/Libsflex");
        Evaluado ev = new Evaluado();
        ResultSet rs = null;

        StringBuilder qry = new StringBuilder();
        qry.append(" SELECT stp_emplrpenip(nip)");
        qry.append(" FROM empl ");
        qry.append(" WHERE nip = '" + nip + "'; ");

        try {
            q1.setQry(qry.toString());
            q1.setPreparaSelect();
            rs = q1.getSelect();

            while (rs.next()) {

                ev.setRpe(rs.getString(1));
            }


        } catch (Exception ex) {

        } finally {
            q1.desconectarBD();
        }
        return ev;
    }

    public String getNombreCompleto(int nip) {
        Informix q1 = new Informix("GEMMAA360", "Informix/Libsflex");
        String nombre = null;
        ResultSet rs;

        StringBuilder qry = new StringBuilder();
        qry.append(" SELECT trim(pers.appat) || ' '|| trim(pers.apmat) || ' '|| trim(pers.nombre)");
        qry.append(" FROM empl, pers ");
        qry.append(" WHERE empl.rpe = pers.rpe ");
        qry.append(" AND empl.nip = " + nip + "; ");

        try {
            q1.setQry(qry.toString());
            q1.setPreparaSelect();
            rs = q1.getSelect();

            while (rs.next()) {
                nombre = rs.getString(1);
            }


        } catch (Exception ex) {

        } finally {
            q1.desconectarBD();
        }
        return nombre;
    }
}
