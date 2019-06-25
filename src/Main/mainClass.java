package Main;

import javax.swing.*;

//import jade.core.AgentContainer;
import agents.GestoreLuci;
import agents.Spegnitore;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.core.*;
import jade.lang.acl.ACLMessage;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.ControllerException;
import jade.wrapper.StaleProxyException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Thread.sleep;

public class mainClass {
			
	public static void main(String[] args) {

		MainFrame a = new MainFrame();
		Runtime runtime = Runtime.instance();
		Profile profile = new ProfileImpl();
		ContainerController mainContainer = runtime.createMainContainer(profile);


		try {

			Agent agent1 = new GestoreLuci(a);
			AgentController ac = mainContainer.acceptNewAgent("Prova", agent1);
			ac.start();


			//Agent agent2 = new Spegnitore();
			//AgentController ac2 = mainContainer.acceptNewAgent("Spegnitore",agent2);
			//ac2.start();


			a.getFirstframe().getButton2().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent actionEvent) {
					try {
						String b = a.getFirstframe().getBoxRep();
						Agent agent2 = new Spegnitore(b);
						AgentController ac2 = mainContainer.acceptNewAgent("Spegnitore", agent2);
						ac2.start();
						try {
							sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						ac2.kill();
						System.out.println("Agent killed");
					} catch(StaleProxyException sp){
						sp.printStackTrace();
					}
				}
			});

		}
		catch(StaleProxyException spe){
			spe.printStackTrace();
		}

	}

}
