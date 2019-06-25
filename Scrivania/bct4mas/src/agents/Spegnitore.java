package agents;

import behav.RichiediSwitchLuci;
import behav.PrintResponse;
import jade.core.Agent;


public class Spegnitore extends Agent {

    protected void setup(){

        //this.addBehaviour(new RegisterToDF(this, ));
        this.addBehaviour(new RichiediSwitchLuci(this, 5000));

        this.addBehaviour(new PrintResponse(this));

    }

}
