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



public class PatientGui extends JFrame{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	private JLabel jLabelAgent=new JLabel("Nom Du Patient:");
	private JTextField jTextFieldAgent=new JTextField(12);
	private JLabel jLabelPrescriptions=new JLabel("Prescriptions:");
	private JTextField jTextFieldPrescriptions=new JTextField(12);
	private JButton jButtonConsulter=new JButton("Consulter");
	private JTextArea jTextAreaMess=new JTextArea();
	private Patient patient;
	@SuppressWarnings("unused")
	
	JFrame F = new JFrame("Patient");
	
	public JTextArea getjTextAreaMess() {
		return jTextAreaMess;
	}
	public void setjTextAreaMess(JTextArea jTextAreaMess) {
		this.jTextAreaMess = jTextAreaMess;
	}
	public JButton getjButtonConsulter() {
		return jButtonConsulter;
	}
	public void setjButtonConsulter(JButton jButtonConsulter) {
		this.jButtonConsulter = jButtonConsulter;
	}
	public JTextField getjTextFieldPrescriptions() {
		return jTextFieldPrescriptions;
	}
	public void setjTextFieldPrescriptions(JTextField jTextFieldPrescriptions) {
		this.jTextFieldPrescriptions = jTextFieldPrescriptions;
	}
	public JLabel getjLabelPrescriptions() {
		return jLabelPrescriptions;
	}
	public void setjLabelPrescriptions(JLabel jLabelPrescriptions) {
		this.jLabelPrescriptions = jLabelPrescriptions;
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
	
	public PatientGui() {
		jTextAreaMess.setFont(new Font("Arial",Font.BOLD,13));
		JPanel jPanelN=new JPanel();
		jPanelN.setLayout(new FlowLayout());
		jPanelN.add(jLabelAgent);
		jPanelN.add(jTextFieldAgent);
		jPanelN.add(jLabelPrescriptions);
		jPanelN.add(jTextFieldPrescriptions);
		jPanelN.add(jButtonConsulter);

		this.setLayout(new BorderLayout());
		this.add(jPanelN,BorderLayout.NORTH);
		this.add(new JScrollPane(jTextAreaMess),BorderLayout.CENTER);
		this.setSize(600, 400);
		this.setVisible(true);
		jButtonConsulter.addActionListener(new ActionListener (){
			
			

		@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String AgentName =jTextFieldAgent.getText();
				String Prescriptions=jTextFieldPrescriptions.getText();
				GuiEvent gev=new GuiEvent(this,1);
				@SuppressWarnings("unchecked")
				Map<String,Object> params=(Map<String, Object>) new HashMap();
				params.put("agent", AgentName);
				params.put("Prescriptions",Prescriptions);
				gev.addParameter(params);
				patient.onGuiEvent(gev);
				
			}
		
			
			
			
 		}); 
		
		
			
			
		}
	
	
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		PatientGui GUI = new PatientGui();
	}
	
	public void showMessage(String msg,boolean append) {
		
		if(append==true) {
			jTextAreaMess.append(msg+"\n");
		}
		else
			jTextAreaMess.setText(msg);
		
	}
	
	
	
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	
	
		
	}