/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import javax.swing.JOptionPane;

/**
 *
 * @author luis_
 */
public class Notificaciones extends JOptionPane {

    Personalizar graficos = new Personalizar();

    /**
     * Joption Pane de mensaje de error personalizado, boton Ok
     *
     * @param mensaje El mensaje que se pasa por parametro para mostrar en el
     * Joption Pane
     */
    public void error(String mensaje) {
        graficos.Mensajes();
        showMessageDialog(null, mensaje, "ERROR", 0);
    }

    /**
     * Mensaje de alerta para confimar un paso a proceder
     *
     * @param mensaje Es el mensaje de la caja
     * @param titulo Es el titulo de la caja
     * @return True si lo acepta o False si lo rechaza o cancela
     */
    public boolean confirmar(String mensaje, String titulo) {
        graficos.Mensajes();
        String[] botones = {"Si", "No", "Cancelar"};
        try {
            int input = showOptionDialog(null, mensaje, titulo, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, botones, botones[0]);
            //0=si, 1=no, 2=cancelar
            if (input == 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 
     * Mensaje de pregunta Si o NO
     * 
     * @param mensaje Es el mensaje de la caja
     * @param titulo Es el titulo de la caja
     * @return True si lo acepta o False si lo rechaza o cancela
     */
    public boolean SioNo(String mensaje, String titulo) {
        graficos.Mensajes();
        String[] botones = {"Si", "No"};
        try {
            int input = showOptionDialog(null, mensaje, titulo, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, botones, botones[0]);
            //0=si, 1=no, 2=cancelar
            if (input == 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Metodo para preguntar un numero que solo acepta numero enteros como
     * respuesta
     *
     * @param pregunta El mensaje a incluir en la caja
     * @param tipoPregunta Es el que estamos Preguntando para devolver como
     * error
     * @return El numero consultado
     */
    public int pregundaNumero(String pregunta, String tipoPregunta) {
        graficos.Mensajes();
        try {
            int numeroConsulta = Integer.parseInt(showInputDialog(null, pregunta));
            return numeroConsulta;
        } catch (Exception e) {

            error("Lo incluido no corresponde a " + tipoPregunta);
            return -1000;
        }

    }
    
    /**
     * Metodo que muestra una caja de notificacion de un mensaje
     * 
     * @param mensaje String con mensaje a mostrar en la caja
     */
    public void notificar(String mensaje) {
        graficos.Mensajes();
        showMessageDialog(null, mensaje);

    }
}
