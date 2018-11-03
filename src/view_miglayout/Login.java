package src.view_miglayout;

import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import src.config.ConfigurationLoader;
import src.daoImplFactory.LanguageFactory;
import src.idao.ILanguage;
import net.miginfocom.swing.MigLayout;
import src.view_miglayout.Data_Clients;

public class Login extends JFrame{
	
	private ConfigurationLoader configLoad;
	private ILanguage language;
	private File temp;
	
	// Atributos de la Clase.
	JPanel panel = new JPanel();
	JLabel label_username, label_password;
	JTextField tfield_username;
	JPasswordField pfield_password;
	JButton btn_login;
	
	// Al ser la primera Vista, hago un main que ejecute el constructor el cuál tendrá todos los parámetros.
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Login();
			}
		});
	}
	
	/*
	 * Constructor de la Clase
	 */
	public Login() {
		this.configLoad = ConfigurationLoader.getConfigurationLoaderInstance();
		ConfigurationLoader configLoad2 = ConfigurationLoader.getConfigurationLoaderInstance();
		System.out.println("[INFO] - Obteniendo idioma del Archivo de Configuración...");
		System.out.println("\t [DEMO] - El idioma para este sprint será únicamente en Castellano,\n\t pero está planteado para multilenguajes.");
		this.language = LanguageFactory.getLanguage(this.configLoad);
		this.temp = new File(this.configLoad.getTemporalPathFile());
		
		// Comprobará siempre si el archivo existe, en caso de que exista lo eliminará para generarlo desde 0.
		if(this.temp.exists()) {
			this.temp.delete();
		}
		
		// Volvemos a generar el fichero txt:
		try {
			this.temp.createNewFile();
		} catch (IOException e1) {
			System.out.println("[ERROR] - Error de E/S. Más información: " + e1);
		}
		
		// Configuracion de los Componentes:
		// Añado el Layout al Panel y le indico que este haga un padding de 20 en el Panel.
		this.panel.setLayout(new MigLayout("insets 20"));
		this.panel.setBackground(new Color(255,255,255));
		this.label_username = new JLabel(language.labelUsername());
		this.label_username.setFont(new java.awt.Font("Tahoma", 0, 12));
		this.label_password = new JLabel(language.labelPassword());
		this.label_password.setFont(new java.awt.Font("Tahoma", 0, 12));
		this.label_password.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
		this.tfield_username = new JTextField(30);
		this.tfield_username.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(157, 157, 157)),
				BorderFactory.createEmptyBorder(5, 0, 5, 0)
				));
		this.tfield_username.setFont(new java.awt.Font("Tahoma", 0, 12));
		this.pfield_password = new JPasswordField(30);
		this.pfield_password.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(157, 157, 157)),
				BorderFactory.createEmptyBorder(5, 0, 5, 0)
				));
		this.pfield_password.setMargin(new Insets(0, 10, 10, 10));
		this.pfield_password.setFont(new java.awt.Font("Tahoma", 0, 12));
		this.btn_login = new JButton(language.btnLogin());
		this.btn_login.setFont(new java.awt.Font("Tahoma", 0, 12));
		this.btn_login.setBackground(new Color(215,18,43));
		this.btn_login.setForeground(new Color(255,255,255));
		this.btn_login.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(215, 18, 43)),
				BorderFactory.createEmptyBorder(5,10,5,10)
				));
		
		
		// Colocacion de los Componentes en el JPanel:
		this.panel.add(label_username, "wrap"); // Añado el atributo wrap en la constraint que hace que el componente ocupe toda la fila.
		this.panel.add(tfield_username, "wrap, pushx, growx"); // PushX y GrowX hacen que el componente vaya hasta el final de la fila y si se redimensiona, este se mantenga hasta el final de la fila
		this.panel.add(label_password, "wrap");
		this.panel.add(pfield_password, "wrap, pushx, growx");
		this.panel.add(btn_login, "align right"); // Alineo el componente a la derecha de la fila, sería como un float.
		
		// Action Listeners (cuando hagan enter en el JTextField o JPasswordField o pulsen el botón, vayan al mismo método):
		
		this.btn_login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				loginActionPerformed(e);
			}
		});

		this.tfield_username.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				loginActionPerformed(e);
			}
		});
		
		this.pfield_password.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				loginActionPerformed(e);
			}
		});
		
		JFrame();
	}
	
	/*
	 * Método para configurar la ventana actual.
	 */
	public void JFrame() {
		add(panel);
		setTitle("SEAT Configurador - Log In");
		setIconImage(getIconImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,600);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	/*
	 * Método que comprueba los datos enviados en el Form y comprueba si coinciden con los datos de Config
	 * @param Se envia el ActionEvent del método actionPerformed().
	 */
	private void loginActionPerformed(ActionEvent e) {
		String username = tfield_username.getText();
		String password = String.valueOf(pfield_password.getPassword());
		String[] listEmployee = configLoad.getEmployee_list();
		String[] listPassword = configLoad.getEmployee_password();
		
		int countTries = 1;
		
		for (int i = 0; i < listEmployee.length; i++) {
			if(countTries == listEmployee.length) {
				JOptionPane.showMessageDialog(null,language.errorLoginUser(),language.errorLoginUserTitle(), JOptionPane.ERROR_MESSAGE);
				System.out.println("[ERROR] - El usuario no existe.");
			}else {
				if(listEmployee[i].equals(username)) {
					if(listPassword[i].equals(password)) {
						System.out.println("[INFO] - Conexión Establecida. Cambiando de Frame...\n\t Enviando configuración, idioma y nombre de usuario...");
						// Oculto este Frame y llamo al siguiente:
						setVisible(false);
						System.out.println("[INFO] - Escribiendo en el fichero temporal.");
						try {
							FileWriter fw = new FileWriter(this.temp);
							BufferedWriter bw = new BufferedWriter(fw);
							bw.write(username);
							bw.newLine();
							bw.write("------");
							bw.close();
							fw.close();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						new Data_Clients(this.configLoad, this.language, username);
					}else {
						System.out.println("[ERROR] - El usuario/contraseña es incorrecto");
						JOptionPane.showMessageDialog(null,language.errorLoginPassword(),language.errorLoginPasswordTitle(), JOptionPane.ERROR_MESSAGE);
					}
				}else {
					countTries++;
				}
			}
		}
	}

	/*
	 * Método que obtiene la imagen para el JFrame.
	 * @return La imagen que hay en carpeta.
	 * @see java.awt.Frame#getIconImage()
	 */
	public Image getIconImage() {
		File image = new File("src/config/favicon.png");
        Image retValue = Toolkit.getDefaultToolkit().getImage(image.getAbsolutePath());
        return retValue;
    }
}
