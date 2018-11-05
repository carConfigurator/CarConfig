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
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Point;

public class Albaran extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel lblAlbaran;
	private JLabel lblCliente;
	private JLabel lblEmpresa;
	private JLabel lblNombreempresa;
	private JLabel lblEmpleado;
	private JLabel lblNombreempleado;
	private JLabel lblNombre;
	private JLabel lblPrimerApellido;
	private JLabel lblSegundoApellido;
	private JLabel lblDireccion;
	private JLabel lblCorreo;
	private JLabel lblNombrecliente;
	private JLabel lblPriapellido;
	private JLabel lblSegapellido;
	private JLabel lblDireccioncliente;
	private JLabel lblCorreocliente;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Albaran frame = new Albaran();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Albaran() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 748, 596);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		// pack();
		// setLocationRelativeTo(null);
		contentPane.setLayout(new MigLayout("", "[grow][grow][grow][grow]", "[][75px][50px][][][][][][50px][grow][grow]"));
		
		lblAlbaran = new JLabel("ALBARAN");
		lblAlbaran.setFont(new Font("Tahoma", Font.BOLD, 17));
		contentPane.add(lblAlbaran, "cell 2 1");
		
		lblCliente = new JLabel("Cliente:");
		lblCliente.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblCliente, "cell 0 2,aligny bottom");
		
		lblEmpresa = new JLabel("Empresa:");
		lblEmpresa.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblEmpresa, "cell 2 2,aligny bottom");
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblNombre, "flowx,cell 0 3");
		
		lblNombreempresa = new JLabel("SEAT");
		lblNombreempresa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(lblNombreempresa, "cell 2 3");
		
		lblPrimerApellido = new JLabel("Primer Apellido:");
		lblPrimerApellido.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblPrimerApellido, "flowx,cell 0 4");
		
		lblEmpleado = new JLabel("Empleado:");
		lblEmpleado.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblEmpleado, "cell 2 4,aligny bottom");
		
		lblSegundoApellido = new JLabel("Segundo Apellido:");
		lblSegundoApellido.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblSegundoApellido, "flowx,cell 0 5");
		
		lblNombreempleado = new JLabel("");
		lblNombreempleado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(lblNombreempleado, "cell 2 5");
		
		lblDireccion = new JLabel("Direccion:");
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblDireccion, "flowx,cell 0 6");
		
		lblCorreo = new JLabel("Correo:");
		lblCorreo.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblCorreo, "flowx,cell 0 7");
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
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
			new String[] {
				"Cantidad", "Especificacion", "Precio", "Informe"
			}
		));
		table.setBorder(new EmptyBorder(0, 0, 0, 0));
		JScrollPane sp = new JScrollPane();
		sp.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
		sp.setBounds(105, 127, 1120, 540);
		sp.setBorder(new EmptyBorder(0, 0, 0, 0));
		sp.setViewportView(table);
		contentPane.add(sp, "cell 0 9 4 1,growx");
		
		lblNombrecliente = new JLabel("");
		contentPane.add(lblNombrecliente, "cell 0 3");
		
		lblPriapellido = new JLabel("");
		contentPane.add(lblPriapellido, "cell 0 4");
		
		lblSegapellido = new JLabel("");
		contentPane.add(lblSegapellido, "cell 0 5");
		
		lblDireccioncliente = new JLabel("");
		contentPane.add(lblDireccioncliente, "cell 0 6");
		
		lblCorreocliente = new JLabel("");
		contentPane.add(lblCorreocliente, "cell 0 7");
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"Precio Base", "Descuento", "Precio Total", "IVA(21%)"
			}
		));
		JScrollPane sp2 = new JScrollPane();
		sp2.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
		sp2.setBounds(105, 127, 1120, 540);
		sp2.setBorder(new EmptyBorder(0, 0, 0, 0));
		sp2.setViewportView(table_1);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(102);
		contentPane.add(sp2, "cell 0 10,grow");
	}

}
