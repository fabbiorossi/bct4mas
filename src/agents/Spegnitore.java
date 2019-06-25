package agents;

import behav.RichiediSwitchLuci;
import behav.PrintResponse;
import behav.SendMessage;
import jade.core.Agent;


public class Spegnitore extends Agent {

    public String action;

    public Spegnitore(String act){
        action = act;
    }
    protected void setup(){

        //this.addBehaviour(new RegisterToDF(this, ));
        //this.addBehaviour(new RichiediSwitchLuci(this, 5000));
        this.addBehaviour(new SendMessage(this, action));

        this.addBehaviour(new PrintResponse(this));

    }

}
