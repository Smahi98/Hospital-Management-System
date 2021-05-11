package main;


import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;


	public class PharmaceutiqueContainer  {
		private Pharmaceutique Pharmaceutique;

		private ContainerController container;
		@SuppressWarnings("unused")
		
		public static void main(String[] args) {
		}
		
		public PharmaceutiqueContainer() throws StaleProxyException {
			Runtime rt = Runtime.instance();
			ProfileImpl profile = new ProfileImpl(false);
			profile.setParameter(ProfileImpl.MAIN_HOST, "localhost");
			profile.setParameter(ProfileImpl.CONTAINER_NAME, "Pharmaceutique");
			

			
			container = rt.createAgentContainer(profile); 
		    @SuppressWarnings("unused")
			AgentController agentControler= container.createNewAgent("Pharmaceutique","main.Pharmaceutique", new Object[] {this});
	

		    ((AgentController) container).start();
		}
	
		public Pharmaceutique getPharmaceutique() {
			return Pharmaceutique;
		}

		public void setPharmaceutique(Pharmaceutique pharmaceutique) {
		}

		

		
	}

	

