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
	private JLabel username;
	
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
					ILanguage language = LanguageFactory.getLanguage(configLoad);
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
		this.username = new JLabel(username);
		this.username.setFont(new Font("Tahoma", 0, 11));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 537);
		contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setBackground(new Color(255,255,255));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("insets 35"));
		
<<<<<<< HEAD
		this.lblTitulo = new JLabel("Compra de Accesorios");
		this.lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		this.lblModeloCoche = new JLabel("Caracteristicas seleccionadas anteriormente.");
		this.lblModeloCoche.setFont(new Font("Tahoma", 2, 12));
		
		this.cbElevadurasElectricas = new JCheckBox("Elevaduras electricas");
		this.cbElevadurasElectricas.setFont(new Font("Tahoma", Font.PLAIN, 12));
=======
		this.lblTitulo = new JLabel(language.labelAccessoriesTitle());
		this.lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.contentPane.add(lblTitulo, "cell 3 0");
		
		this.lblModeloCoche = new JLabel(language.labelModelCar());
		this.lblModeloCoche.setFont(new Font("Tahoma", Font.PLAIN, 17));
		this.contentPane.add(lblModeloCoche, "cell 0 1 5 1");
		
		this.cbElevadurasElectricas = new JCheckBox(language.checkBoxElectricElevation());
		this.cbElevadurasElectricas.setFont(new Font("Tahoma", Font.PLAIN, 15));
>>>>>>> 7eefb6993331b65c78a3958ec6d39c97d5b2c260
		this.cbElevadurasElectricas.setBackground(new Color(255,255,255));
		this.cbElevadurasElectricas.setFocusable(false);
		
<<<<<<< HEAD
		this.cbNavegador = new JCheckBox("Navegador");
		this.cbNavegador.setFont(new Font("Tahoma", Font.PLAIN, 12));
=======
		this.cbNavegador = new JCheckBox(language.checkBoxBrowser());
		this.cbNavegador.setFont(new Font("Tahoma", Font.PLAIN, 15));
>>>>>>> 7eefb6993331b65c78a3958ec6d39c97d5b2c260
		this.cbNavegador.setBackground(new Color(255,255,255));
		this.cbNavegador.setFocusable(false);
		
<<<<<<< HEAD
		this.cbLlantasAl = new JCheckBox("Llantas de aleacion");
		this.cbLlantasAl.setFont(new Font("Tahoma", Font.PLAIN, 12));
=======
		this.cbLlantasAl = new JCheckBox(language.checkBoxTires());
		this.cbLlantasAl.setFont(new Font("Tahoma", Font.PLAIN, 15));
>>>>>>> 7eefb6993331b65c78a3958ec6d39c97d5b2c260
		this.cbLlantasAl.setBackground(new Color(255,255,255));
		this.cbLlantasAl.setFocusable(false);
		
<<<<<<< HEAD
		this.cbAsientosCal = new JCheckBox("Asientos calefactados");
		this.cbAsientosCal.setFont(new Font("Tahoma", Font.PLAIN, 12));
=======
		this.cbAsientosCal = new JCheckBox(language.checkBoxHeatedSeats());
		this.cbAsientosCal.setFont(new Font("Tahoma", Font.PLAIN, 15));
>>>>>>> 7eefb6993331b65c78a3958ec6d39c97d5b2c260
		this.cbAsientosCal.setBackground(new Color(255,255,255));
		this.cbAsientosCal.setFocusable(false);
		
<<<<<<< HEAD
		this.cbVelCrucero = new JCheckBox("Velocidad de crucero");
		this.cbVelCrucero.setFont(new Font("Tahoma", Font.PLAIN, 12));
=======
		this.cbVelCrucero = new JCheckBox(language.checkBoxCruisingSpeed());
		this.cbVelCrucero.setFont(new Font("Tahoma", Font.PLAIN, 15));
>>>>>>> 7eefb6993331b65c78a3958ec6d39c97d5b2c260
		this.cbVelCrucero.setBackground(new Color(255,255,255));
		this.cbVelCrucero.setFocusable(false);
		
<<<<<<< HEAD
		this.cbAparcamietnoAuto = new JCheckBox("Aparcamiento automatico");
		this.cbAparcamietnoAuto.setFont(new Font("Tahoma", Font.PLAIN, 12));
=======
		this.cbAparcamietnoAuto = new JCheckBox(language.checkBoxAutomaticParking());
		this.cbAparcamietnoAuto.setFont(new Font("Tahoma", Font.PLAIN, 15));
>>>>>>> 7eefb6993331b65c78a3958ec6d39c97d5b2c260
		this.cbAparcamietnoAuto.setBackground(new Color(255,255,255));
		this.cbAparcamietnoAuto.setFocusable(false);
		
<<<<<<< HEAD
		this.cbConectorUSB = new JCheckBox("Conectores USB");
		this.cbConectorUSB.setFont(new Font("Tahoma", Font.PLAIN, 12));
=======
		this.cbConectorUSB = new JCheckBox(language.checkBoxUsbConnectors());
		this.cbConectorUSB.setFont(new Font("Tahoma", Font.PLAIN, 15));
>>>>>>> 7eefb6993331b65c78a3958ec6d39c97d5b2c260
		this.cbConectorUSB.setBackground(new Color(255,255,255));
		this.cbConectorUSB.setFocusable(false);
		
<<<<<<< HEAD
		this.cbPinturaMetal = new JCheckBox("Pintura metalizada");
		this.cbPinturaMetal.setFont(new Font("Tahoma", Font.PLAIN, 12));
=======
		this.cbPinturaMetal = new JCheckBox(language.checkBoxMetallizedPaint());
		this.cbPinturaMetal.setFont(new Font("Tahoma", Font.PLAIN, 15));
>>>>>>> 7eefb6993331b65c78a3958ec6d39c97d5b2c260
		this.cbPinturaMetal.setBackground(new Color(255,255,255));
		this.cbPinturaMetal.setFocusable(false);
		
<<<<<<< HEAD
		this.lblPrecioBasee = new JLabel("Precio Base:");
		this.lblPrecioBasee.setFont(new Font("Tahoma", Font.BOLD, 14));
=======
		this.lblPrecioBasee = new JLabel(language.labelBasePrice());
		this.lblPrecioBasee.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.contentPane.add(lblPrecioBasee, "cell 1 8,alignx left,aligny center");
>>>>>>> 7eefb6993331b65c78a3958ec6d39c97d5b2c260
		
		this.tfPrecioBase = new JTextField();
		this.tfPrecioBase.setFont(new Font("Tahoma", Font.PLAIN, 14));
		this.tfPrecioBase.setText("0");
		this.tfPrecioBase.setOpaque(false);
		this.tfPrecioBase.setEditable(false);
		
<<<<<<< HEAD
		this.lblAumento = new JLabel("Accesorios:");
		this.lblAumento.setFont(new Font("Tahoma", Font.BOLD, 14));
=======
		this.lblAumento = new JLabel(language.labelIncreasePrice());
		this.lblAumento.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.contentPane.add(lblAumento, "cell 1 9,alignx left,aligny center");
>>>>>>> 7eefb6993331b65c78a3958ec6d39c97d5b2c260
		
		this.tfAumento = new JTextField();
		this.tfAumento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		this.tfAumento.setText("0");
		this.tfAumento.setOpaque(false);
		this.tfAumento.setEditable(false);
		
<<<<<<< HEAD
		this.lblTotalPrecio = new JLabel("Total precio:");
		this.lblTotalPrecio.setFont(new Font("Tahoma", Font.BOLD, 14));
=======
		this.lblTotalPrecio = new JLabel(language.labelTotalPrice());
		this.lblTotalPrecio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.contentPane.add(lblTotalPrecio, "cell 1 10,alignx left,aligny center");
>>>>>>> 7eefb6993331b65c78a3958ec6d39c97d5b2c260
		
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
		this.tfTotalPrecio.setEditable(false);
		
<<<<<<< HEAD
		this.btnAtras = new JButton("Atrás");
=======
		this.btnAtras = new JButton(language.btnBack());
>>>>>>> 7eefb6993331b65c78a3958ec6d39c97d5b2c260
		this.btnAtras.setBackground(new Color(215,18,43));
		this.btnAtras.setForeground(new Color(255,255,255));
		this.btnAtras.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(215, 18, 43)),
				BorderFactory.createEmptyBorder(5,10,5,10)));
		
<<<<<<< HEAD
		this.btnFinalizar = new JButton("Finalizar Compra");
=======
		this.btnFinalizar = new JButton(language.btnEnd());
>>>>>>> 7eefb6993331b65c78a3958ec6d39c97d5b2c260
		this.btnFinalizar.setBackground(new Color(215,18,43));
		this.btnFinalizar.setForeground(new Color(255,255,255));
		this.btnFinalizar.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(215, 18, 43)),
				BorderFactory.createEmptyBorder(5,10,5,10)));
		
		this.contentPane.add(lblTitulo);
		this.contentPane.add(this.username, "wrap, align right");
		this.contentPane.add(lblModeloCoche, "wrap, align right");
		this.contentPane.add(cbElevadurasElectricas);
		this.contentPane.add(cbNavegador, "align left, wrap");
		this.contentPane.add(cbLlantasAl);
		this.contentPane.add(cbAsientosCal, "align left, wrap");
		this.contentPane.add(cbVelCrucero);
		this.contentPane.add(cbAparcamietnoAuto, "align left, wrap");
		this.contentPane.add(cbConectorUSB);
		this.contentPane.add(cbPinturaMetal, "align left, wrap");
		this.contentPane.add(lblPrecioBasee);
		this.contentPane.add(tfPrecioBase, "align left, wrap, pushx, growx");
		this.contentPane.add(lblAumento);
		this.contentPane.add(tfAumento, "align left, wrap, pushx, growx");
		this.contentPane.add(lblTotalPrecio);
		this.contentPane.add(tfTotalPrecio, "align left, wrap, pushx, growx");
		this.contentPane.add(btnAtras);
		this.contentPane.add(btnFinalizar, "align right, wrap");
		
	}

}
