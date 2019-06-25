package agents;

import behav.ReceiveMsg;
import jade.core.Agent;
import Main.MainFrame;


public class GestoreLuci extends Agent {

    public MainFrame mainframe;

    public GestoreLuci(MainFrame mainframe){
        setMainframe(mainframe);
    }
    protected void setup(){

        System.out.println("Sono il gestore delle luci "+getAID());

        this.addBehaviour(new ReceiveMsg(this, true, false, getMainframe()));

    }

    public void setMainframe(MainFrame mainframe) {
        this.mainframe = mainframe;
    }

    public MainFrame getMainframe(){
        return mainframe;
    }
}
