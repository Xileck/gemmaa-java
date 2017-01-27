package com.cfemex.lv.is.GEMMAA.DAO;

import com.cfemex.lv.is.GEMMAA.RegistroBitacora;
import com.cfemex.lv.libs.informix.Informix;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JCDI on 11/11/2016.
 */
public class BitacoraDAO {
    public List<RegistroBitacora> getTodosRegistrosBitacora() {
        Informix q1 = new Informix("GEMMAA360", "Informix/GEMMAA360");
        RegistroBitacora consulta = null;
        List<RegistroBitacora> consulta_list = new ArrayList<RegistroBitacora>();
        ResultSet rs = null;

        StringBuilder qry = new StringBuilder();
        qry.append(" SELECT * from bitacorageneral where proyecto = 'GEMMAA2'");
        try {
            q1.setQry(qry.toString());
            q1.setPreparaSelect();
            rs = q1.getSelect();

            while (rs.next()) {
                consulta = new RegistroBitacora();
                consulta.setId(rs.getInt(1));
                consulta.setProyecto(rs.getString(2));
                consulta.setTablaAfectada(rs.getString(3));
                consulta.setCamposAfectados(rs.getString(4));
                consulta.setNipResponsable(rs.getInt(5));
                consulta.setIp(rs.getString(6));
                consulta.setTipoMovimiento(rs.getString(7));
                consulta.setValorAnterior(rs.getString(8));
                consulta.setValorNuevo(rs.getString(9));
                consulta.setFecha(rs.getString(10));
                consulta_list.add(consulta);
            }
        } catch (Exception ex) {

        } finally {
            q1.desconectarBD();
        }
        return consulta_list;
    }

    public void insertarRegistroBitacora(RegistroBitacora registro) {
        Informix q1 = new Informix("GEMMAA360", "Informix/GEMMAA360");
        StringBuilder qry = new StringBuilder();
        qry.append(" INSERT INTO bitacorageneral (idmovimiento, proyecto, tablaafectada, camposafectados, nipresponsablemov, ip,tipomovimiento,valoranterior,valornuevo,fechahora) ");
        qry.append(" VALUES ((SELECT MAX(idmovimiento) + 1 FROM bitacorageneral), '" + registro.getProyecto() + "', '" + registro.getTablaAfectada() + "', '" + registro.getCamposAfectados() + "', " + registro.getNipResponsable() + ", '" + registro.getIp() + "', '" + registro.getTipoMovimiento() + "','" + registro.getValorAnterior() + "','" + registro.getValorNuevo() + "',current) ");

        try {
            q1.setQrypreparaUpdate(qry.toString());
            q1.getInsert();

        } catch (Exception ex) {

        } finally {
            q1.desconectarBD();
        }
    }

}
