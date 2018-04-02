import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AudioGUI extends JPanel{
	
	JLabel soundLabel;
	String song;
	
	public AudioGUI(){
		
		JTextField nameFile = new JTextField(); 
		
		JButton playButton = new JButton("Play");
		JButton pauseButton = new JButton("Pausa");
		JButton exitButton = new JButton("Salir");
		
		soundLabel = new JLabel("No music playing");
		
		AudioOS audio = new AudioOS();
		
		//Create actions for the buttons
		
		playButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//Play audio
				if(audio.play(nameFile.getText()))
					soundLabel.setText("Playing: "+nameFile.getText()+".mp3");
				else
					soundLabel.setText("  Not found  ");
			}
			
		});
		
		pauseButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				soundLabel.setText("     Song stopped     ");
				audio.stop();
				
			}
			
		});
		
		exitButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//Destroys the object itself to close the window and close the program
				audio.stop();
				System.exit(0);
			}
			
		});
		
		// Set dimensions and display the frame
		
		FlowLayout layout = new FlowLayout();
		JLabel name = new JLabel(song);
		
		setLayout(layout);
		
		playButton.setPreferredSize(new Dimension(70,30));
		pauseButton.setPreferredSize(new Dimension(70,30));
		exitButton.setPreferredSize(new Dimension(70,30));
		name.setPreferredSize(new Dimension(120,30));
		nameFile.setPreferredSize(new Dimension(120,30));
		name.setHorizontalTextPosition(SwingConstants.CENTER);
		add(name);
		add(nameFile);
		add(playButton);
		add(pauseButton); 
		add(exitButton);
		add(soundLabel);
		
		
	}
	
	public static void main(String args[]){
	
		AudioGUI ec = new AudioGUI();
		JFrame frame = new JFrame();
		frame.add(ec);
		frame.pack();
		frame.setSize(180, 200);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
}
