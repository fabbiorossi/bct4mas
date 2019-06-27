package behav;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class IncreaseTime extends TickerBehaviour {

    private LocalTime time;
    private int timeplus;

    public IncreaseTime(Agent a, long period, int timeplus)
    {
        super(a, period);
        time = LocalTime.of(00,00);
        this.timeplus = timeplus;
    }

    public void onTick()
    {
        setTime(timeplus);
        ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
        msg.addReceiver(new AID("Maggiordomo", AID.ISLOCALNAME));
        msg.setConversationId(String.valueOf(getTime()));
        myAgent.send(msg);
        System.out.println("Sono l'agente " + this.myAgent.getLocalName() + " Sono le ore " + getTime());

    }

    public void setTime(int t) {
        this.time = this.time.plus(t, ChronoUnit.HOURS);
    }

    public LocalTime getTime() {
        return time;
    }
}
