package com.cfemex.lv.is.GEMMAA.BO;

import com.cfemex.lv.is.GEMMAA.DAO.SeguridadDAO;

/**
 * Created by cfe on 27/01/2017.
 */
public class SeguridadBO {

    private static SeguridadBO instance = null;

    public static SeguridadBO getInstance() {
        if (instance == null) {
            instance = new SeguridadBO();
        }
        return instance;
    }

    public boolean empleadoExisteEnProyectoNip(int nip, String proyecto) {
        return SeguridadDAO.getInstance().empleadoExisteEnProyectoNip(nip, proyecto);
    }

    public boolean empleadoExisteEnProyectoRPE(String rpe, String proyecto) {
        return SeguridadDAO.getInstance().empleadoExisteEnProyectoRPE(rpe, proyecto);
    }

    public String getPasswordIntraUsuario_viaNip(int nip) {
        return SeguridadDAO.getInstance().getPasswordIntraUsuario(nip);
    }
    public String getPasswordIntraUsuario_viaRpe(String rpe) {
        return SeguridadDAO.getInstance().getPasswordIntraUsuario(rpe);
    }

}
