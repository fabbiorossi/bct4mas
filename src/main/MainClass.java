package main;

import agents.*;
import com.google.gson.Gson;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.swing.text.TabableView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;


public class MainClass {

    public static final String HF_CONFIG_FILE= "resource/configHF.json";

    public static void main(String[] args) {

        MainFrame mainframe = new MainFrame();
        Runtime runtime = Runtime.instance();
        Profile profile = new ProfileImpl();
        ContainerController mainContainer = runtime.createMainContainer(profile);


        try {

            CAAgent agent0 = new CAAgent();
            AgentController ac0 = mainContainer.acceptNewAgent("CAAgent", agent0);
            ac0.start();

            /*Maggiordomo agent1 = new Maggiordomo();
            AgentController ac1 = mainContainer.acceptNewAgent("Maggiordomo", agent1);
            ac1.start();

            Sensore agent2 = new Sensore(2);
            AgentController ac2 = mainContainer.acceptNewAgent("Sensore", agent2);
            ac2.start();

            Attuatore agent3 = new Attuatore(mainframe);
            AgentController ac3 = mainContainer.acceptNewAgent("Attuatore", agent3);
            ac3.start();*/

            try{
                Thread.sleep(5000);
            }
            catch (InterruptedException e)
            {e.printStackTrace();}

            TAgent agent4 = new TAgent();
            AgentController ac4 = mainContainer.acceptNewAgent("Test", agent4);
            ac4.start();

            /*mainframe.getFirstframe().getButton1().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    String a = String.valueOf(mainframe.getFirstframe().getBoxDoor().getSelectedItem());
                    agent2.RequestAccess(a);
                }
            });*/

        } catch (StaleProxyException spe) {
            spe.printStackTrace();
        }

    }


    public static HFJson2Pojo getHfJsonConfig(String configFile) {

        HFJson2Pojo hfJson2Pojo;
        Reader inputStreamReader = getReaderFromResourceFilePath(HF_CONFIG_FILE);
        hfJson2Pojo = new Gson().fromJson(inputStreamReader, HFJson2Pojo.class);

        return hfJson2Pojo;
    }

    private static Reader getReaderFromResourceFilePath(String configFile) {
        //Get file from resources folder
        InputStream inputStream = getInputStream(configFile);
        return new InputStreamReader(inputStream);
    }

    private static InputStream getInputStream(String configFile) {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        return classLoader.getResourceAsStream(configFile);
    }

}
