package agents;

import behav.ControlAccess;
import behav.ReceiveSensMsg;
import behav.PrintResponse;
import jade.core.Agent;


public class Maggiordomo extends Agent {

    protected void setup(){

        this.addBehaviour(new ReceiveSensMsg(this));
        this.addBehaviour(new PrintResponse(this));
        this.addBehaviour(new ControlAccess(this));

    }

}
