package view_miglayout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.ScrollPane;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import config.ConfigurationLoader;
import idao.ILanguage;
import model.Client;
import model.PresupuestoXML;

import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;

public class Albaran extends JFrame {

	// Atributos globales.
	private ILanguage language;
	private ConfigurationLoader configLoad;
	private Client client;
	private String username;
	private File temp;
	private File budget;
	
	// Atributos de la clase.
	private JPanel contentPane;
	private JButton btn_GoClient;
	

	/**
	 * Create the frame.
	 */
	public Albaran(ConfigurationLoader configLoad, ILanguage language, String username, Client client) {
		this.configLoad = configLoad;
		this.language = language;
		this.username = username;
		this.client = client;
		this.contentPane = new JPanel();
		this.contentPane.setLayout(new MigLayout("insets 30"));
		this.contentPane.setBackground(new Color(255, 255, 255));
		this.btn_GoClient = new JButton(language.btnStart());
		this.btn_GoClient.setFont(new java.awt.Font("Tahoma", 0, 12));
		this.btn_GoClient.setBackground(new Color(215,18,43));
		this.btn_GoClient.setForeground(new Color(255,255,255));
		this.btn_GoClient.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(215, 18, 43)),
				BorderFactory.createEmptyBorder(5,10,5,10)
				));
		this.temp = new File(this.configLoad.getTemporalPathFile());
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		this.budget = new File(this.configLoad.getBudgetPathFile() + "fs_employee_" + timeStamp + ".txt");
		
		JTextArea ta = new JTextArea();
		ta.setEditable(false);
		ta.setOpaque(false);
		FileReader fr;
		
		try {
			fr = new FileReader(this.temp);
			BufferedReader br = new BufferedReader(fr);
			String linea = br.readLine();
			
			while((linea = br.readLine()) != null) {
				ta.setText(ta.getText() + linea + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.contentPane.add(ta, "wrap, pushx, growx, pushy, growy");
		this.contentPane.add(this.btn_GoClient, "pushx, pushy, align right");
		generateXMLBudget();
		generateBudget();
		
		
		addFrame(configLoad, contentPane, language.labelDeliveryNote());
	}
	
	private void generateXMLBudget() {
		try {
			FileReader fr = new FileReader(this.temp);
			BufferedReader br = new BufferedReader(fr);
			int i = 0;
			String line;
			
			//creamos el xml del presupuesti
			PresupuestoXML xml = new PresupuestoXML();
			
			try {
				while((line = br.readLine())!=null) {
					if(line.contains("[Empleado]")) {
						System.out.println("[INFO] - Empleado encontrado!");
						xml.setEmployee(line);
					}
					
					if(line.contains("[Cliente]")) {
						xml.setClient(line.substring(10));
					}
					
					if(line.contains("[Modelo]")) {
						xml.setModel(line.substring(9));
					}
					
					if(line.contains("[Motor]")) {
						xml.setEngine(line.substring(8));
					}
					
					if(line.contains("[Accesorios]")) {
						while(!(line = br.readLine()).contains("------")) {
							xml.setAccessories(line);
						}
						//PRICE
						line = br.readLine();
						xml.setPrice(Double.parseDouble(line.replace(',', '.')));
					}
				}
				System.out.println(xml.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			xml.headerXML();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void generateBudget() {
		try {
			FileReader fr = new FileReader(this.temp);
			BufferedReader br = new BufferedReader(fr);
			FileWriter fw = new FileWriter(this.budget);
			BufferedWriter bw = new BufferedWriter(fw);
			String line = br.readLine();
			
			while((line = br.readLine()) != null) {
				bw.write(line);
				bw.newLine();
			}
			
			br.close();
			fr.close();
			bw.close();
			fw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
