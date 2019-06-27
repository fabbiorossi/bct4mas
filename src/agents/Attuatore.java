package agents;

import behav.ReceiveMsg;
import jade.core.Agent;
import Main.MainFrame;


public class Attuatore extends Agent {

    private MainFrame mainframe;

    public Attuatore(MainFrame mainframe){
        setMainframe(mainframe);
    }
    protected void setup(){

        this.addBehaviour(new ReceiveMsg(this, getMainframe()));

    }

    public void setMainframe(MainFrame mainframe) {
        this.mainframe = mainframe;
    }

    public MainFrame getMainframe(){
        return mainframe;
    }
}
