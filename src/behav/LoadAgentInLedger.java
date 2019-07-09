package behav;

import agents.TAgent;

import controllers.LedgerController;
import jade.core.behaviours.OneShotBehaviour;
import org.apache.log4j.Logger;
import org.hyperledger.fabric.protos.common.Ledger;

/**
 * @author Valerio Mattioli @ HES-SO (valeriomattioli580@gmail.com)
 */
public class LoadAgentInLedger extends OneShotBehaviour {

    private static final Logger log = Logger.getLogger(LoadAgentInLedger.class);
    private static final long serialVersionUID = -1367559804806283124L;

    private TAgent tAgent;

    public LoadAgentInLedger(TAgent a) {
        super(a);
        tAgent = a;
    }

    @Override
    public void action() {
        log.info("Verifying if the Agent already exist in the Ledger");

    /*try {
        if (CheckerController.isAgentAlreadyInLedger(tAgent)) {
        log.info("The agent already exist in the Ledger");
      } else {
        log.info("The agent doesn't exist in the Ledger, I'll create it");

            boolean agentCreated;
            agentCreated = CreateController
              .createAgent(tAgent.getHfClient(), tAgent.getUser(), tAgent.getHfServiceChannel(),
                  tAgent.getMyName(), tAgent.getMyAddress());

            log.info("Agent " + tAgent.getMyName() + " created: " + agentCreated);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }*/


        log.info("The agent doesn't exist in the Ledger, I'll create it");

        boolean agentCreated;
        try {
            agentCreated = LedgerController
                    .createAgent(tAgent.getHfClient(), tAgent.getUser(), tAgent.getHfServiceChannel(),
                            tAgent.getMyName(), tAgent.getMyAddress());

            log.info("Agent " + tAgent.getMyName() + " created: " + agentCreated);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
