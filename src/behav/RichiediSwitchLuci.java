package behav;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;

public class RichiediSwitchLuci extends TickerBehaviour {

    public RichiediSwitchLuci(Agent a, long period)
    {
        super(a, period);
    }

    public void onTick()
    {
        ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
        msg.addReceiver(new AID("Prova", AID.ISLOCALNAME));
        msg.setConversationId("SwitchDoor");
        myAgent.send(msg);

    }
}
