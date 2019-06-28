package behav;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import java.time.LocalTime;

public class ReceiveSensMsg extends CyclicBehaviour {

    private LocalTime time;
    private final LocalTime NIGHT = LocalTime.of(20,00);
    private final LocalTime DAY = LocalTime.of(8,00);
    private boolean lights;
    private final String TURNOFF = "TurnOffLight";
    private final String TURNON = "TurnOnLight";


    public ReceiveSensMsg(Agent a){
        super(a);
        lights = true;
    }

    public void action(){


        ACLMessage request = this.myAgent.receive(MessageTemplate.MatchPerformative(ACLMessage.INFORM));



        if (request != null)
        {

            System.out.println(this.myAgent.getLocalName() + ": ho ricevuto un messaggio da " +
                    request.getSender().getName());
            time = LocalTime.parse(request.getConversationId());

            ACLMessage agree = request.createReply();
            agree.setPerformative(ACLMessage.AGREE);

            agree.setContent("Valore ricevuto");

            this.myAgent.send(agree);


            if((time.isAfter(DAY) || time.equals(DAY)) && time.isBefore(NIGHT)){

                if(lights) {

                    ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
                    msg.addReceiver(new AID("Attuatore", AID.ISLOCALNAME));
                    msg.setConversationId(TURNOFF);
                    lights = false;
                    myAgent.send(msg);

                } else {System.out.println("La luce e' gia' spenta!");}
            } else {
                if (time.isAfter(NIGHT) || time.equals(NIGHT) || time.isBefore(DAY)) {
                    if (!lights) {

                        ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
                        msg.addReceiver(new AID("Attuatore", AID.ISLOCALNAME));
                        msg.setConversationId(TURNON);
                        lights = true;
                        myAgent.send(msg);

                    } else System.out.println("La luce e' gia' accesa!");
                }
            }

        }
        else
        {
            this.block();
        }


    }

}
