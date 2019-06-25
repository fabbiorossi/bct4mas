package behav;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

public class SendMessage extends OneShotBehaviour {

    public String action;

    public SendMessage(Agent a, String act){
        super(a);
        action = act;
    }

    public void action()
    {
        ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
        msg.addReceiver(new AID("Prova", AID.ISLOCALNAME));
        msg.setConversationId(action);
        myAgent.send(msg);

    }
}
