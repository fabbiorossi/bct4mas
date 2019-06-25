/*package Main;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class FinestraConBottone {

	Container contenuto = null;
	
	public FinestraConBottone() {
		
		JFrame finestra = new JFrame("ESEMPIO CON LISTENER");
		finestra.setBounds(500, 500, 180, 200);
		contenuto = finestra.getContentPane();
		contenuto.setLayout(new BoxLayout(contenuto, BoxLayout.Y_AXIS));
		
		JButton b1 = new JButton("Bottone 1");
		contenuto.add(b1);
		
		JTextField cognome = new JTextField();
		//cognome.setPreferredSize(new Dimension(100, 20));
		//cognome.addKeyListener(new intercettaTasti());
		cognome.addKeyListener((KeyListener) new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				JTextField casellaTesto = (JTextField) e.getSource();
				String testo = casellaTesto.getText();
				casellaTesto.setText(testo.toUpperCase());
			}
		});
		contenuto.add(cognome);
		
		b1.addActionListener(new clicBottone());;
		
		finestra.setVisible(true);
		finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	private class clicBottone implements ActionListener {
		public void actionPerformed(ActionEvent evento) {
			contenuto.setBackground(Color.CYAN);
			PrimoFrameJB pfJB= new PrimoFrameJB();
			pfJB.setVisible(true);
		}
	}
	
	private class intercettaTasti implements KeyListener {
		
		@Override
		public void keyPressed(KeyEvent e) {}
		
		@Override 
		public void keyReleased(KeyEvent e) {
			JTextField casellaTesto = (JTextField) e.getSource();
			String testo = casellaTesto.getText();
			casellaTesto.setText(testo.toUpperCase());
		}
		
		@Override
		public void keyTyped(KeyEvent arg0) {
			
		}
	}

}
*/