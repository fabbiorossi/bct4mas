package Main;

import javax.swing.*;

public class FirstFrame {
    private JPanel mainPanel;
    private JTabbedPane tabbedPaneMain;
    private JButton button1;
    private JPanel panelAgent;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JTabbedPane panel4;
    private JLabel imageHome;
    private JLabel behaviour;
    private JComboBox boxDoor;
    private JPanel panelMess;
    private JPanel panelBCT;
    private JPanel panelInvestigator;
    private JPanel panelHyperLedger;
    private JComboBox boxData;
    private JComboBox boxDataFrom;
    private JComboBox boxDataTo;
    private JButton button2;
    private JButton button3;
    private JComboBox boxLight;
    private JComboBox doorBox;
    private JLabel labelLight;
    private JLabel door;
    private ImageIcon newimg;

    /*public FirstFrame() {

        newimg = new ImageIcon("resource/casa-luce+portachiusa.jpg");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                System.out.println(getBoxAgent().getSelectedItem());
               imageHome.setIcon(newimg);
            }
        });

    }*/

    public JPanel getMainPanel(){
        return mainPanel;
    }

    public JComboBox getBoxDoor(){
        return boxDoor;
    }


    /*public ImageIcon setDimImage(String pathimage){
        ImageIcon imageIcon = new ImageIcon(pathimage);
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(400,600,Image.SCALE_SMOOTH);
        ImageIcon newImageIcon = new ImageIcon(newimg);
        return newImageIcon;

    }*/

    private void createUIComponents() {
        ImageIcon newImageIcon = new ImageIcon("resource/casa+luce+portachiusa.jpg");
        imageHome = new JLabel(newImageIcon);
    }
    public void setImageHome(ImageIcon image){
        imageHome.setIcon(image);
    }

    /*public JButton getButton2(){
        return button2;
    }*/

    public JButton getButton1(){
        return button1;
    }

    /*public String getBoxRep(){
        return (String) boxRep.getSelectedItem();
    }*/
}

