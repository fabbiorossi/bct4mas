package behav;

import Main.MainFrame;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

import javax.swing.*;

public class ReceiveMsg extends CyclicBehaviour {

    private boolean lights;
    private boolean door;
    public MainFrame frame;

    public ReceiveMsg(Agent a, boolean lig, boolean doo,MainFrame fra){
        super(a);
        lights = lig;
        door = doo;
        frame = fra;
    }

    public void action(){

        /*ACLMessage request = this.myAgent.receive(MessageTemplate.and(MessageTemplate.MatchPerformative(ACLMessage.REQUEST),
                MessageTemplate.MatchConversationId("SwitchLight")));*/
        ACLMessage request = this.myAgent.receive(MessageTemplate.MatchPerformative(ACLMessage.REQUEST));

        System.out.println(request);

        if (request != null)
        {

            System.out.println(this.myAgent.getLocalName() + ": ho ricevuto una richiesta da " +
                    request.getSender().getName());

            ACLMessage agree = request.createReply();
            agree.setPerformative(ACLMessage.AGREE);

            agree.setContent("richiesta accettata");

            this.myAgent.send(agree);

            switch (request.getConversationId()){
                case "SwitchLight": {
                    if(lights) {
                        System.out.println(this.myAgent.getLocalName() + ": La luce era accesa.");
                        lights = false;
                        ImageIcon newimg = new ImageIcon("resource/casa-luce+portachiusa.jpg");
                        frame.getFirstframe().setImageHome(newimg);
                        System.out.println(this.myAgent.getLocalName() + ": La luce è spenta.");
                    }
                    else{
                        System.out.println(this.myAgent.getLocalName() + ": La luce era spenta.");
                        lights = true;
                        ImageIcon newimg = new ImageIcon("resource/casa+luce+portachiusa.jpg");
                        frame.getFirstframe().setImageHome(newimg);
                        System.out.println(this.myAgent.getLocalName() + ": La luce è accesa.");
                    }
                    break;
                }

                case "SwitchDoor": {
                    if(door) {
                        System.out.println(this.myAgent.getLocalName() + ": La porta era aperta.");
                        door = false;
                        ImageIcon newimg = new ImageIcon("resource/casa+luce+portachiusa.jpg");
                        frame.getFirstframe().setImageHome(newimg);
                        System.out.println(this.myAgent.getLocalName() + ": La porta è chiusa.");
                    }
                    else{
                        System.out.println(this.myAgent.getLocalName() + ": La porta era chiusa.");
                        door = true;
                        ImageIcon newimg = new ImageIcon("resource/casa+luce+portaaperta.jpg");
                        frame.getFirstframe().setImageHome(newimg);
                        System.out.println(this.myAgent.getLocalName() + ": La porta è aperta.");
                    }
                    break;
                }
            }

            ACLMessage inform = request.createReply();
            inform.setPerformative(ACLMessage.INFORM);

            inform.setContent("Switch avvenuto");

            this.myAgent.send(inform);
        }
        else
        {
            this.block();
        }

    }

}
