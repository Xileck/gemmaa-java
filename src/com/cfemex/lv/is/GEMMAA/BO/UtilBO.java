package com.cfemex.lv.is.GEMMAA.BO;

import com.cfemex.lv.is.GEMMAA.DAO.UtilDAO;
import com.cfemex.lv.is.GEMMAA.Evaluado;
import com.cfemex.lv.is.GEMMAA.Ponderados;
import com.cfemex.lv.is.apps.intranet.Empl;

import java.util.List;

/**
 * Created by cfe on 07/12/2016.
 */
public class UtilBO {
    public static UtilBO instance = null;

    public static UtilBO getInstance() {
        if (instance == null) {
            instance = new UtilBO();
        }
        return instance;
    }

    public Evaluado getInfoEvaluado(int nip) {
        return UtilDAO.getInstance().getInfoEvaluado(nip);
    }

    public String getNombreCompleto(int nip) {
        return UtilDAO.getInstance().getNombreCompleto(nip);
    }

}
