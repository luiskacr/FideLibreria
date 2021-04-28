
package logica;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * Esta Clase va ha llevar el control del tiempo en el proyecto
 * @author luis_
 */
public class Tiempo extends Thread {

  
    /**
     * Metodo para obtener la fecha actual
     * @return la fecha Actual en formato dd/mm/yyyy
     */
    public String fechaHoy(){
        //SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");    
        String fecha = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
        return fecha;
    }
    
    /**
     * Metodo para obtener la fecha actual con el Tiempo
     * @return la fecha Actual en formato dd-M-yyyy hh:mm:ss
     */
    public String FechaExacta(){
        String fecha = new SimpleDateFormat("dd-M-yyyy hh:mm:ss").format(Calendar.getInstance().getTime());
        
        return fecha;
    }
    
    public String formatoFecha(Date d){
        //SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");    
        String fechaNueva = new SimpleDateFormat("yyyy-MM-dd").format(d);
        
        return fechaNueva;
    }

}
