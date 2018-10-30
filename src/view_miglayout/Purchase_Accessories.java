package view_miglayout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import config.ConfigurationLoader;
import daoImplFactory.LanguageFactory;
import idao.ILanguage;
import model.Client;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;

public class Purchase_Accessories extends JFrame {

	// Atributos de la Clase:
	private ILanguage language;
	private ConfigurationLoader configLoad;
	private Client client;
	private String username;
	
	JPanel contentPane;
	JLabel lblTitulo, lblModeloCoche, lblPrecioBasee, lblAumento, lblTotalPrecio;
	JTextField tfAumento, tfTotalPrecio, tfPrecioBase;
	JCheckBox cbElevadurasElectricas, cbNavegador, cbLlantasAl, cbAsientosCal, cbVelCrucero, cbAparcamietnoAuto, cbConectorUSB, cbPinturaMetal;
	JButton btnAtras, btnFinalizar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfigurationLoader configLoad = ConfigurationLoader.getConfigurationLoaderInstance();
					ILanguage language = LanguageFactory.getLanguage(configLoad.getLanguage_default(), configLoad);
					String username = "user1";
					Purchase_Accessories frame = new Purchase_Accessories(configLoad, language, username);
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
	public Purchase_Accessories(ConfigurationLoader configLoad, ILanguage language, String username) {
		this.language = language;
		this.configLoad = configLoad;
		this.username = username;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 537);
		contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setBackground(new Color(255,255,255));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[30px][200px][60px][200px][grow]", "[45px][50px][20px][40px][40px][40px][40px][20px][40px][40px][40px][60px]"));
		
		this.lblTitulo = new JLabel("Compra de Accesorios");
		this.lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.contentPane.add(lblTitulo, "cell 3 0");
		
		this.lblModeloCoche = new JLabel("Caracteristicas seleccionadas anteriormetne.");
		this.lblModeloCoche.setFont(new Font("Tahoma", Font.PLAIN, 17));
		this.contentPane.add(lblModeloCoche, "cell 0 1 5 1");
		
		this.cbElevadurasElectricas = new JCheckBox("Elevaduras electricas");
		this.cbElevadurasElectricas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.cbElevadurasElectricas.setBackground(new Color(255,255,255));
		this.cbElevadurasElectricas.setFocusable(false);
		this.contentPane.add(cbElevadurasElectricas, "cell 1 3");
		
		this.cbNavegador = new JCheckBox("Navegador");
		this.cbNavegador.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.cbNavegador.setBackground(new Color(255,255,255));
		this.cbNavegador.setFocusable(false);
		this.contentPane.add(cbNavegador, "cell 3 3");
		
		this.cbLlantasAl = new JCheckBox("Llantas de aleacion");
		this.cbLlantasAl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.cbLlantasAl.setBackground(new Color(255,255,255));
		this.cbLlantasAl.setFocusable(false);
		this.contentPane.add(cbLlantasAl, "cell 1 4");
		
		this.cbAsientosCal = new JCheckBox("Asientos calefactados");
		this.cbAsientosCal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.cbAsientosCal.setBackground(new Color(255,255,255));
		this.cbAsientosCal.setFocusable(false);
		this.contentPane.add(cbAsientosCal, "cell 3 4");
		
		this.cbVelCrucero = new JCheckBox("Velocidad de crucero");
		this.cbVelCrucero.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.cbVelCrucero.setBackground(new Color(255,255,255));
		this.cbVelCrucero.setFocusable(false);
		this.contentPane.add(cbVelCrucero, "cell 1 5");
		
		this.cbAparcamietnoAuto = new JCheckBox("Aparcamiento automatico");
		this.cbAparcamietnoAuto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.cbAparcamietnoAuto.setBackground(new Color(255,255,255));
		this.cbAparcamietnoAuto.setFocusable(false);
		this.contentPane.add(cbAparcamietnoAuto, "cell 3 5");
		
		this.cbConectorUSB = new JCheckBox("Conectores USB");
		this.cbConectorUSB.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.cbConectorUSB.setBackground(new Color(255,255,255));
		this.cbConectorUSB.setFocusable(false);
		this.contentPane.add(cbConectorUSB, "cell 1 6");
		
		this.cbPinturaMetal = new JCheckBox("Pintura metalizada");
		this.cbPinturaMetal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.cbPinturaMetal.setBackground(new Color(255,255,255));
		this.cbPinturaMetal.setFocusable(false);
		this.contentPane.add(cbPinturaMetal, "cell 3 6");
		
		this.lblPrecioBasee = new JLabel("Precio Base:");
		this.lblPrecioBasee.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.contentPane.add(lblPrecioBasee, "cell 1 8,alignx left,aligny center");
		
		this.tfPrecioBase = new JTextField();
		this.tfPrecioBase.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.tfPrecioBase.setText("0");
		this.tfPrecioBase.setOpaque(false);
		this.contentPane.add(tfPrecioBase, "cell 3 8,growx,aligny center");
		this.tfPrecioBase.setColumns(10);
		
		this.lblAumento = new JLabel("Aumento en el precio:");
		this.lblAumento.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.contentPane.add(lblAumento, "cell 1 9,alignx left,aligny center");
		
		this.tfAumento = new JTextField();
		this.tfAumento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.tfAumento.setText("0");
		this.tfAumento.setOpaque(false);
		this.contentPane.add(tfAumento, "cell 3 9,growx");
		this.tfAumento.setColumns(10);
		
		this.lblTotalPrecio = new JLabel("Total precio:");
		this.lblTotalPrecio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.contentPane.add(lblTotalPrecio, "cell 1 10,alignx left,aligny center");
		
		// Esta parte del codigo sirve para sumar los dos campos de precios y mostrar el total.
		// Solo se puede mostrar en forma de String por lo que se deben pasar los valores de formato.
		String pb = tfPrecioBase.getText();
		int numero1 = Integer.parseInt(pb);
		String ap = tfAumento.getText();
		int numero2 = Integer.parseInt(ap);
		int resultado = numero1 + numero2;
		String resultSt = Integer.toString(resultado);
		
		this.tfTotalPrecio = new JTextField();
		this.tfTotalPrecio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.tfTotalPrecio.setText(resultSt); // Resultado do los dos campos.
		this.tfTotalPrecio.setOpaque(false);
		this.contentPane.add(tfTotalPrecio, "cell 3 10,growx");
		this.tfTotalPrecio.setColumns(10);
		
		this.btnAtras = new JButton("ATRAS");
		this.btnAtras.setBackground(new Color(215,18,43));
		this.btnAtras.setForeground(new Color(255,255,255));
		this.btnAtras.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(215, 18, 43)),
				BorderFactory.createEmptyBorder(5,10,5,10)));
		this.contentPane.add(btnAtras, "cell 1 11,growx");
		
		this.btnFinalizar = new JButton("FINALIZAR");
		this.btnFinalizar.setBackground(new Color(215,18,43));
		this.btnFinalizar.setForeground(new Color(255,255,255));
		this.btnFinalizar.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(215, 18, 43)),
				BorderFactory.createEmptyBorder(5,10,5,10)));
		this.contentPane.add(btnFinalizar, "cell 3 11,growx");
	}

}
