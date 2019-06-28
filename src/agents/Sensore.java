package agents;

import behav.IncreaseTime;
import behav.PrintResponse;
import jade.core.AID;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;

public class Sensore extends Agent {

    private int timeplus;

    public Sensore(int timeplus){
        this.timeplus = timeplus;
    }

    protected void setup(){

        this.addBehaviour(new IncreaseTime(this, 5000,timeplus));
        this.addBehaviour(new PrintResponse(this));


    }

    public void RequestAccess(String user){
        ACLMessage msg = new ACLMessage(ACLMessage.PROPOSE);
        msg.addReceiver(new AID("Maggiordomo", AID.ISLOCALNAME));
        msg.setConversationId(user);
        this.send(msg);
    }

}
