package main;

import java.util.Map;
import java.util.*;

import jade.core.AID;
import jade.core.behaviours.CyclicBehaviour;
import jade.gui.GuiAgent;
import jade.gui.GuiEvent;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class Pharmaceutique extends GuiAgent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PatientGui gui;
	
	
	protected void setup() {
		gui=new PatientGui();
		gui=(PatientGui) getArguments()[0];
		System.out.println("demarrage de l'agent Patient ");
		addBehaviour(new CyclicBehaviour(){
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void action() {
				
				@SuppressWarnings("unused")
			
				ACLMessage aclMessage=receive();
				if(aclMessage!=null) {
					gui.showMessage("content"+aclMessage.getContent(),true);
					gui.showMessage("Onthology"+aclMessage.getOntology(), true);
					
					
					
				}
				else 
					block();
				
				
				
				
			}
			
			
		});
		
		
		
		
		
		
	}
	
	public void onGuiEvent(GuiEvent e) {
		// TODO Auto-generated method stub
		switch (e.getType()) {
		case 1:
			@SuppressWarnings({ "unused", "unchecked" }) Map<String, Object> params=(Map<String,Object>) e.getParameter(0);
			@SuppressWarnings("unused") String Medicament=(String)params.get("Medicament");
			@SuppressWarnings("unused") String AgentName=(String)params.get("AgentName");
			@SuppressWarnings("unused") ACLMessage aclMessage=new ACLMessage(ACLMessage.REQUEST);
			aclMessage.addReceiver(new AID(AgentName,AID.ISLOCALNAME));
			aclMessage.setContent(Medicament);
			aclMessage.setOntology("Covid");
			send(aclMessage);
			break;
			default:
				break;
		}
		
		
		
	}

}