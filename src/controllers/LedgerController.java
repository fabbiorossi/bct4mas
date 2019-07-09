package controllers;

import model.dao.AgentDAO;
import org.hyperledger.fabric.sdk.Channel;
import org.hyperledger.fabric.sdk.HFClient;
import org.hyperledger.fabric.sdk.User;
import model.pojo.Agent;

public class LedgerController {



    public static boolean createAgent(HFClient clientHF, User userHF, Channel channel,
                                      String agentName, String agentAddress) throws Exception {

        AgentDAO agentDAO = new AgentDAO();

        Agent newAgent = new Agent();

        newAgent.setName(agentName);
        newAgent.setAddress(agentAddress);

        // TODO: Gestire creazione ID(incrementale)
        newAgent.setAgentId(agentName);

        boolean allPeerSuccess = agentDAO.create(clientHF, userHF, channel, newAgent);

        return allPeerSuccess;
    }
}
