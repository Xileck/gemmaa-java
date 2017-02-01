package com.cfemex.lv.is.GEMMAA.BO;

import com.cfemex.lv.is.GEMMAA.DAO.BitacoraDAO;
import com.cfemex.lv.is.GEMMAA.RegistroBitacora;

import java.util.List;

/**
 * Created by cfe on 14/11/2016.
 */
public class BitacoraBO {

    public List<RegistroBitacora> getCatalogoEncuesta() {
        return BitacoraDAO.getInstance().getTodosRegistrosBitacora();
    }

    public void insertarRegistroBitacora(RegistroBitacora registro) {
        BitacoraDAO.getInstance().insertarRegistroBitacora(registro);
    }
}
