import com.cfemex.lv.is.GEMMAA.BO.BitacoraBO;
import com.cfemex.lv.is.GEMMAA.BO.EncuestaBO;
import com.cfemex.lv.is.GEMMAA.DAO.EncuestaDAO;
import com.cfemex.lv.is.GEMMAA.Encuesta;
import com.cfemex.lv.is.GEMMAA.RegistroBitacora;

import java.util.List;

/**
 * Created by JCDI on 31/10/2016.
 */
public class Test {
    public static EncuestaDAO edao = new EncuestaDAO();
    public static EncuestaBO ebo = new EncuestaBO();
    public static BitacoraBO bbo = new BitacoraBO();

    public static void main(String[] args) {
        int id = 4;
        Encuesta encuesta = new Encuesta();
        encuesta.setNombre("Prueba encuesta");
        encuesta = ebo.getEncuesta(1);
        encuesta.setIdEncuesta(7);
        edao.crearNuevaEncuesta(encuesta);
       /* edao.setResultadosEsperadosEncuesta(id, encuesta);
        edao.setAtributosEncuesta(id, encuesta);
        edao.setComportamientosReactivosEscala(id, encuesta);
        edao.setComportamientosReactivosEscala(id, encuesta);
        bo.getEncuesta(id);
        edao.createNewEncuesta(encuesta);*/
    }
}
