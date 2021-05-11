package main;


import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;


	public class DocteurContainer  {
		private Docteur docteur;

		private ContainerController container;
		@SuppressWarnings("unused")
		
		public static void main(String[] args) {
		}
		
		public DocteurContainer() throws StaleProxyException {
			Runtime rt = Runtime.instance();
			ProfileImpl profile = new ProfileImpl(false);
			profile.setParameter(ProfileImpl.MAIN_HOST, "localhost");
			profile.setParameter(ProfileImpl.CONTAINER_NAME, "Docteur");
			

			
			container = rt.createAgentContainer(profile); 
		    @SuppressWarnings("unused")
			AgentController agentControler= container.createNewAgent("Docteur","main.Docteur", new Object[] {this});
	

		    ((AgentController) container).start();
		}
	
		public Docteur getDocteur() {
			return docteur;
		}

		public void setDocteur(Docteur docteur) {
		}

		

		
	}

	

