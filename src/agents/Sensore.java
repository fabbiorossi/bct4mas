package agents;

import behav.ControlAccess;
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
        this.addBehaviour(new ControlAccess(this));

    }

    public void RequestAccess(String user){
        ACLMessage msg = new ACLMessage(ACLMessage.PROPOSE);
        msg.addReceiver(new AID("Sensore", AID.ISLOCALNAME));
        if(user.equals("Dottore")){
            msg.setConversationId("Open");
        } else if(user.equals("Ladro")){
            msg.setConversationId("Close");
        }
        this.send(msg);
    }

}
