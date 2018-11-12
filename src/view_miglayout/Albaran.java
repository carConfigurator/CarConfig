package view_miglayout;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextArea;

import config.ConfigurationLoader;
import config.language.ELanguage;
import config.language.Language;
import model.Client;
import model.PresupuestoXML;

public class Albaran extends JFrame {

	// Atributos globales.
	private Language language;
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
	public Albaran(ConfigurationLoader configLoad, Language language, String username, Client client) {
		this.configLoad = configLoad;
		this.language = language;
		this.username = username;
		this.client = client;
		this.contentPane = new JPanel();
		this.contentPane.setLayout(new MigLayout("insets 30"));
		this.contentPane.setBackground(new Color(255, 255, 255));
		this.btn_GoClient = new JButton(language.getText(ELanguage.btnStart));
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
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(this.temp);
			br = new BufferedReader(fr);
			String linea = br.readLine();
			
			while((linea = br.readLine()) != null) {
				ta.setText(ta.getText() + linea + "\n");
			}
			fr.close();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fr.close();
				br.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}

		this.contentPane.add(ta, "wrap, pushx, growx, pushy, growy");
		this.contentPane.add(this.btn_GoClient, "pushx, pushy, align right");
		generateXMLBudget();
		generateBudget();
		deleteTemp();
		
		this.btn_GoClient.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				loginActionPerformed(e);
			}
		});
		
		addFrame(configLoad, contentPane, language, language.getText(ELanguage.deliveryNoteTitle));
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
				fr.close();
				br.close();
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
	
	private void deleteTemp() {
        if (this.temp.exists()) {
            try {
                FileReader fr = new FileReader(this.temp);
                BufferedReader br = new BufferedReader(fr);
                FileWriter fw = new FileWriter(this.temp);
                BufferedWriter bw = new BufferedWriter(fw);
                String line = br.readLine();

                while((line = br.readLine()) != null) {
                    bw.write("");
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
	
	private void loginActionPerformed(ActionEvent e) {
		deleteTemp();
		setVisible(false);
		new Data_Clients(this.configLoad, this.language, this.username, new Client(), false);
	}
}