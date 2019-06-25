package Main;

import javax.swing.*;

//import jade.core.AgentContainer;
import agents.GestoreLuci;
import agents.Spegnitore;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.core.*;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;

public class mainClass {
			
	public static void main(String[] args) {

		MainFrame a = new MainFrame();

		Runtime runtime = Runtime.instance();

		Profile profile = new ProfileImpl();

		ContainerController mainContainer = runtime.createMainContainer(profile);


		try {

			Agent agent1 = new GestoreLuci();
			AgentController ac = mainContainer.acceptNewAgent("Prova", agent1);
			ac.start();

			/*Agent agent2 = new Spegnitore();
			AgentController ac2 = mainContainer.acceptNewAgent("Spegnitore",agent2);
			ac2.start();*/

		}
		catch(StaleProxyException spe){
			spe.printStackTrace();
		}

	}

}
