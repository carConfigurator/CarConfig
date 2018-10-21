/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;

/**
 *
 * @author TNB-20
 */
public class DatosCliente_NB extends javax.swing.JFrame {

    /**
     * Creates new form DatosCliente
     */
    public DatosCliente_NB() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        lblNombreUser = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        tfNombre = new javax.swing.JTextField();
        lblPriApellido = new javax.swing.JLabel();
        tfPriApellido = new javax.swing.JTextField();
        lblSegApellido = new javax.swing.JLabel();
        tfSecApellido = new javax.swing.JTextField();
        lblDireccion = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        lblGenero = new javax.swing.JLabel();
        tfDireccion = new javax.swing.JTextField();
        tfCorreo = new javax.swing.JTextField();
        rbHombre = new javax.swing.JRadioButton();
        rbMujer = new javax.swing.JRadioButton();
        rbNulo = new javax.swing.JRadioButton();
        lblFecha = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Concesionario ESTEVE");
        setIconImage(getIconImage());

        lblTitulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTitulo.setText("DATOS DEL CLIENTE");

        lblUsuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblUsuario.setText("Usuario:");

        lblNombreUser.setFont(new java.awt.Font("Tahoma", 0, 12));
        lblNombreUser.setText("-----");
        //Login l = new Login();
        //lblNombreUser.setText(l.getNombre());

        lblNombre.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lblNombre.setText("Nombre *");

        lblPriApellido.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lblPriApellido.setText("Primer Apellido *");

        tfPriApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPriApellidoActionPerformed(evt);
            }
        });

        lblSegApellido.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lblSegApellido.setText("Segundo Apellido *");

        tfSecApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSecApellidoActionPerformed(evt);
            }
        });

        lblDireccion.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lblDireccion.setText("Direccion *");

        lblCorreo.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lblCorreo.setText("Correo electronico *");

        lblGenero.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lblGenero.setText("Genero");

        tfDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDireccionActionPerformed(evt);
            }
        });

        rbHombre.setText("Hombre");
        rbHombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbHombreActionPerformed(evt);
            }
        });

        rbMujer.setText("Mujer");

        rbNulo.setSelected(true);
        rbNulo.setText("No determinado");

        lblFecha.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lblFecha.setText("Fecha Nacimiento");

        btnGuardar.setText("GUARDAR");
        // FUNCIONES PARA GUARDAR LA INFORMACION DE LOS CLIENTES.
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //  Filtro para rellenar todos los campos obligatorios.
                if (tfNombre.getText() == null || tfPriApellido.getText() == null || tfSecApellido.getText() == null || tfDireccion.getText() == null || tfCorreo.getText() == null){
                    JOptionPane.showMessageDialog(null, "Faltan campos por rellenar. Rellene todos los campos obligatorios.", "Informacion Incompleta", JOptionPane.ERROR_MESSAGE);
                };
                //  Filtro para que el correo sea valido busqcando en el contenido de este un "@".
                String email = (String)tfCorreo.getText();
                if (!email.equals(email) && email.equals("@")){
                    JOptionPane.showMessageDialog(null, "Debe poner un correo valido.");
                };
                //  Filtro para que tenga un minimo de caracteres todos los TextArea.
                if (tfNombre.getText().length() < 1 || tfPriApellido.getText().length() < 1 || tfSecApellido.getText().length() < 1 || tfDireccion.getText().length() < 1 || tfCorreo.getText().length() < 1){
                    JOptionPane.showMessageDialog(null, "Cantidad de caracteres insuficientes.", "Error de caracteres", JOptionPane.ERROR_MESSAGE);
                };
                //  Filtro para que el primer caracter de cada TextArea no sea un Espacio en blanco.
                if(String.valueOf(tfNombre.getText().charAt(0)).equals(" ") || String.valueOf(tfPriApellido.getText().charAt(0)).equals(" ") || String.valueOf(tfSecApellido.getText().charAt(0)).equals(" ") || String.valueOf(tfDireccion.getText().charAt(0)).equals(" ") || String.valueOf(tfCorreo.getText().charAt(0)).equals(" ")) {
                    JOptionPane.showMessageDialog(null,"El primer caracter no puede estar en blanco.", "Error de caracteres", JOptionPane.ERROR_MESSAGE);
                };
            }
        });

        btnSiguiente.setText("SIGUIENTE");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(lblTitulo)
                .addGap(110, 110, 110)
                .addComponent(lblUsuario)
                .addGap(7, 7, 7)
                .addComponent(lblNombreUser))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblNombre)
                .addGap(135, 135, 135)
                .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblPriApellido)
                .addGap(94, 94, 94)
                .addComponent(tfPriApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblSegApellido)
                .addGap(79, 79, 79)
                .addComponent(tfSecApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblDireccion)
                .addGap(130, 130, 130)
                .addComponent(tfDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblCorreo)
                .addGap(71, 71, 71)
                .addComponent(tfCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblGenero)
                    .addComponent(lblFecha))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rbHombre)
                        .addGap(7, 7, 7)
                        .addComponent(rbMujer)
                        .addGap(7, 7, 7)
                        .addComponent(rbNulo))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUsuario)
                            .addComponent(lblNombreUser))))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombre)
                    .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPriApellido)
                    .addComponent(tfPriApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSegApellido)
                    .addComponent(tfSecApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDireccion)
                    .addComponent(tfDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCorreo)
                    .addComponent(tfCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblGenero)
                    .addComponent(rbHombre)
                    .addComponent(rbMujer)
                    .addComponent(rbNulo))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(lblFecha))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardar)
                    .addComponent(btnSiguiente)))
        );

        ButtonGroup bg = new ButtonGroup();
        bg.add(rbHombre);
        bg.add(rbMujer);
        bg.add(rbNulo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfPriApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPriApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPriApellidoActionPerformed

    private void tfDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfDireccionActionPerformed

    private void rbHombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbHombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbHombreActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void tfSecApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSecApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSecApellidoActionPerformed

    public Image getIconImage() {
    	File image = new File("src/config/favicon.png");
        Image retValue = Toolkit.getDefaultToolkit().getImage(image.getAbsolutePath());
        return retValue;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DatosCliente_NB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DatosCliente_NB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DatosCliente_NB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DatosCliente_NB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DatosCliente_NB().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnSiguiente;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblGenero;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombreUser;
    private javax.swing.JLabel lblPriApellido;
    private javax.swing.JLabel lblSegApellido;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JRadioButton rbHombre;
    private javax.swing.JRadioButton rbMujer;
    private javax.swing.JRadioButton rbNulo;
    private javax.swing.JTextField tfCorreo;
    private javax.swing.JTextField tfDireccion;
    private javax.swing.JTextField tfNombre;
    private javax.swing.JTextField tfPriApellido;
    private javax.swing.JTextField tfSecApellido;
    // End of variables declaration//GEN-END:variables
}
