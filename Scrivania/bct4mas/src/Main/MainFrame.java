package Main;

import javax.swing.*;

public class MainFrame extends JFrame {

    public MainFrame(){

        super("BCT4MAS");
        this.setBounds(500, 500, 850, 650);
        FirstFrame fr = new FirstFrame();
        this.setContentPane(fr.getMainPanel());


        //finestra.pack();
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
