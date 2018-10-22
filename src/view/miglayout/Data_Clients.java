package view.miglayout;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import config.ConfigurationLoader;
import idao.ILanguage;
import net.miginfocom.swing.MigLayout;
import view.part12;

public class Data_Clients extends JFrame{

	// Atributos de la Clase:
	ILanguage language;
	
	JPanel panel;
	JLabel label_client_title, label_username, label_client_name, label_client_first_lastname, label_client_second_lastname,
	label_client_email, label_client_address, label_client_gender, label_client_birthdate;
	JTextField tfield_client_name, tfield_client_first_lastname, tfield_client_second_lastname, tfield_client_address, tfield_client_email;
	JRadioButton rb_male, rb_female, rb_unknown;
	ButtonGroup bg_gender;
	JDateChooser dc_birthdate;
	JButton btn_save, btn_next;
	
	public Data_Clients(ConfigurationLoader configLoad, ILanguage language, String username) {
		System.out.println("[INFO] - Mostrando nuevo Frame...");
		this.language = language;
		this.panel = new JPanel();
		this.panel.setLayout(new MigLayout("insets 20"));
		this.panel.setBackground(new Color(255,255,255));
		
		this.label_client_title = new JLabel(this.language.labelClientTitle());
		this.label_client_title.setFont(new Font("Tahoma", 0, 16));
		
		this.label_username = new JLabel(this.language.labelAuthIn() + username);
		this.label_username.setFont(new Font("Tahoma", 0, 10));
		
		this.label_client_name = new JLabel(this.language.labelClientName());
		this.label_client_name.setBorder(BorderFactory.createEmptyBorder(10, 25, 0, 5));
		this.label_client_name.setFont(new Font("Tahoma", 0, 12));
		
		this.tfield_client_name = new JTextField(30);
		this.tfield_client_name.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(157, 157, 157)),
				BorderFactory.createEmptyBorder(5, 0, 5, 0)
				));
		this.tfield_client_name.setFont(new Font("Tahoma", 0, 12));
		
		this.label_client_first_lastname = new JLabel(this.language.labelClientFirstLastName());
		this.label_client_first_lastname.setBorder(BorderFactory.createEmptyBorder(10, 25, 0, 5));
		this.label_client_first_lastname.setFont(new java.awt.Font("Tahoma", 0, 12));
		
		this.tfield_client_first_lastname = new JTextField(30);
		this.tfield_client_first_lastname.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(157, 157, 157)),
				BorderFactory.createEmptyBorder(5, 0, 5, 0)
				));
		this.tfield_client_first_lastname.setFont(new java.awt.Font("Tahoma", 0, 12));
		
		this.label_client_second_lastname = new JLabel(this.language.labelClientSecondLastName());
		this.label_client_second_lastname.setFont(new java.awt.Font("Tahoma", 0, 12));
		this.label_client_second_lastname.setBorder(BorderFactory.createEmptyBorder(10, 25, 0, 5));
		
		this.tfield_client_second_lastname = new JTextField(30);
		this.tfield_client_second_lastname.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(157, 157, 157)),
				BorderFactory.createEmptyBorder(5, 0, 5, 0)
				));
		this.tfield_client_second_lastname.setFont(new java.awt.Font("Tahoma", 0, 12));
		
		this.label_client_address = new JLabel(this.language.labelClientAddress());
		this.label_client_address.setFont(new java.awt.Font("Tahoma", 0, 12));
		this.label_client_address.setBorder(BorderFactory.createEmptyBorder(10, 25, 0, 5));
		
		this.tfield_client_address = new JTextField(30);
		this.tfield_client_address.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(157, 157, 157)),
				BorderFactory.createEmptyBorder(5, 0, 5, 0)
				));
		this.tfield_client_address.setFont(new java.awt.Font("Tahoma", 0, 12));
		
		this.label_client_email = new JLabel(this.language.labelClientEmail());
		this.label_client_email.setFont(new java.awt.Font("Tahoma", 0, 12));
		this.label_client_email.setBorder(BorderFactory.createEmptyBorder(10, 25, 0, 5));
		
		this.tfield_client_email = new JTextField(30);
		this.tfield_client_email.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(157, 157, 157)),
				BorderFactory.createEmptyBorder(5, 0, 5, 0)
				));
		this.tfield_client_email.setFont(new java.awt.Font("Tahoma", 0, 12));
		
		this.label_client_gender = new JLabel(this.language.labelClientGender());
		this.label_client_gender.setFont(new java.awt.Font("Tahoma", 0, 12));
		this.label_client_gender.setBorder(BorderFactory.createEmptyBorder(10, 25, 0, 5));
		
		this.rb_male = new JRadioButton(this.language.radioGenderMale());
		this.rb_male.setBackground(new Color(255,255,255));
		this.rb_male.setFont(new java.awt.Font("Tahoma", 0, 12));
		this.rb_female = new JRadioButton(this.language.radioGenderFemale());
		this.rb_female.setBackground(new Color(255,255,255));
		this.rb_female.setFont(new java.awt.Font("Tahoma", 0, 12));
		this.rb_unknown = new JRadioButton(this.language.radioGenderUnknown());
		this.rb_unknown.setBackground(new Color(255,255,255));
		this.rb_unknown.setFont(new java.awt.Font("Tahoma", 0, 12));
		this.bg_gender = new ButtonGroup();
		
		this.bg_gender.add(rb_male);
		this.bg_gender.add(rb_female);
		this.bg_gender.add(rb_unknown);
		
		this.rb_unknown.setSelected(true);
		
		this.label_client_birthdate = new JLabel(this.language.labelClientBirhdate());
		this.label_client_birthdate.setFont(new java.awt.Font("Tahoma", 0, 12));
		this.label_client_birthdate.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 5));
		
		this.dc_birthdate = new JDateChooser();
		this.dc_birthdate.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		this.dc_birthdate.setBackground(new Color(255, 255, 255));
		
		this.btn_save = new JButton(this.language.btnSave());
		this.btn_save.setFont(new java.awt.Font("Tahoma", 0, 12));
		this.btn_save.setBackground(new Color(215,18,43));
		this.btn_save.setForeground(new Color(255,255,255));
		this.btn_save.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(215, 18, 43)),
				BorderFactory.createEmptyBorder(5,10,5,10)
				));
		
		this.btn_next = new JButton(this.language.btnNext());
		this.btn_next.setFont(new java.awt.Font("Tahoma", 0, 12));
		this.btn_next.setBackground(new Color(215,18,43));
		this.btn_next.setForeground(new Color(255,255,255));
		this.btn_next.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(215, 18, 43)),
				BorderFactory.createEmptyBorder(5,10,5,10)
				));
		
		btn_save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				saveActionPerformed();
			}
		});
		
		this.panel.add(this.label_client_title);
		this.panel.add(this.label_username, "wrap, skip, align right");
		this.panel.add(this.label_client_name, "align right");
		this.panel.add(this.tfield_client_name, "wrap, pushx, growx");
		this.panel.add(this.label_client_first_lastname, "align right");
		this.panel.add(this.tfield_client_first_lastname, "wrap, pushx, growx");
		this.panel.add(this.label_client_second_lastname, "align right");
		this.panel.add(this.tfield_client_second_lastname, "wrap, pushx, growx");
		this.panel.add(this.label_client_address, "align right");
		this.panel.add(this.tfield_client_address, "wrap, pushx, growx");
		this.panel.add(this.label_client_email, "align right");
		this.panel.add(this.tfield_client_email, "wrap, pushx, growx");
		this.panel.add(this.label_client_gender, "align right");
		this.panel.add(this.rb_male, "split 3"); // Ocupa tres celdas
		this.panel.add(this.rb_female); // Este elemento y el siguiente formaran parte de la misma celda que el elemento anterior, por culpa del split.
		this.panel.add(this.rb_unknown, "wrap");
		this.panel.add(label_client_birthdate, "align right");
		this.panel.add(dc_birthdate, "wrap, pushx, growx");
		this.panel.add(btn_save, "skip, align right, split 2");
		this.panel.add(btn_next);
		JFrame();
	}

	protected void saveActionPerformed() {
		
		tfield_client_address.setText(tfield_client_address.getText().replaceAll("^\\s*", ""));
		tfield_client_name.setText(tfield_client_name.getText().replaceAll("^\\s*", ""));
		tfield_client_first_lastname.setText(tfield_client_first_lastname.getText().replaceAll("^\\s*", ""));
		tfield_client_second_lastname.setText(tfield_client_second_lastname.getText().replaceAll("^\\s*", ""));
		tfield_client_email.setText(tfield_client_email.getText().replaceAll("^\\s*", ""));
		
		if (tfield_client_name.getText().length() == 0 || tfield_client_first_lastname.getText().length() == 0 || tfield_client_second_lastname.getText().length() == 0 || tfield_client_address.getText().length() == 0 || tfield_client_email.getText().length() == 0 ){
            JOptionPane.showMessageDialog(null, "Faltan campos por rellenar. Rellene todos los campos obligatorios.", "Informacion Incompleta", JOptionPane.ERROR_MESSAGE);
        }else {
    		//  Filtro para que el correo sea valido buscando en el contenido de este un "@".
            String email = tfield_client_email.getText();

            Pattern pattern = Pattern.compile("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b");
            Matcher matcher = pattern.matcher(email);

            if (matcher.find() == false) {
                JOptionPane.showMessageDialog(null, "El correo no es valido.", "Error de correo", JOptionPane.ERROR_MESSAGE);
                tfield_client_email.setText("");
            }else {
            	System.out.println("[INFO] - Todos los campos son correctos. Guardando...");
            	new part12();
            }
        }
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
