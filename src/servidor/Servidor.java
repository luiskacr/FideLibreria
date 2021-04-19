package servidor;

import java.awt.Color;
import java.awt.Font;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import logica.Tiempo;
import logica.Conexion;

/**
 *
 * @author luis_
 */
public class Servidor {

    public static void main(String[] args) throws InterruptedException {
        graficos graficos = new graficos();

    }
}

class graficos extends JFrame implements Runnable {

    Tiempo tiempo = new Tiempo();
    JTextArea areaTexto;
    JTextArea areaErrores;

    public graficos() throws InterruptedException {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        areaTexto = new JTextArea();
        areaTexto.setBounds(0, 0, 1200, 600);
        areaTexto.setForeground(Color.GREEN);
        areaTexto.setBackground(Color.BLACK);
        areaTexto.setFont(new Font("Arial", Font.PLAIN, 20));
        areaTexto.setEditable(false);
        areaTexto.setText("Iniciando Servidor de Correos Automaticos");
        add(panel);

        areaErrores = new JTextArea();
        areaErrores.setBounds(0, 600, 1200, 200);
        areaErrores.setBackground(Color.WHITE);
        areaErrores.setForeground(Color.RED);
        areaErrores.setFont(new Font("Arial", Font.BOLD, 15));
        areaErrores.setText("Consola de Errores");
        areaErrores.setEditable(false);

        panel.add(areaTexto);
        panel.add(areaErrores);

        ImageIcon icono = new ImageIcon("src/imagenes/Server-icon.png");
        setIconImage(icono.getImage());
        setSize(1200, 800);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Consola: Servidor de Correos Automaticos");

        inicio();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Thread hilo = new Thread(this);
        hilo.start();
    }

    @Override
    public void run() {
        ServerSocket servidor = null;
        Socket sc = null;
        DataInputStream in;
        DataOutputStream out;
        final int puerto = 9000;
        areaTexto.append("Servidor en Estado:Activo");

        areaTexto.append("\nEn espera del cliente:");
        try {
            servidor = new ServerSocket(puerto);

            while (true) {
                areaTexto.append("\n");
                sc = servidor.accept();
                areaTexto.append("\n" + "Cliente conectado");
                in = new DataInputStream(sc.getInputStream());
                out = new DataOutputStream(sc.getOutputStream());

                String mensaje = in.readUTF();

                enviarCorreo(mensaje);

                sc.close();
                areaTexto.append("\n" + "Cliente desconectado");
            }

        } catch (Exception e) {
            areaErrores.append("\n" + tiempo.FechaExacta() + " Error en Coneccion con el cliente  " + e.getMessage() );
        }

    }

    private void inicio() throws InterruptedException {
        try {
            Thread hilo2 = new Thread(this);
            hilo2.sleep(1000);
            areaTexto.append("\nConectador con Servidor de Correo");
            hilo2.sleep(1000);
            areaTexto.append("\nROOT@ServidorCorreos:$ Iniciando Servicio");
            hilo2.sleep(1000);
            areaTexto.append("\nROOT@ServidorCorreos:$ Cargando Servicio");
            for (int i = 0; i < 15; i++) {
                hilo2.sleep(300);
                areaTexto.append(".");
            }
            hilo2.sleep(1000);
            areaTexto.append("\nROOT@ServidorCorreos:$ Servicio Iniciado");
            hilo2.sleep(1000);
            areaTexto.setText("");
        } catch (Exception e) {
            areaErrores.append("\n" + tiempo.FechaExacta() + " Error al Iniciar el Servidor  " + e.getMessage());
        }

    }

    private void enviarCorreo(String mensaje) {

        try {
            String[] datos = mensaje.split(",");
            int ced = Integer.parseInt(datos[0]);
            String nombre = datos[1];
            String apellido = datos[2];
            String correo = datos[3];
            String usuario = datos[4];
            String pass = generaContrasena();

            guardaPass(ced, pass);

            //Se imprime el correo.
            System.out.println("De:Fidelibros@correo.com"
                    + "\nPara: " + correo
                    + "\nAsunto Creacion de Usuario y Contraseña Temporal"
                    + "\n"
                    + "\nEstimado Cliente: " + nombre + " " + apellido
                    + "\nLe informamos que Genero el usuario:" + usuario + " con la Contraseña:" + pass
                    + "\nLe Agradecemos ingresar a http://fidelibro.com/acceso antes de 24 Horas, Caso contrario expirara la Contraseña"
            );

            areaTexto.append("\n" + tiempo.FechaExacta() + " Se enviar Correo a " + correo + " Cliente: " + nombre + " " + apellido);

        } catch (Exception e) {
            areaErrores.append("\n" + tiempo.FechaExacta() + " Error al enviar Correo  " + e.getMessage());
        }

    }

    private void guardaPass(int ced, String pass) {
        Connection con;
        Conexion cn = new Conexion();
        PreparedStatement ps;
        ResultSet rs;
        int r = 0;

        try {
            String sql = "UPDATE cliente set contrasena=? WHERE cedCliente=?";

            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, pass);
            ps.setInt(2, ced);

            r = ps.executeUpdate();
        } catch (Exception e) {
            areaErrores.append("\n" + tiempo.FechaExacta() + " Error al Conectar con la Base de Datos  " + e.getMessage());
        }
    }

    private String generaContrasena() {
        String nuevoPass = "";
        final String numeros = "0123456789";
        final String mayusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String minisculas = "abcdefghijklmnopqrstuvwxyz";
        try {

            for (int i = 0; i < 8; i++) {
                int cod = (int) (Math.random() * 3);
                if (cod == 1) {
                    nuevoPass += numeros.charAt((int) (Math.random() * 8));
                } else if (cod == 2) {
                    nuevoPass += mayusculas.charAt((int) (Math.random() * 24));
                } else {
                    nuevoPass += minisculas.charAt((int) (Math.random() * 24));
                }
            }
            nuevoPass.replace(" ", "");

            areaTexto.append("\nSe Genera una Contraseña Temporal");
            return nuevoPass;
        } catch (Exception e) {
            areaErrores.append("\n" + tiempo.FechaExacta() + " Error al Generar Contraseña  " + e.getMessage());
        }
        return nuevoPass;
    }

}
