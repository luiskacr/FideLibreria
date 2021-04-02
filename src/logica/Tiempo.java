
package logica;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Esta Clase va ha llevar el control del tiempo en el proyecto
 * @author luis_
 */
public class Tiempo {
    
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    
    /**
     * Metodo para obtener la fecha actual
     * @return la fecha Actual en formato dd/mm/yyyy
     */
    public String fechaHoy(){
        String fecha = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
        return fecha;
    }
    
}
