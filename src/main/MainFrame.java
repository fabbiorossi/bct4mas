package main;

import javax.swing.*;

public class MainFrame extends JFrame {

    public FirstFrame firstframe;
    public MainFrame(){

        super("BCT4MAS");
        this.setBounds(500, 500, 850, 650);
        firstframe = new FirstFrame();
        this.setContentPane(firstframe.getMainPanel());


        //this.pack();
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public FirstFrame getFirstframe(){
        return firstframe;
    }
}
