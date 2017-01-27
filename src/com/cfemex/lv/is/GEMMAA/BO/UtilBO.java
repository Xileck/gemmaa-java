package com.cfemex.lv.is.GEMMAA.BO;

import com.cfemex.lv.is.GEMMAA.DAO.UtilDAO;
import com.cfemex.lv.is.GEMMAA.Evaluado;

/**
 * Created by cfe on 07/12/2016.
 */
public class UtilBO {
    public static UtilDAO _utilDAO = new UtilDAO();

    public Evaluado getInfoEvaluado(int nip){
        return _utilDAO.getInfoEvaluado(nip);
    }
}
