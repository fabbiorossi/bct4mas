package behav;

import agents.CAAgent;
import fabric.SdkIntegration;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
//import org.apache.log4j.Logger;
import org.hyperledger.fabric.sdk.User;

public class CAAgentCyclicBehaviour extends CyclicBehaviour {

    //private static final Logger log = Logger.getLogger(CAAgentCyclicBehaviour.class);
    private static final long serialVersionUID = -9130778517255356467L;

    private CAAgent caAgent;
    private String agentToRegister = null;
    private String[] messageParts = null;

    public CAAgentCyclicBehaviour(CAAgent agent) {
        super(agent);
        caAgent = agent;
    }

    @Override
    public void onStart() {

        try {
            System.out.println("####### Sto qui ######");
            SdkIntegration.enrollAdminInHF();
            System.out.println("#######  ######");

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    public void action() {

        ACLMessage message = caAgent.receive();

        if (message != null) {
            switch (message.getPerformative()) {
                case ACLMessage.REQUEST:
                    try {

                        System.out.println(message);


                        messageParts = message.getContent().split("/");
                        agentToRegister = messageParts[0]; // parts[0] equivale a bcAgent.getLocalName() del
                        // mittente
                        //log.info("Loading certificate for " + agentToRegister);

                        // TODO: verificare che l'agente non sia nella "lista dei cattivi" (Chiedere ad
                        // Alevtina)

                        System.out.println("REGISTRATOOOOOOOOOOOO");

                        // create or get the certificate if already exist
                        User fabricUser = SdkIntegration.registerOrGetUserInHF(agentToRegister);
                        //log.info(fabricUser);
                        sendReplyMessageInteract(message);

                        //log.info(agentToRegister + " can now interact with fabric network");
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    break;

                default:
                    //log.info(caAgent.getName() + " received a message that can't handle");
                    break;

            }
        } else {
            this.block();
        }
    }


    /**
     * With this message the agent that required the certificate will know that he can from now
     * interact with the fabric network
     *
     * @param msg
     */
    private void sendReplyMessageInteract(ACLMessage msg) {

        ACLMessage reply = msg.createReply();
        reply.setPerformative(ACLMessage.INFORM);
        reply.setContent("interact");
        caAgent.send(reply);

    }

}
