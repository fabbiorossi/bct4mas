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

        ACLMessage response = this.myAgent.receive(MessageTemplate.MatchPerformative(ACLMessage.AGREE));
        ACLMessage response2 = this.myAgent.receive(MessageTemplate.MatchPerformative(ACLMessage.QUERY_IF));

        if (response != null)
        {
            System.out.println(this.myAgent.getLocalName() + ": "+response.getContent());
        }
        else
        {
            this.block();
        }

        if (response2 != null)
        {
            System.out.println(this.myAgent.getLocalName() + ": "+response2.getContent());
        }
        else
        {
            this.block();
        }

    }
}
