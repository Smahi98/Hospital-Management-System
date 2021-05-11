package main;

import java.util.Map;
import java.util.*;

import jade.core.AID;
import jade.core.behaviours.CyclicBehaviour;
import jade.gui.GuiAgent;
import jade.gui.GuiEvent;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class Patient extends GuiAgent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PatientGui gui;
	
	
	protected void setup() {
		gui=new PatientGui();
		gui.setPatient(this);
		System.out.println("demarrage de l'agent Patient ");
		addBehaviour(new CyclicBehaviour(){
			private int counter;
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void action() {
				MessageTemplate messageTemplate=
						MessageTemplate.and(MessageTemplate.MatchPerformative(ACLMessage.INFORM), MessageTemplate.MatchOntology("COVID"));
				
				
			
				ACLMessage aclMessage=receive(messageTemplate);
				if(aclMessage!=null) {
					gui.showMessage("Sender:"+aclMessage.getSender(), true);
					gui.showMessage("Acte de communication :"+ACLMessage.getPerformative(aclMessage.INFORM), true);
					gui.showMessage("content:"+aclMessage.getContent(),true);
					gui.showMessage("Langue:"+aclMessage.getLanguage(),true);

					
					
				}
				else 
					block();
				
				
				
				
			}

			@SuppressWarnings("unused")
			public int getCounter() {
				return counter;
			}			public void setCounter(int counter) {
				this.counter = counter;
			}
			
			
		});
		
		
		
		
		
		
	}
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Patient gui = new Patient();
	}
	
	public void onGuiEvent(GuiEvent gev) {
		// TODO Auto-generated method stub
		switch (gev.getType()) {
		case 1:
			@SuppressWarnings({ "unused", "unchecked" }) Map<String, Object> params=(Map<String,Object>) gev.getParameter(0);
			@SuppressWarnings("unused") String Prescriptions=(String)params.get("Prescriptions");
			@SuppressWarnings("unused") String Docteur=(String)params.get("Docteur");
			@SuppressWarnings("unused") ACLMessage aclMessage=new ACLMessage(ACLMessage.REQUEST);
			aclMessage.addReceiver(new AID(Docteur,AID.ISLOCALNAME));
			aclMessage.setContent(Prescriptions);
			aclMessage.setOntology("Covid");
			send(aclMessage);
			break;
			default:
				break;
		}
		
		
		
	}

}