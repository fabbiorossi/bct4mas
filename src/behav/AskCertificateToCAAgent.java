package behav;

import agents.TAgent;
import agents.CAAgent;
import jade.core.AID;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import org.apache.log4j.Logger;

public class AskCertificateToCAAgent extends OneShotBehaviour {

    private static final Logger log = Logger.getLogger(AskCertificateToCAAgent.class);


    private static final long serialVersionUID = -2998600208928485834L;
    TAgent tAgent;

    public AskCertificateToCAAgent(TAgent a) {
        super(a); // call the ticker behaviour every second (why not a CyclicBehaviour directly?)
        tAgent = a;
    }

    @Override
    public void action() {
        // TODO Auto-generated method stub
        askCertificate();
    }

    /**
     * the BCAgent ask certificate sending a ACLMessage to CAAgent
     */
    private void askCertificate() {
        try {
            log.info(tAgent.getLocalName() + " Asking for a certificate...");

            // ask to CAagent to get a user certificate

            sendAskCertificateRequestMessage();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void sendAskCertificateRequestMessage() {
        ACLMessage askCertificateMsg = new ACLMessage(ACLMessage.REQUEST);
        askCertificateMsg.setContent(tAgent.getLocalName() + "/" + "askCertificate");
        askCertificateMsg.addReceiver(new AID(CAAgent.AGENT_NAME, AID.ISLOCALNAME));
        System.out.println("CIAOCIAOCIAO");
        myAgent.send(askCertificateMsg);
    }

}
