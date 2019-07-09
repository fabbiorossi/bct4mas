package agents;

import jade.core.Agent;
import behav.CAAgentCyclicBehaviour;

public class CAAgent extends Agent {

    public static final String AGENT_NAME = "CAAgent";


    @Override
    protected void setup() {

        // addBehaviour(new CAagentCyclicBehaviourRetaggi(this));
        addBehaviour(new CAAgentCyclicBehaviour(this));

    }


}
