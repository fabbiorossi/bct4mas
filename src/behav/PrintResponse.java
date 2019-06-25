package behav;

import jade.core.behaviours.CyclicBehaviour;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class PrintResponse extends CyclicBehaviour {

    public PrintResponse(Agent a){
        super(a);
    }

    public void action(){

        ACLMessage response = this.myAgent.receive(MessageTemplate.MatchPerformative(ACLMessage.INFORM));

        if (response != null)
        {
            System.out.println(this.myAgent.getLocalName() + ": "+response.getContent());
        }
        else
        {
            this.block();
        }

    }
}
