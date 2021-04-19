package interfaces;

import java.awt.Font;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.ImageIcon;

/**
 * En esta clase se Crean los Paquetes donde se personalizan la interfaces
 * deacuerdo a los colores y el estilo necesario para el programa
 *
 * @author luis_
 */
public class Personalizar {

    UIManager UI = new UIManager();
    
    //Colores Base de la interface
    Color fondoBg = new Color(43, 43, 43); //Gris Oscuro
    Color fondoPanel = new Color(69, 73, 74); //Gris Medio
    Color Texto = new Color(102, 102, 102); //Gris Claro

    //Iconos
    ImageIcon IError = new ImageIcon("/imagenes/usuario.png");

    public Personalizar() {

    }

    public void basico() {
        UI.put("InternalFrame.background", fondoBg);

        //Panel
        UI.put("Panel.background", fondoPanel);
        UI.put("Label.foreground", Color.white);

        //Jtexfield
        UI.put("TextField.background", Texto);
        UI.put("TextField.border", false);
        UI.put("TextField.font", new Font("Segoe Ul", Font.BOLD, 14));
        UI.put("TextField.foreground", Color.white);
        //Jpassword
        UI.put("PasswordField.background", Texto);
        UI.put("PasswordField.border", false);
        UI.put("PasswordField.font", new Font("Segoe Ul", Font.BOLD, 14));
        UI.put("PasswordField.foreground", Color.white);
        //Boton        
        UI.put("Button.background", Texto);
        UI.put("Button.border", false);
        UI.put("Button.font", new Font("Segoe Ul", Font.BOLD, 18));
        UI.put("Button.foreground", Color.white);
        //Spinner

        UI.put("Spinner.background", Texto);
        UI.put("Spinner.font", new Font("Segoe Ul", Font.BOLD, 14));
        UI.put("Spinner.foreground", Color.white);
        //Barras

        UI.put("ScrollBar.background", fondoPanel);
        UI.put("ScrollPane.background", fondoPanel);
        UI.put("ScrollBar.thumb", fondoPanel);
        UI.put("scrollbar", fondoPanel);
        UI.put("scrollbar", fondoPanel);
        
        
        //Radio Button 
        UI.put("RadioButton.background", fondoPanel);
        UI.put("RadioButton.font", new Font("Segoe Ul", Font.BOLD, 14));
        UI.put("RadioButton.foreground", Color.white);
    }
    

    /**
     * 
     */
    public void Mensajes() {
        //Propiedades de color, letra para el Joption Pane
        UI.put("OptionPane.background", fondoPanel);
        UI.put("Panel.background", fondoPanel);

        //Para los Show MessageDialog
        UI.put("OptionPane.messageFont", new Font("Segoe Ul", Font.BOLD, 16));
        UI.put("OptionPane.messageForeground", Color.white);

        //Para los Warningg
        //Warning icon 
        UI.put("OptionPane.warningIcon", IError);

        //Para los botones
        UI.put("Button.background", Texto);
        UI.put("OptionPane.buttonFont", new Font("Segoe Ul", Font.BOLD, 18));
        UI.put("Button.font", new Font("Segoe Ul", Font.BOLD, 18));
        UI.put("Button.border", javax.swing.BorderFactory.createLineBorder(Color.black));
        UI.put("Button.foreground", Color.white);

    }

    public void table() {
        UI.put("TableHeader.background", fondoPanel);
        UI.put("TableHeader.font", new Font("Segoe Ul", Font.BOLD, 16));
        UI.put("TableHeader.foreground", Color.white);

        UI.put("Table.background", Texto);
        UI.put("Table.foreground", Color.white);

        //Color de seleccion 
        UI.put("Table.selectionBackground", Color.white);
        UI.put("Table.selectionForeground", Color.black);

    }


    public void tableLineas(int datos) {
        
    }


}
