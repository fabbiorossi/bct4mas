package behav;

import main.MainFrame;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

import javax.swing.*;

public class ReceiveMsg extends CyclicBehaviour {

    private MainFrame frame;
    private boolean lights;
    private boolean door;

    public ReceiveMsg(Agent a, MainFrame fra){
        super(a);
        frame = fra;
        lights = true;
    }

    public void action(){

        ACLMessage request = this.myAgent.receive(MessageTemplate.MatchPerformative(ACLMessage.REQUEST));
        ACLMessage request2 = this.myAgent.receive(MessageTemplate.MatchPerformative(ACLMessage.CONFIRM));

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
                    lights = false;
                    ImageIcon newimg = new ImageIcon("resource/casa-luce+portachiusa.jpg");
                    frame.getFirstframe().setImageHome(newimg);
                    System.out.println(this.myAgent.getLocalName() + ": La luce è spenta.");
                    break;
                }
                case "TurnOnLight": {
                    System.out.println(this.myAgent.getLocalName() + ": La luce era spenta.");
                    ImageIcon newimg = new ImageIcon("resource/casa+luce+portachiusa.jpg");
                    lights = true;
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

        if (request2 != null && request2.getSender().getLocalName().equals("Maggiordomo")){

            System.out.println(this.myAgent.getLocalName() + ": ho ricevuto una richiesta da " +
                    request2.getSender().getName());

            switch (request2.getConversationId()){
                case "Open":{
                    if(lights){
                        ImageIcon newimg = new ImageIcon("resource/casa+luce+portaaperta.jpg");
                        frame.getFirstframe().setImageHome(newimg);
                    } else {
                        ImageIcon newimg = new ImageIcon("resource/casa-luce+portaaperta.jpg");
                        frame.getFirstframe().setImageHome(newimg);
                    }

                    System.out.println(this.myAgent.getLocalName() + ": La porta è aperta.");
                    break;
                }
                case "Close": {
                    if(lights){
                        ImageIcon newimg = new ImageIcon("resource/casa+luce+portachiusa.jpg");
                        frame.getFirstframe().setImageHome(newimg);
                    } else {
                        ImageIcon newimg = new ImageIcon("resource/casa-luce+portachiusa.jpg");
                        frame.getFirstframe().setImageHome(newimg);
                    }

                    System.out.println(this.myAgent.getLocalName() + ": La porta è chiusa.");
                    break;
                }
            }

        } else {
            this.block();
        }

    }

}
