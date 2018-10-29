package view_miglayout;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;

public class Purchase_Accessories extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Purchase_Accessories frame = new Purchase_Accessories();
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
	public Purchase_Accessories() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 628, 537);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[30px][200px][60px][200px][grow]", "[45px][50px][20px][40px][40px][40px][40px][20px][40px][40px][40px][40px]"));
		
		JLabel lblCompraDeAccesorios = new JLabel("Compra de Accesorios");
		lblCompraDeAccesorios.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblCompraDeAccesorios, "cell 3 0");
		
		JLabel lblModeloDe = new JLabel("Caracteristicas seleccionadas anteriormetne.");
		lblModeloDe.setFont(new Font("Tahoma", Font.PLAIN, 17));
		contentPane.add(lblModeloDe, "cell 0 1 5 1");
		
		JCheckBox chckbxElevadurasElectricas = new JCheckBox("Elevaduras electricas");
		chckbxElevadurasElectricas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(chckbxElevadurasElectricas, "cell 1 3");
		
		JCheckBox chckbxNavegador = new JCheckBox("Navegador");
		chckbxNavegador.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(chckbxNavegador, "cell 3 3");
		
		JCheckBox chckbxYantasDeAleacion = new JCheckBox("Yantas de aleacion");
		chckbxYantasDeAleacion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(chckbxYantasDeAleacion, "cell 1 4");
		
		JCheckBox chckbxAsientosCalefactados = new JCheckBox("Asientos calefactados");
		chckbxAsientosCalefactados.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(chckbxAsientosCalefactados, "cell 3 4");
		
		JCheckBox chckbxVelocidadDeCrucero = new JCheckBox("Velocidad de crucero");
		chckbxVelocidadDeCrucero.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(chckbxVelocidadDeCrucero, "cell 1 5");
		
		JCheckBox chckbxAparcamientoAutomatico = new JCheckBox("Aparcamiento automatico");
		chckbxAparcamientoAutomatico.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(chckbxAparcamientoAutomatico, "cell 3 5");
		
		JCheckBox chckbxConectoresUsb = new JCheckBox("Conectores USB");
		chckbxConectoresUsb.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(chckbxConectoresUsb, "cell 1 6");
		
		JCheckBox chckbxPinturaMetalizada = new JCheckBox("Pintura metalizada");
		chckbxPinturaMetalizada.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(chckbxPinturaMetalizada, "cell 3 6");
		
		JLabel lblPrecioBasee = new JLabel("Precio Base:");
		lblPrecioBasee.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblPrecioBasee, "cell 1 8,alignx left,aligny center");
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setText("0");
		textField.setOpaque(false);
		contentPane.add(textField, "cell 3 8,growx,aligny center");
		textField.setColumns(10);
		
		JLabel lblAumentoEnEl = new JLabel("Aumento en el precio:");
		lblAumentoEnEl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblAumentoEnEl, "cell 1 9,alignx left,aligny center");
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setText("0");
		textField_1.setOpaque(false);
		contentPane.add(textField_1, "cell 3 9,growx");
		textField_1.setColumns(10);
		
		JLabel lblTotalPrecio = new JLabel("Total precio:");
		lblTotalPrecio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblTotalPrecio, "cell 1 10,alignx left,aligny center");
		
		// Esta parte del codigo sirve para sumar los dos campos de precios y mostrar el total.
		// Solo se puede mostrar en forma de String por lo que se deben pasar los valores de formato.
		String pb = textField.getText();
		int numero1 = Integer.parseInt(pb);
		String ap = textField_1.getText();
		int numero2 = Integer.parseInt(ap);
		int resultado = numero1 + numero2;
		String resultSt = Integer.toString(resultado);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_2.setText(resultSt); // Resultado do los dos campos.
		textField_2.setOpaque(false);
		contentPane.add(textField_2, "cell 3 10,growx");
		textField_2.setColumns(10);
		
		JButton btnAtras = new JButton("ATRAS");
		contentPane.add(btnAtras, "cell 1 11,growx");
		
		JButton btnFinalizar = new JButton("FINALIZAR");
		contentPane.add(btnFinalizar, "cell 3 11,growx");
	}

}
