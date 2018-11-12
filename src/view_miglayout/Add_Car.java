package view_miglayout;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import config.ConfigurationLoader;
import config.language.ELanguage;
import config.language.Language;
import idao.IModel;
import model.Client;
import net.miginfocom.swing.MigLayout;

public class Add_Car extends JFrame{

	private Language language;
	private ConfigurationLoader configLoad;
	private Client client;
	private String username;
	private IModel model;
	
	private JPanel panelMig;
	private JLabel lId, lName, lDescription, lImg_Name, lPrice;
	private JTextField tfId, tfName, tfDescription, tfImg_Name, tfPrice;
	private JButton btnSave, btnBack;
	
	public Add_Car(ConfigurationLoader configLoad, Language language, String username, Client client, IModel model){
		this.configLoad = configLoad;
		this.language = language;
		this.username = username;
		this.client = client;
		this.model = model;

		// Configuracion de los Componentes:
		// Añado el Layout al Panel y le indico que este haga un padding de 20 en el Panel.
		this.panelMig = new JPanel();
		this.panelMig.setLayout(new MigLayout("insets 20 50 50 50, fillx, filly"));
		this.panelMig.setBackground(new Color(255, 255, 255));

		this.lId = new JLabel(this.language.getText(ELanguage.labelId));
		this.lId.setFont(new java.awt.Font("Tahoma", 0, 12));
		this.tfId = new JTextField(30);
		this.tfId.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(157, 157, 157)),
				BorderFactory.createEmptyBorder(5, 0, 5, 0)
				));
		this.tfId.setEditable(false);
		this.lName = new JLabel(this.language.getText(ELanguage.labelName));
		this.lName.setFont(new java.awt.Font("Tahoma", 0, 12));
		this.tfName = new JTextField(30);
		this.tfName.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(157, 157, 157)),
				BorderFactory.createEmptyBorder(5, 0, 5, 0)
				));
		this.lDescription = new JLabel(this.language.getText(ELanguage.labelDescription));
		this.lDescription.setFont(new java.awt.Font("Tahoma", 0, 12));
		this.tfDescription = new JTextField(30);
		this.tfDescription.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(157, 157, 157)),
				BorderFactory.createEmptyBorder(5, 0, 5, 0)
				));
		this.lImg_Name = new JLabel(this.language.getText(ELanguage.labelImg_Name));
		this.lImg_Name.setFont(new java.awt.Font("Tahoma", 0, 12));
		this.tfImg_Name = new JTextField(30);
		this.tfImg_Name.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(157, 157, 157)),
				BorderFactory.createEmptyBorder(5, 0, 5, 0)
				));
		this.lPrice = new JLabel(this.language.getText(ELanguage.labelPrice));
		this.lPrice.setFont(new java.awt.Font("Tahoma", 0, 12));
		this.tfPrice = new JTextField(30);
		this.tfPrice.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(157, 157, 157)),
				BorderFactory.createEmptyBorder(5, 0, 5, 0)
				));
		
		this.btnSave = new JButton(language.getText(ELanguage.btnSave));
		this.btnSave.setBackground(new Color(215,18,43));
		this.btnSave.setForeground(new Color(255,255,255));
		this.btnSave.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(215, 18, 43)),
				BorderFactory.createEmptyBorder(5,10,5,10)
				));
		this.btnBack = new JButton(language.getText(ELanguage.btnBack));
		this.btnBack.setBackground(new Color(215,18,43));
		this.btnBack.setForeground(new Color(255,255,255));
		this.btnBack.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(215, 18, 43)),
				BorderFactory.createEmptyBorder(5,10,5,10)
				));
		
		
		// Colocacion de los Componentes en el JPanel:
		this.panelMig.add(lId, ""); // Añado el atributo wrap en la constraint que hace que el componente ocupe toda la fila.
		this.panelMig.add(tfId, "wrap, pushx, growx"); // PushX y GrowX hacen que el componente vaya hasta el final de la fila y si se redimensiona, este se mantenga hasta el final de la fila
		this.panelMig.add(lName, "");
		this.panelMig.add(tfName, "wrap, pushx, growx");
		this.panelMig.add(lDescription, "");
		this.panelMig.add(tfDescription, "wrap, pushx, growx");
		this.panelMig.add(lImg_Name, "");
		this.panelMig.add(tfImg_Name, "wrap, pushx, growx");
		this.panelMig.add(lPrice, "");
		this.panelMig.add(tfPrice, "wrap, pushx, growx");
		this.panelMig.add(btnBack, "align left");
		this.panelMig.add(btnSave, "align right"); // Alineo el componente a la derecha de la fila, sería como un float.
				
		// Ponemos el id que le toque al siguiente coche
		tfId.setText(""+(model.getModel(model.getModels().size()).getId()+1));
		
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!tfImg_Name.getText().equals("")) {
					if ((new File (configLoad.getCar_image_path()+tfImg_Name.getText()).exists())) {
						if (!tfPrice.getText().equals("")) {
							try {
								Double.parseDouble(tfPrice.getText());
								model.addCar(tfId, tfName, tfDescription, tfImg_Name, tfPrice);
								setVisible(false);
								backActionPerformed(e);
							}catch(NumberFormatException ex) {
								JOptionPane.showMessageDialog(panelMig, language.getText(ELanguage.errorParseDouble), language.getText(ELanguage.errorParseDoubleTitle), JOptionPane.ERROR_MESSAGE);
							}
						}else {
							JOptionPane.showMessageDialog(panelMig, language.getText(ELanguage.errorPriceNull), language.getText(ELanguage.errorPriceNullTitle), JOptionPane.ERROR_MESSAGE);
						}
					}else {
						JOptionPane.showMessageDialog(panelMig, language.getText(ELanguage.errorImgName), language.getText(ELanguage.errorImgNameTitle), JOptionPane.ERROR_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(panelMig, language.getText(ELanguage.errorImgNameNull), language.getText(ELanguage.errorImgNameNullTitle), JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
				
		btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				backActionPerformed(e);
			}
		});
		
		addFrame(configLoad, panelMig, language, language.getText(ELanguage.addCarTitle));
	}
	
	private void backActionPerformed(ActionEvent ae) {
		setVisible(false);
		new Selection_Model(this.configLoad, this.language, this.username, this.client);
	}
}
