package agents;

import behav.*;
import jade.core.Agent;
import jade.core.behaviours.SequentialBehaviour;
import org.hyperledger.fabric.sdk.Channel;
import org.hyperledger.fabric.sdk.HFClient;
import org.hyperledger.fabric.sdk.User;

import java.util.ArrayList;

public class TAgent extends Agent {

    private String myName;
    private String myAddress;

    // Link with HF Blockchain
    private User user;
    private HFClient hfClient;
    private Channel hfServiceChannel;
    private Channel hfTransactionChannel;

    private String configurationType = null;

    //public ArrayList<ServiceView> servicesList = new ArrayList<>();


    protected void setup() {

        SequentialBehaviour sequentialBehaviour = bootAgentHouseWork();

        this.addBehaviour(sequentialBehaviour);

    }


    private SequentialBehaviour bootAgentHouseWork() {
        SequentialBehaviour sequentialBehaviour = new SequentialBehaviour();

        InitTAgent initTAgent = new InitTAgent(this);
        sequentialBehaviour.addSubBehaviour(initTAgent);

        AskCertificateToCAAgent askCertificateToCAAgent = new AskCertificateToCAAgent(this);
        sequentialBehaviour.addSubBehaviour(askCertificateToCAAgent);

        LoadCertificate loadCertificate = new LoadCertificate(this);
        sequentialBehaviour.addSubBehaviour(loadCertificate);

        LoadAgentInLedger loadAgentInLedger = new LoadAgentInLedger(this);
        sequentialBehaviour.addSubBehaviour(loadAgentInLedger);


        return sequentialBehaviour;
    }

    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }

    public String getMyAddress() {
        return myAddress;
    }

    public void setMyAddress(String myAddress) {
        this.myAddress = myAddress;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public HFClient getHfClient() {
        return hfClient;
    }

    public void setHfClient(HFClient hfClient) {
        this.hfClient = hfClient;
    }

    public Channel getHfServiceChannel() {
        return hfServiceChannel;
    }

    public void setHfServiceChannel(Channel hfServiceChannel) {
        this.hfServiceChannel = hfServiceChannel;
    }

    public Channel getHfTransactionChannel() {
        return hfTransactionChannel;
    }

    public void setHfTransactionChannel(Channel hfTransactionChannel) {
        this.hfTransactionChannel = hfTransactionChannel;
    }
}
