package main;

import java.awt.BorderLayout;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import jade.gui.GuiEvent;
import jade.util.leap.HashMap;



public class DocteurGui extends JFrame{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private JLabel jLabelAgent=new JLabel("Type De Maladie:");
	private JTextField jTextFieldAgent=new JTextField(12);
	private JLabel jLabelMedicament=new JLabel(" Nom Du Medicament:");
	private JTextField jTextFieldMedicament=new JTextField(12);
	private JButton jButtonEnvoyer=new JButton("Demander Medicament");

	private JTextArea jTextAreaMess=new JTextArea();
	private Docteur Docteur;
	@SuppressWarnings("unused")
	
	JFrame F = new JFrame("Docteur");
	
	public JTextArea getjTextAreaMess() {
		return jTextAreaMess;
	}
	public void setjTextAreaMess(JTextArea jTextAreaMess) {
		this.jTextAreaMess = jTextAreaMess;
	}
	public JButton getjButtonEnvoyer() {
		return jButtonEnvoyer;}
	public void setjButtonEnvoyer(JButton jButtonEnvoyer) {
		this.jButtonEnvoyer = jButtonEnvoyer;
	}
	public JTextField getjTextFieldMedicament() {
		return jTextFieldMedicament;
	}
	public void setjTextFieldMedicament(JTextField jTextFieldMedicament) {
		this.jTextFieldMedicament = jTextFieldMedicament;
	}
	public JLabel getjLabelMedicament() {
		return jLabelMedicament;
	}
	public void setjLabelMedicament(JLabel jLabelMedicament) {
		this.jLabelMedicament = jLabelMedicament;
	}
	public JTextField getjTextFieldAgent() {
		return jTextFieldAgent;
	}
	public void setjTextFieldAgent(JTextField jTextFieldAgent) {
		this.jTextFieldAgent = jTextFieldAgent;
	}
	public JLabel getjLabelAgent() {
		return jLabelAgent;
	}
	public void setjLabelAgent(JLabel jLabelAgent) {
		this.jLabelAgent = jLabelAgent;
	}	
	
	public DocteurGui() {
		jTextAreaMess.setFont(new Font("Arial",Font.BOLD,13));

		JPanel jPanelN=new JPanel();
		jPanelN.setLayout(new FlowLayout());
		jPanelN.add(jLabelAgent);
		jPanelN.add(jTextFieldAgent);
		jPanelN.add(jLabelMedicament);
		jPanelN.add(jTextFieldMedicament);
		jPanelN.add(jButtonEnvoyer);
		this.setLayout(new BorderLayout());
		this.add(jPanelN,BorderLayout.NORTH);
		this.add(new JScrollPane(jTextAreaMess),BorderLayout.CENTER);
		this.setSize(800, 600);
		this.setVisible(true);
		jButtonEnvoyer.addActionListener(new ActionListener (){
			
			

		@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String AgentName =jTextFieldAgent.getText();
				String Medicament=jTextFieldMedicament.getText();
				GuiEvent gev=new GuiEvent(this,1);
				@SuppressWarnings("unchecked")
				Map<String,Object> params=(Map<String, Object>) new HashMap();
				params.put("agent", AgentName);
				params.put("Medicament",Medicament);
				gev.addParameter(params);
				Docteur.onGuiEvent(gev);
				
			}
		
			
			
			
		});
		
		
			
			
		}
	
	
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		DocteurGui GUI = new DocteurGui();
	}
	
	public void showMessage(String msg,boolean append) {
		
		if(append==true) {
			jTextAreaMess.append(msg+"\n");
		}
		else
			jTextAreaMess.setText(msg);
		
	}
	
	
	
	public Docteur getDocteur() {
		return Docteur;
	}
	public void setDocteur(Docteur Docteur) {
		this.Docteur = Docteur;
	}
	
	
	
	
		
	}