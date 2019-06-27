package behav;

import Main.MainFrame;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

import javax.swing.*;

public class ReceiveMsg extends CyclicBehaviour {

    private MainFrame frame;

    public ReceiveMsg(Agent a, MainFrame fra){
        super(a);
        frame = fra;
    }

    public void action(){

        ACLMessage request = this.myAgent.receive(MessageTemplate.MatchPerformative(ACLMessage.REQUEST));

        if (request != null && request.getSender().getLocalName().equals("Maggiordomo"))
        {
            System.out.println(this.myAgent.getLocalName() + ": ho ricevuto una richiesta da " +
                    request.getSender().getName());

            ACLMessage agree = request.createReply();
            agree.setPerformative(ACLMessage.AGREE);
            agree.addReceiver(new AID("Maggiordomo", AID.ISLOCALNAME));
            agree.setContent("richiesta accettata");
            this.myAgent.send(agree);


            switch (request.getConversationId()){
                case "TurnOffLight":{
                    System.out.println(this.myAgent.getLocalName() + ": La luce era accesa.");
                    ImageIcon newimg = new ImageIcon("resource/casa-luce+portachiusa.jpg");
                    frame.getFirstframe().setImageHome(newimg);
                    System.out.println(this.myAgent.getLocalName() + ": La luce è spenta.");
                    break;
                }
                case "TurnOnLight": {
                    System.out.println(this.myAgent.getLocalName() + ": La luce era spenta.");
                    ImageIcon newimg = new ImageIcon("resource/casa+luce+portachiusa.jpg");
                    frame.getFirstframe().setImageHome(newimg);
                    System.out.println(this.myAgent.getLocalName() + ": La luce è accesa.");
                    break;
                }
            }

            ACLMessage inform = request.createReply();
            inform.setPerformative(ACLMessage.QUERY_IF);
            inform.setContent("Switch avvenuto");
            inform.addReceiver(new AID("Maggiordomo", AID.ISLOCALNAME));
            this.myAgent.send(inform);
        }
        else
        {
            this.block();
        }

    }

}
