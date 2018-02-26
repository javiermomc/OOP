import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AudioGUI extends JPanel{
	
	Clip clip;
	AudioInputStream input = null;
	int frameClip;
	File dir = new File("Sound");
	JLabel soundLabel;
	
	public AudioGUI(){
		
		try {
			clip = AudioSystem.getClip();
		} catch (LineUnavailableException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JTextField nameFile = new JTextField(); 
		
		JButton playButton = new JButton("Play");
		JButton pauseButton = new JButton("Pausa");
		JButton exitButton = new JButton("Salir");
		
		soundLabel = new JLabel("No music playing");
		
		//Create actions for the buttons
		
		playButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//Play audio
				try {
					if(!clip.isOpen()){
						dir = new File(nameFile.getText()+".wav");
						if(dir.exists()){
							input = AudioSystem.getAudioInputStream(dir);
							clip.open(input);
							soundLabel.setText("Playing: "+nameFile.getText()+".wav");
						}else
							soundLabel.setText("  Not found  ");
					}
					clip.loop(0);
				} catch (LineUnavailableException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedAudioFileException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		
		pauseButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				frameClip=clip.getFramePosition();
				clip.stop();
				clip.setFramePosition(frameClip);
			}
			
		});
		
		exitButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//Destroys the object itself to close the window and close the program
				System.exit(0);
			}
			
		});
		
		// Set dimensions and display the frame
		
		FlowLayout layout = new FlowLayout();
		JLabel name = new JLabel(dir.getName());
		
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
	
//	public static void main(String args[]){
//	
//		AudioGUI ec = new AudioGUI();
//		JFrame frame = new JFrame();
//		frame.add(ec);
//		frame.pack();
//		frame.setSize(200, 170);
//		frame.setResizable(false);
//		frame.setVisible(true);
//	}
	
}
