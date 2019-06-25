package behav;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class ReceiveMsg extends CyclicBehaviour {

    private boolean lights;
    private boolean window;


    public ReceiveMsg(Agent a, boolean lig, boolean win){
        super(a);
        lights = lig;
        window = win;
    }

    public void action(){

        /*ACLMessage request = this.myAgent.receive(MessageTemplate.and(MessageTemplate.MatchPerformative(ACLMessage.REQUEST),
                MessageTemplate.MatchConversationId("SwitchLight")));*/
        ACLMessage request = this.myAgent.receive(MessageTemplate.MatchPerformative(ACLMessage.REQUEST));

        System.out.println(request);

        if (request != null)
        {

            System.out.println(this.myAgent.getLocalName() + ": ho ricevuto una richiesta da " +
                    request.getSender().getName());

            ACLMessage agree = request.createReply();
            agree.setPerformative(ACLMessage.AGREE);

            agree.setContent("richiesta accettata");

            this.myAgent.send(agree);

            switch (request.getConversationId()){
                case "SwitchLight": {
                    if(lights) {
                        System.out.println(this.myAgent.getLocalName() + ": La luce era accesa.");
                        lights = false;
                        System.out.println(this.myAgent.getLocalName() + ": La luce è spenta.");
                    }
                    else{
                        System.out.println(this.myAgent.getLocalName() + ": La luce era spenta.");
                        lights = true;
                        System.out.println(this.myAgent.getLocalName() + ": La luce è accesa.");
                    }
                    break;
                }

                case "SwitchWindow": {
                    if(window) {
                        System.out.println(this.myAgent.getLocalName() + ": La finestra era aperta.");
                        lights = false;
                        System.out.println(this.myAgent.getLocalName() + ": La finestra è chiusa.");
                    }
                    else{
                        System.out.println(this.myAgent.getLocalName() + ": La finestra era chiusa.");
                        lights = true;
                        System.out.println(this.myAgent.getLocalName() + ": La finestra è aperta.");
                    }
                    break;
                }
            }

            ACLMessage inform = request.createReply();
            inform.setPerformative(ACLMessage.INFORM);

            inform.setContent("Switch avvenuto");

            this.myAgent.send(inform);
        }
        else
        {
            this.block();
        }

    }

}
