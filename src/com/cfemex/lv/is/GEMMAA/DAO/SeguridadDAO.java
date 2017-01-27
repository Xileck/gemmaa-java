package com.cfemex.lv.is.GEMMAA.DAO;
import com.cfemex.lv.is.apps.intranet.EmplDAO;
import com.cfemex.lv.libs.Utilerias;
import com.cfemex.lv.libs.informix.Informix;

import java.sql.ResultSet;

/**
 * Created by cfe on 27/01/2017.
 */
public class SeguridadDAO {
    private static SeguridadDAO instance = null;

    public static SeguridadDAO getInstance() {
        if (instance == null) {
            instance = new SeguridadDAO();
        }
        return instance;
    }

    public boolean empleadoExisteEnProyectoNip(int nip, String proyecto) {
        Informix q1 = new Informix("GEMMAA360", "Informix/Libsflex");
        Boolean existe = false;

        ResultSet rs;
        StringBuilder qry = new StringBuilder();
        qry.append(" SELECT nip ");
        qry.append(" FROM usuariosrol ");
        qry.append(" WHERE nip = " + nip + " ");
        qry.append(" AND cveproy = '" + proyecto + "'; ");

        try {
            q1.setQry(qry.toString());
            q1.setPreparaSelect();
            rs = q1.getSelect();

            if (rs.next()) {
                existe = true;
            }
        } catch (Exception ex) {
        }
        return existe;
    }

    public boolean empleadoExisteEnProyectoRPE(String rpe, String proyecto) {
        Informix q1 = new Informix("GEMMAA360", "Informix/Libsflex");
        Boolean existe = false;

        ResultSet rs;
        StringBuilder qry = new StringBuilder();
        qry.append(" SELECT nip ");
        qry.append(" FROM usuariosrol ");
        qry.append(" WHERE nip = stp_emplniprpe('" + rpe.toUpperCase() + "') ");
        qry.append(" AND cveproy = '" + proyecto + "'; ");

        try {
            q1.setQry(qry.toString());
            q1.setPreparaSelect();
            rs = q1.getSelect();

            if (rs.next()) {
                existe = true;
            }
        } catch (Exception ex) {
        }
        return existe;
    }

    public String getPasswordIntraUsuario(int nip) {
        Informix q1 = new Informix("GEMMAA360", "Informix/Libsflex");
        String password = null;
        ResultSet rs;
        StringBuilder qry = new StringBuilder();
        qry.append(" SELECT password AS password ");
        qry.append(" FROM empl ");
        qry.append(" WHERE empl.nip = " + nip + "; ");

        try {
            q1.setQry(qry.toString());
            q1.setPreparaSelect();
            rs = q1.getSelect();

            while (rs.next()) {
                password = EmplDAO.getInstance().Encriptacion(Utilerias.getValor((rs.getString(1))));
            }
        } catch (Exception ex) {
        }
        return password;
    }

    public String getPasswordIntraUsuario(String rpe) {
        Informix q1 = new Informix("GEMMAA360", "Informix/Libsflex");
        String password = null;

        ResultSet rs;
        StringBuilder qry = new StringBuilder();
        qry.append(" SELECT password AS password ");
        qry.append(" FROM empl ");
        qry.append(" WHERE nip = stp_emplniprpe('" + rpe.toUpperCase() + "'); ");

        try {
            q1.setQry(qry.toString());
            q1.setPreparaSelect();
            rs = q1.getSelect();

            while (rs.next()) {
                password = EmplDAO.getInstance().Encriptacion(Utilerias.getValor((rs.getString(1))));
            }
        } catch (Exception ex) {
        }
        return password;
    }

}
