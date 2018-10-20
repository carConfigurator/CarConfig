package view.miglayout;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import config.ConfigurationLoader;
import idao.ILanguage;
import net.miginfocom.swing.MigLayout;

public class Data_Clients extends JFrame{

	// Atributos de la Clase:
	ILanguage language;
	
	JPanel panel;
	JLabel label_client_title, label_username, label_client_name, label_client_first_lastname, label_client_second_lastname,
	label_client_email, label_client_address, label_client_gender, label_client_birthdate;
	JTextField tfield_client_name, tfield_client_first_lastname;
	
	public Data_Clients(ConfigurationLoader configLoad, ILanguage language, String username) {
		this.language = language;
		this.panel = new JPanel();
		this.panel.setLayout(new MigLayout("insets 20"));
		this.panel.setBackground(new Color(255,255,255));
		
		this.label_client_title = new JLabel(this.language.labelClientTitle());
		this.label_client_title.setFont(new java.awt.Font("Tahoma", 0, 16));
		
		this.label_username = new JLabel(this.language.labelAuthIn() + username);
		this.label_username.setFont(new java.awt.Font("Tahoma", 0, 10));
		
		this.label_client_name = new JLabel(this.language.labelClientName());
		this.label_client_name.setBorder(BorderFactory.createEmptyBorder(10, 25, 0, 5));
		this.label_client_name.setFont(new java.awt.Font("Tahoma", 0, 12));
		
		this.tfield_client_name = new JTextField(30);
		this.tfield_client_name.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(157, 157, 157)),
				BorderFactory.createEmptyBorder(5, 0, 5, 0)
				));
		this.tfield_client_name.setFont(new java.awt.Font("Tahoma", 0, 12));
		
		this.label_client_first_lastname = new JLabel(this.language.labelClientFirstLastName());
		this.label_client_first_lastname.setBorder(BorderFactory.createEmptyBorder(10, 25, 0, 5));
		this.label_client_first_lastname.setFont(new java.awt.Font("Tahoma", 0, 12));
		
		this.tfield_client_first_lastname = new JTextField(30);
		this.tfield_client_first_lastname.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(157, 157, 157)),
				BorderFactory.createEmptyBorder(5, 0, 5, 0)
				));
		this.tfield_client_first_lastname.setFont(new java.awt.Font("Tahoma", 0, 12));
		
		this.panel.add(this.label_client_title);
		this.panel.add(this.label_username, "wrap, skip, align right");
		this.panel.add(this.label_client_name);
		this.panel.add(this.tfield_client_name, "wrap, pushx, growx");
		this.panel.add(this.label_client_first_lastname);
		this.panel.add(this.tfield_client_first_lastname, "wrap, pushx, growx");
		JFrame();
	}

	private void JFrame() {
		add(this.panel);
		setSize(600,600);
		setIconImage(getIconImage());
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
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
