package behav;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;


public class ControlAccess extends CyclicBehaviour {

    public ControlAccess(Agent a)
    {
        super(a);
    }

    public void action(){

        ACLMessage response = this.myAgent.receive(MessageTemplate.MatchPerformative(ACLMessage.PROPOSE));

        if (response != null)
        {
            System.out.println(this.myAgent.getLocalName() + ": "+response.getConversationId());
            if(response.getConversationId().equals("Open")){
                System.out.println("APERTO");
            }

        }
        else
        {
            this.block();
        }
    }
}
