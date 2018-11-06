package view_miglayout;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.ScrollPane;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import config.ConfigurationLoader;
import idao.ILanguage;
import model.Client;

import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Point;

public class Albaran extends JFrame {

	// Atributos globales.
	private ILanguage language;
	private ConfigurationLoader configLoad;
	private Client client;
	private String username;
	
	// Atributos de la clase.
	private JPanel contentPane;
	private JTable table, table_1;
	private JLabel lblAlbaran, lblCliente, lblEmpresa, lblNombreempresa, lblEmpleado, lblNombreempleado,
	 lblNombre, lblPrimerApellido, lblSegundoApellido, lblDireccion, lblCorreo, lblNombrecliente, lblPriapellido, 
	 lblSegapellido, lblDireccioncliente, lblCorreocliente;
	private JScrollPane sp, sp2;

	/**
	 * Create the frame.
	 */
	public Albaran(ConfigurationLoader configLoad, ILanguage language, String username, Client client) {
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(new MigLayout("", "[grow][grow][grow][grow]", "[][75px][50px][][][][][][50px][grow][grow]"));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 748, 596);
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		setVisible(true);
		
		this.lblAlbaran = new JLabel("ALBARAN");
		this.lblAlbaran.setFont(new Font("Tahoma", Font.BOLD, 17));
		this.contentPane.add(lblAlbaran, "cell 2 1");
		
		this.lblCliente = new JLabel("Cliente:");
		this.lblCliente.setFont(new Font("Tahoma", Font.BOLD, 15));
		this.contentPane.add(lblCliente, "cell 0 2,aligny bottom");
		
		this.lblEmpresa = new JLabel("Empresa:");
		this.lblEmpresa.setFont(new Font("Tahoma", Font.BOLD, 15));
		this.contentPane.add(lblEmpresa, "cell 2 2,aligny bottom");
		
		this.lblNombre = new JLabel("Nombre:");
		this.lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		this.contentPane.add(lblNombre, "flowx,cell 0 3");
		
		this.lblNombreempresa = new JLabel("SEAT");
		this.lblNombreempresa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.contentPane.add(lblNombreempresa, "cell 2 3");
		
		this.lblPrimerApellido = new JLabel("Primer Apellido:");
		this.lblPrimerApellido.setFont(new Font("Tahoma", Font.BOLD, 11));
		this.contentPane.add(lblPrimerApellido, "flowx,cell 0 4");
		
		this.lblEmpleado = new JLabel("Empleado:");
		this.lblEmpleado.setFont(new Font("Tahoma", Font.BOLD, 15));
		this.contentPane.add(lblEmpleado, "cell 2 4,aligny bottom");
		
		this.lblSegundoApellido = new JLabel("Segundo Apellido:");
		this.lblSegundoApellido.setFont(new Font("Tahoma", Font.BOLD, 11));
		this.contentPane.add(lblSegundoApellido, "flowx,cell 0 5");
		
		this.lblNombreempleado = new JLabel("");
		this.lblNombreempleado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.contentPane.add(lblNombreempleado, "cell 2 5");
		
		this.lblDireccion = new JLabel("Direccion:");
		this.lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 11));
		this.contentPane.add(lblDireccion, "flowx,cell 0 6");
		
		this.lblCorreo = new JLabel("Correo:");
		this.lblCorreo.setFont(new Font("Tahoma", Font.BOLD, 11));
		this.contentPane.add(lblCorreo, "flowx,cell 0 7");
		
		this.lblNombrecliente = new JLabel("");
		this.contentPane.add(lblNombrecliente, "cell 0 3");
		
		this.lblPriapellido = new JLabel("");
		this.contentPane.add(lblPriapellido, "cell 0 4");
		
		this.lblSegapellido = new JLabel("");
		this.contentPane.add(lblSegapellido, "cell 0 5");
		
		this.lblDireccioncliente = new JLabel("");
		this.contentPane.add(lblDireccioncliente, "cell 0 6");
		
		this.lblCorreocliente = new JLabel("");
		this.contentPane.add(lblCorreocliente, "cell 0 7");
		
		// JTable de las especificaciones seleccionadas anteriormente.
		this.table = new JTable();
		this.table.setModel(new DefaultTableModel(
			// Filas y columnas
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			// Encabezado de las columnas.
			new String[] {
				"Cantidad", "Especificacion", "Precio", "Informe"
			}
		));
		this.table.setBorder(new EmptyBorder(0, 0, 0, 0));
		// Para añadir los Encabezados se necesita crear un JScrollPane y añadirlo al JTable.
		this.sp = new JScrollPane();
		this.sp.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
		this.sp.setBounds(105, 127, 1120, 540);
		this.sp.setBorder(new EmptyBorder(0, 0, 0, 0));
		this.sp.setViewportView(table);
		this.contentPane.add(sp, "cell 0 9 4 1,growx");
		
		// Este JTable es para registrar todos los precios.
		this.table_1 = new JTable();
		this.table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"Precio Base", "Descuento", "Precio Total", "IVA(21%)"
			}
		));
		
		// Para los Encabezados se crea otro JScrollPane.
		this.sp2 = new JScrollPane();
		this.sp2.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
		this.sp2.setBounds(105, 127, 1120, 540);
		this.sp2.setBorder(new EmptyBorder(0, 0, 0, 0));
		this.sp2.setViewportView(table_1);
		this.table_1.getColumnModel().getColumn(1).setPreferredWidth(102);
		this.contentPane.add(sp2, "cell 0 10,grow");
	}

}
