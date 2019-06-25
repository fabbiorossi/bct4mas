package agents;

import behav.ReceiveMsg;
import jade.core.Agent;


public class GestoreLuci extends Agent {

    protected void setup(){

        System.out.println("Sono il gestore delle luci "+getAID());

        this.addBehaviour(new ReceiveMsg(this, false, false));

    }


}
