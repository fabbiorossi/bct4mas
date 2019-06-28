package Main;

import agents.Attuatore;
import agents.Maggiordomo;
import agents.Sensore;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainClass {
			
	public static void main(String[] args) {

		MainFrame mainframe = new MainFrame();
		Runtime runtime = Runtime.instance();
		Profile profile = new ProfileImpl();
		ContainerController mainContainer = runtime.createMainContainer(profile);


		try {

			Maggiordomo agent1 = new Maggiordomo();
			AgentController ac1 = mainContainer.acceptNewAgent("Maggiordomo", agent1);
			ac1.start();

			Sensore agent2 = new Sensore(2);
			AgentController ac2 = mainContainer.acceptNewAgent("Sensore", agent2);
			ac2.start();

			Attuatore agent3 = new Attuatore(mainframe);
			AgentController ac3 = mainContainer.acceptNewAgent("Attuatore", agent3);
			ac3.start();

			mainframe.getFirstframe().getButton1().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent actionEvent) {
					String a = String.valueOf(mainframe.getFirstframe().getBoxDoor().getSelectedItem());
					agent2.RequestAccess(a);
				}
			});

		}
		catch(StaleProxyException spe){
			spe.printStackTrace();
		}

	}

}
