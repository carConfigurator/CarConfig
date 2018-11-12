package view_miglayout;

import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import config.ConfigurationLoader;
import config.language.ELanguage;
import config.language.Language;
import daoImplFactory.LanguageFactory;
import net.miginfocom.swing.MigLayout;
import view_miglayout.Data_Clients;

public class Login extends JFrame{
	
	private ConfigurationLoader configLoad;
	private Language language;
	private File temp;
	
	// Atributos de la Clase.
	private JPanel panel = new JPanel();
	private JLabel label_username, label_password;
	private JTextField tfield_username;
	private JPasswordField pfield_password;
	private JButton btn_login;
	
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
		this.language = new Language(configLoad.getLanguage_files_path()+configLoad.getLanguage_default()+configLoad.getPostfix_language_file_name());
		this.temp = new File(this.configLoad.getTemporalPathFile());
		
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
		this.label_username = new JLabel(language.getText(ELanguage.labelUsername));
		this.label_username.setFont(new java.awt.Font("Tahoma", 0, 12));
		this.label_password = new JLabel(language.getText(ELanguage.labelPassword));
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
		this.btn_login = new JButton(language.getText(ELanguage.btnLogin));
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
		
		addFrame(configLoad, panel, language, language.getText(ELanguage.loginTitle));
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
		boolean pass = false;
		boolean user = false;
		
		//primero hacemos un bucle para comprovar si el usuario y la contraseña son correctos
		for (int i = 0; i < listEmployee.length; i++) {
			if (tfield_username.getText().equals(listEmployee[i])) {
				user=true;
				if (pfield_password.getText().equals(listPassword[i])) {
					pass=true;
				}
			}
		}
		//una vez lo hemos recorrido todo, miramos que ha pasado
		if(user) {//si lusuario ha ido bien entra en la contraseña
			if (pass) {//si la contraseña ha ido bien cambia de ventana
				System.out.println("[INFO] - Conexión Establecida. Cambiando de Frame...\n\t Enviando configuración, idioma y nombre de usuario...");
				System.out.println("[INFO] - Escribiendo en el fichero temporal.");
				// Oculto este Frame y llamo al siguiente:
				setVisible(false);
				System.out.println("Me sigo cagando en tu puta madre");
				new check(this.configLoad, this.language, username);
			}else {//si la contraseña era invalida saltara un error de la contraseña
				System.out.println("[ERROR] - El usuario/contraseña es incorrecto");
				JOptionPane.showMessageDialog(null,language.getText(ELanguage.errorLoginPassword),language.getText(ELanguage.errorLoginPasswordTitle), JOptionPane.ERROR_MESSAGE);
			}
		}else {//si el usuario era invalido saltara un error de usuario invalido
			JOptionPane.showMessageDialog(null,language.getText(ELanguage.errorLoginUser),language.getText(ELanguage.errorLoginUserTitle), JOptionPane.ERROR_MESSAGE);
			System.out.println("[ERROR] - El usuario no existe.");
		}
	}
}
