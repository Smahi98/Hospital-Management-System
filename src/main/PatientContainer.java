package main;


import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;


	public class PatientContainer  {
		private Patient patient;

		private ContainerController container;
		@SuppressWarnings("unused")
		
		public static void main(String[] args) {
		}
		
		public PatientContainer() throws StaleProxyException {
			Runtime rt = Runtime.instance();
			ProfileImpl profile = new ProfileImpl(false);
			profile.setParameter(ProfileImpl.MAIN_HOST, "localhost");
			profile.setParameter(ProfileImpl.CONTAINER_NAME, "Patient");
			

			
			container = rt.createAgentContainer(profile); 
		    @SuppressWarnings("unused")
			AgentController agentControler= container.createNewAgent("Patient","main.Patient", new Object[] {this});
	

		    ((AgentController) container).start();
		}
	
		public Patient getPatient() {
			return patient;
		}

		public void setPatient(Patient patient) {
			this.patient = patient;
		}

		

		
	}

	

