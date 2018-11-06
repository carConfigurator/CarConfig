package view_miglayout;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.InternationalFormatter;
import javax.swing.text.MaskFormatter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

import com.sun.org.apache.xpath.internal.operations.Mod;

import config.ConfigurationLoader;
import idao.ILanguage;
import model.Accessory;
import model.Client;
import model.Engine;
import model.Model;
import net.miginfocom.swing.MigLayout;
import sun.awt.AWTAccessor.SystemColorAccessor;

public class Modify_Car extends JFrame{

	private ILanguage language;
	private ConfigurationLoader configLoad;
	private Client client;
	private String username;
	private Model model;
	private int idSelected;
	
	private DocumentBuilderFactory factory;
	private DocumentBuilder builder;
	private Document documentOld;
	private Document documentNew;
	
	private JPanel panelMig;
	private JLabel lId, lName, lDescription, lImg_Name, lPrice;
	private JTextField tfId, tfName, tfDescription, tfImg_Name, tfPrice;
	private JButton btnSave, btnBack;
	
	public Modify_Car(ConfigurationLoader configLoad, ILanguage language, String username, Client client, Model model, int idSelected){
		this.configLoad = configLoad;
		this.language = language;
		this.username = username;
		this.client = client;
		this.model = model;
		this.idSelected = idSelected;
		
		this.factory = DocumentBuilderFactory.newInstance();
		try {
			this.builder = factory.newDocumentBuilder();
			this.documentOld = builder.parse(new File(configLoad.getCar_configuration_path()+configLoad.getCar_configuration_file_name()));
		} catch (ParserConfigurationException e) {
			System.out.println("[ERROR] - No se ha podido parsear la configuración. Más información del error: " + e);
		} catch (SAXException e) {
			System.out.println("[ERROR] - No se ha podido parsear el archivo XML. Más información del error: " + e);
		} catch (IOException e) {
			System.out.println("[ERROR] - Error de E/S. Más información del error: " + e);
		}

		// Configuracion de los Componentes:
		// Añado el Layout al Panel y le indico que este haga un padding de 20 en el Panel.
		this.panelMig = new JPanel();
		this.panelMig.setLayout(new MigLayout("insets 20 50 50 50, fillx, filly"));
		this.panelMig.setBackground(new Color(255, 255, 255));

		this.lId = new JLabel(this.language.labelId());
		this.lId.setFont(new java.awt.Font("Tahoma", 0, 12));
		this.tfId = new JTextField(30);
		this.tfId.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(157, 157, 157)),
				BorderFactory.createEmptyBorder(5, 0, 5, 0)
				));
		this.tfId.setEditable(false);
		this.lName = new JLabel(this.language.labelName());
		this.lName.setFont(new java.awt.Font("Tahoma", 0, 12));
		this.tfName = new JTextField(30);
		this.tfName.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(157, 157, 157)),
				BorderFactory.createEmptyBorder(5, 0, 5, 0)
				));
		this.lDescription = new JLabel(this.language.labelDescription());
		this.lDescription.setFont(new java.awt.Font("Tahoma", 0, 12));
		this.tfDescription = new JTextField(30);
		this.tfDescription.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(157, 157, 157)),
				BorderFactory.createEmptyBorder(5, 0, 5, 0)
				));
		this.lImg_Name = new JLabel(this.language.labelImg_Name());
		this.lImg_Name.setFont(new java.awt.Font("Tahoma", 0, 12));
		this.tfImg_Name = new JTextField(30);
		this.tfImg_Name.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(157, 157, 157)),
				BorderFactory.createEmptyBorder(5, 0, 5, 0)
				));
		this.lPrice = new JLabel(this.language.labelPrice());
		this.lPrice.setFont(new java.awt.Font("Tahoma", 0, 12));
		this.tfPrice = new JTextField(30);
		this.tfPrice.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(157, 157, 157)),
				BorderFactory.createEmptyBorder(5, 0, 5, 0)
				));
		
		this.btnSave = new JButton(language.btnSave());
		this.btnSave.setBackground(new Color(215,18,43));
		this.btnSave.setForeground(new Color(255,255,255));
		this.btnSave.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(215, 18, 43)),
				BorderFactory.createEmptyBorder(5,10,5,10)
				));
		this.btnBack = new JButton(language.btnBack());
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
		tfId.setText(""+model.getIdSelected());
		tfName.setText(model.getNameSelected());
		tfDescription.setText(model.getDescriptionSelected());
		tfImg_Name.setText(model.getImage_nameSelected());
		tfPrice.setText(""+model.getPriceSelected());
		
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!tfImg_Name.getText().equals("")) {
					if ((new File (configLoad.getCar_image_path()+tfImg_Name.getText()).exists())) {
						if (!tfPrice.getText().equals("")) {
							try {
								Double.parseDouble(tfPrice.getText());
								saveActionPerformed(e);
							}catch(NumberFormatException ex) {
								System.out.println("[ERROR] - El valor del String no se puede formatear a Double");
							}
						}else {
							System.out.println("[ERROR] - El precio no se puede dejar null");
						}
					}else {
						JOptionPane.showMessageDialog(panelMig, language.errorImgName(), language.errorImgNameTitle(), JOptionPane.ERROR_MESSAGE);
					}
				}else {
					System.out.println("[ERROR] - Se tiene que poner una imagen");
				}
				
			}
		});
				
		btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				backActionPerformed(e);
			}
		});
		
		JFrame();
	}
	
	private void JFrame() {
		add(panelMig);
		setTitle(language.addCarTitle());
		setIconImage(getIconImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,400);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void saveActionPerformed(ActionEvent ae) {
		String nombre_archivo = "CarConfiguration";
		
		DOMImplementation implementation = builder.getDOMImplementation();
        documentNew = implementation.createDocument(null, nombre_archivo, null);
        documentNew.setXmlVersion("1.0");
		
      //Main Node
        Element raiz = documentNew.getDocumentElement();
        //usamos este boleano para saber que node es el que nos saltamos porque ya lo añadimos en el else
        boolean saltar = false;
        
        NodeList nListModel = documentOld.getElementsByTagName("Model");
		for (int i = 0; i < nListModel.getLength(); i++) {
			Node nNode = nListModel.item(i);
            Element itemNode = documentNew.createElement("Model"); 
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element elementKey = (Element) nNode;
				for (int y = 0; y < elementKey.getElementsByTagName("*").getLength(); y++) {
					Node nElementsKey = elementKey.getElementsByTagName("*").item(y);
		            Element keyNode = documentNew.createElement(nElementsKey.getNodeName()); 
					if (nElementsKey.getNodeType() == Node.ELEMENT_NODE) {
						Element elementValue = (Element) nElementsKey;
			            Text nodeKeyValue = documentNew.createTextNode(elementValue.getTextContent());
			            //si el id que vamos a meter es el que queremos modificar hacemos lo siguiente: (sino se añade y ya)
			            if(!nodeKeyValue.getTextContent().equals(""+this.idSelected)) {
				            keyNode.appendChild(nodeKeyValue);
			            }else {
			            	//si es el id que queremos modificar, ponemos la info que hemos tocado
			                Element newItemNode = documentNew.createElement("Model");
			                Element idNode = documentNew.createElement("id");
			                Text idValue = documentNew.createTextNode(tfId.getText());
			                idNode.appendChild(idValue);
			                Element nomNode = documentNew.createElement("nom");
			                Text nomValue = documentNew.createTextNode(tfName.getText());
			                nomNode.appendChild(nomValue);
			                Element descripcioNode = documentNew.createElement("descripcio");
			                Text descripcioValue = documentNew.createTextNode(tfDescription.getText());
			                descripcioNode.appendChild(descripcioValue);
			                Element imatge_nomNode = documentNew.createElement("imatge_nom");
			                Text imatge_nomValue = documentNew.createTextNode(tfImg_Name.getText());
			                imatge_nomNode.appendChild(imatge_nomValue);
			                Element preuNode = documentNew.createElement("preu");
			                Text preuValue = documentNew.createTextNode(tfPrice.getText());
			                preuNode.appendChild(preuValue);

			                newItemNode.appendChild(idNode);
			                newItemNode.appendChild(nomNode);
			                newItemNode.appendChild(descripcioNode);
			                newItemNode.appendChild(imatge_nomNode);
			                newItemNode.appendChild(preuNode);
			                raiz.appendChild(newItemNode);
			                
			                //hacemos que nos salte lo que queda de node
			            	y=elementKey.getElementsByTagName("*").getLength();
			            	saltar=true;
			            }
			            keyNode.appendChild(nodeKeyValue);
					}
					if(!saltar) {
			            itemNode.appendChild(keyNode);
			        }
		    	}
				if(!saltar) {
			        raiz.appendChild(itemNode);
			    }else {
			    	saltar=false;
			    }
			}
    	}
		
		NodeList nListEngine = documentOld.getElementsByTagName("Engine");
		for (int i = 0; i < nListEngine.getLength(); i++) {
			Node nNode = nListEngine.item(i);
            Element itemNode = documentNew.createElement("Engine"); 
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element elementEngine = (Element) nNode;
				for (int y = 0; y < elementEngine.getElementsByTagName("*").getLength(); y++) {
					Node nElementsKey = elementEngine.getElementsByTagName("*").item(y);
		            Element keyNode = documentNew.createElement(nElementsKey.getNodeName()); 
					if (nElementsKey.getNodeType() == Node.ELEMENT_NODE) {
						Element elementValue = (Element) nElementsKey;
			            Text nodeKeyValue = documentNew.createTextNode(elementValue.getTextContent());
			            keyNode.appendChild(nodeKeyValue);
					}
		            itemNode.appendChild(keyNode);
		    	}
	            raiz.appendChild(itemNode);
			}
    	}
		
		NodeList nList = documentOld.getElementsByTagName("Accessory");
		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);
            Element itemNode = documentNew.createElement("Accessory");
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				for (int y = 0; y < eElement.getElementsByTagName("*").getLength(); y++) {
					Node nElementsKey = eElement.getElementsByTagName("*").item(y);
		            Element keyNode = documentNew.createElement(nElementsKey.getNodeName()); 
					if (nElementsKey.getNodeType() == Node.ELEMENT_NODE) {
						Element elementValue = (Element) nElementsKey;
			            Text nodeKeyValue = documentNew.createTextNode(elementValue.getTextContent());
			            keyNode.appendChild(nodeKeyValue);
					}
		            itemNode.appendChild(keyNode);
		    	}
	            raiz.appendChild(itemNode);
			}
    	}
		
        //Generate XML
        Source source = new DOMSource(documentNew);
        //Indicamos donde lo queremos almacenar
        Result result = new StreamResult(new File("src\\config\\car\\car_config.xml")); //nombre del archivo
        Transformer transformer;
		try {
			transformer = TransformerFactory.newInstance().newTransformer();
	        try {
				transformer.transform(source, result);
			} catch (TransformerException e) {
				e.printStackTrace();
			}
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			e.printStackTrace();
		}
		
		System.out.println("[INFO] - Nuevo XML creado");
		setVisible(false);
		new Selection_model(this.configLoad, this.language, this.username, this.client);
	}
	
	private void backActionPerformed(ActionEvent ae) {
		setVisible(false);
		new Selection_model(this.configLoad, this.language, this.username, this.client);
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
