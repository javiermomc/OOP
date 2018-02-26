import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioOS {
	
	Clip clip;
	AudioInputStream input = null;
	int frameClip;
	File dir = new File("Sound.wav");
	
	public AudioOS(){
		try {
			clip = AudioSystem.getClip();
		} catch (LineUnavailableException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public boolean play(String song){
		try {
			if(!clip.isOpen()){
				dir = new File(song+".wav");
				if(dir.exists()){
					input = AudioSystem.getAudioInputStream(dir);
					clip.open(input);
					clip.start();
					return true;
				}
			}else{
				clip.close();
				dir = new File(song+".wav");
				if(dir.exists()){
					input = AudioSystem.getAudioInputStream(dir);
					clip.open(input);
					clip.start();
					return true;
				}
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
		return false;
	}
	public void stop(){
//		frameClip=clip.getFramePosition();
		clip.stop();
//		clip.setFramePosition(frameClip);
	}
}
