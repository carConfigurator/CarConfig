package view_miglayout;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import config.ConfigurationLoader;
import idao.ILanguage;
import model.Client;
import net.miginfocom.swing.MigLayout;
import view_miglayout.Selection_Model;

public class Data_Clients extends JFrame{

	// Atributos de la Clase:
	private ILanguage language;
	private ConfigurationLoader configLoad;
	private File temp;
	private Client client;
	private String username;
	
	private JPanel panel;
	private JLabel label_client_title, label_username, label_client_name, label_client_first_lastname, label_client_second_lastname,
		label_client_email, label_client_address, label_client_gender, label_client_birthdate;
	private JTextField tfield_client_name, tfield_client_first_lastname, tfield_client_second_lastname, tfield_client_address, tfield_client_email;
	private JRadioButton rb_male, rb_female, rb_unknown;
	private ButtonGroup bg_gender;
	private JDateChooser dc_birthdate;
	private JButton btn_save, btn_next;
	
	public Data_Clients(ConfigurationLoader configLoad, ILanguage language, String username, Client client) {
		System.out.println("[INFO] - Mostrando nuevamente el Frame de Datos Clientes...");
		System.out.println("[INFO] - Recuperando informaci�n...");
		this.client = client;
		this.language = language;
		this.configLoad = configLoad;
		this.username = username;
		this.temp = new File(this.configLoad.getTemporalPathFile());
		
		try {
			FileWriter fw = new FileWriter(this.temp);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("Datos Temporales");
			bw.newLine();
			bw.write("[Empleado] ");
			bw.write(username);
			bw.newLine();
			bw.write("------");
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		createFrame();
		setInformation();
	}
	
	public Data_Clients(ConfigurationLoader configLoad, ILanguage language, String username) {
		System.out.println("[INFO] - Mostrando nuevo Frame...");
		this.client = new Client();
		this.language = language;
		this.configLoad = configLoad;
		this.username = username;
		this.temp = new File(this.configLoad.getTemporalPathFile());
		
		createFrame();
		
	}
	
	private void createFrame() {
		boolean descuento = this.configLoad.getEmployee_version();
		if(descuento) {
			System.out.println("[INFO] - �Se dispondr� de un 20% de descuento en la siguiente compra!");
		}else {
			System.out.println("[INFO] - No habr� descuento para la siguiente compra.");
		}
		// JPanel:
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
		this.tfield_client_name.setText(this.client.getName());
		this.tfield_client_name.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(157, 157, 157)),
				BorderFactory.createEmptyBorder(5, 0, 5, 0)
				));
		this.tfield_client_name.setFont(new java.awt.Font("Tahoma", 0, 12));
		
		this.label_client_first_lastname = new JLabel(this.language.labelClientFirstLastName());
		this.label_client_first_lastname.setBorder(BorderFactory.createEmptyBorder(10, 25, 0, 5));
		this.label_client_first_lastname.setFont(new java.awt.Font("Tahoma", 0, 12));
		
		this.tfield_client_first_lastname = new JTextField(30);
		this.tfield_client_first_lastname.setText(this.client.getFirst_last_name());
		this.tfield_client_first_lastname.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(157, 157, 157)),
				BorderFactory.createEmptyBorder(5, 0, 5, 0)
				));
		this.tfield_client_first_lastname.setFont(new java.awt.Font("Tahoma", 0, 12));
		
		this.label_client_second_lastname = new JLabel(this.language.labelClientSecondLastName());
		this.label_client_second_lastname.setFont(new java.awt.Font("Tahoma", 0, 12));
		this.label_client_second_lastname.setBorder(BorderFactory.createEmptyBorder(10, 25, 0, 5));
		
		this.tfield_client_second_lastname = new JTextField(30);
		this.tfield_client_second_lastname.setText(this.client.getSecond_last_name());
		this.tfield_client_second_lastname.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(157, 157, 157)),
				BorderFactory.createEmptyBorder(5, 0, 5, 0)
				));
		this.tfield_client_second_lastname.setFont(new java.awt.Font("Tahoma", 0, 12));
		
		this.label_client_address = new JLabel(this.language.labelClientAddress());
		this.label_client_address.setFont(new java.awt.Font("Tahoma", 0, 12));
		this.label_client_address.setBorder(BorderFactory.createEmptyBorder(10, 25, 0, 5));
		
		this.tfield_client_address = new JTextField(30);
		this.tfield_client_address.setText(this.client.getAddress());
		this.tfield_client_address.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(157, 157, 157)),
				BorderFactory.createEmptyBorder(5, 0, 5, 0)
				));
		this.tfield_client_address.setFont(new java.awt.Font("Tahoma", 0, 12));
		
		this.label_client_email = new JLabel(this.language.labelClientEmail());
		this.label_client_email.setFont(new java.awt.Font("Tahoma", 0, 12));
		this.label_client_email.setBorder(BorderFactory.createEmptyBorder(10, 25, 0, 5));
		
		this.tfield_client_email = new JTextField(30);
		this.tfield_client_email.setText(this.client.getEmail());
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
		
		String getGender = this.client.getGender();
		
		if(getGender.equals(language.radioGenderMale())) {
			this.rb_male.setSelected(true);
		}else if(getGender.equals(language.radioGenderFemale())) {
			this.rb_female.setSelected(true);
		}else if(getGender.equals(null) || getGender.equals(language.radioGenderUnknown())) {
			this.rb_unknown.setSelected(true);	
		}
		
		this.label_client_birthdate = new JLabel(this.language.labelClientBirhdate());
		this.label_client_birthdate.setFont(new java.awt.Font("Tahoma", 0, 12));
		this.label_client_birthdate.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 5));
		
		this.dc_birthdate = new JDateChooser();
		if(client.getBirthdate() != null) {
			this.dc_birthdate = new JDateChooser();
			DateFormat df = new SimpleDateFormat("dd-MM-yyyy");		
			try {
				this.dc_birthdate.setDate(df.parse(client.getBirthdate()));
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		}
		this.dc_birthdate.setDateFormatString("dd-MM-yyyy");
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
		
		btn_next.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				nextActionPerformed();
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
		
		addFrame(configLoad, panel, language, language.dataClientsTitle());
		windowsListener(language);
	}
	
	/*
	 * 
	 */
	private void setInformation() {
		tfield_client_name.setText(client.getName());
		tfield_client_first_lastname.setText(client.getFirst_last_name());
		tfield_client_second_lastname.setText(client.getSecond_last_name());
		tfield_client_address.setText(client.getAddress());
		tfield_client_email.setText(client.getEmail());
	}

	protected void nextActionPerformed() {
		if(checkData()) {
			System.out.println("[INFO] - Todos los campos son correctos. Cambiando de Frame...");
			
			String getGender = null;
			
			if(rb_female.isSelected()) {
				getGender = rb_female.getText();
			}else if(rb_male.isSelected()) {
				getGender = rb_male.getText();
			}else if(rb_unknown.isSelected()) {
				getGender = rb_unknown.getText();
			}
			
			if(this.dc_birthdate.getDate()==null) {
				client = new Client(tfield_client_name.getText(), tfield_client_first_lastname.getText(), tfield_client_second_lastname.getText(), tfield_client_address.getText(), tfield_client_email.getText(), getGender);
			}else {
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				client = new Client(tfield_client_name.getText(), tfield_client_first_lastname.getText(), tfield_client_second_lastname.getText(), tfield_client_address.getText(), tfield_client_email.getText(), getGender, sdf.format(dc_birthdate.getDate()));
			}
        	try {
				FileWriter fw = new FileWriter(this.temp, true);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.newLine();
				bw.write("[Cliente] ");
				bw.write(client.toString());
				bw.newLine();
				bw.write("------");
				bw.close();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
        	setVisible(false);
        	new Selection_Model(this.configLoad, this.language, this.username, client);
		}
	}
	
	private boolean checkData() {
		tfield_client_address.setText(tfield_client_address.getText().replaceAll("^\\s*", ""));
		tfield_client_name.setText(tfield_client_name.getText().replaceAll("^\\s*", ""));
		tfield_client_first_lastname.setText(tfield_client_first_lastname.getText().replaceAll("^\\s*", ""));
		tfield_client_second_lastname.setText(tfield_client_second_lastname.getText().replaceAll("^\\s*", ""));
		tfield_client_email.setText(tfield_client_email.getText().replaceAll("^\\s*", ""));
		
		if (tfield_client_name.getText().length() == 0 || tfield_client_first_lastname.getText().length() == 0 || tfield_client_second_lastname.getText().length() == 0 || tfield_client_address.getText().length() == 0 || tfield_client_email.getText().length() == 0 ){
            JOptionPane.showMessageDialog(null, this.language.errorNullField(), this.language.errorNullFieldTitle(), JOptionPane.ERROR_MESSAGE);
            return false;
        }else {
    		//  Filtro para que el correo sea valido buscando en el contenido de este un "@".
            String email = tfield_client_email.getText();

            Pattern pattern = Pattern.compile("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b");
            Matcher matcher = pattern.matcher(email);

            if (matcher.find() == false) {
                JOptionPane.showMessageDialog(null, this.language.errorEmail(), this.language.errorEmailTitle(), JOptionPane.ERROR_MESSAGE);
                tfield_client_email.setText("");
                return false;
            }else {
            	return true;
            }
        }
	}

	protected void saveActionPerformed() {
		if(checkData()) {
			DateFormat format = new SimpleDateFormat(dc_birthdate.getDateFormatString());
			String getInformation = label_client_name.getText() + tfield_client_name.getText()
					+ "\n" + label_client_first_lastname.getText() + tfield_client_first_lastname.getText()
					+ "\n" + label_client_second_lastname.getText() + tfield_client_second_lastname.getText()
					+ "\n" + label_client_address.getText() + tfield_client_address.getText()
					+ "\n" + label_client_email.getText() + tfield_client_email.getText()
					+ "\n" + label_client_birthdate.getText() + dc_birthdate.getDate();
			
			String getGender = label_client_gender.getText();
			
			if(rb_female.isSelected()) {
				getGender = getGender + rb_female.getText();
			}else if(rb_male.isSelected()) {
				getGender = getGender + rb_male.getText();
			}else if(rb_unknown.isSelected()) {
				getGender = getGender + rb_unknown.getText();
			}
			
			JOptionPane.showMessageDialog(null, getInformation + "\n" + getGender, this.label_client_title.getText(), JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
