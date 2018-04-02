import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.JavaSoundAudioDevice;
import javazoom.jl.player.Player;

public class AudioOS {
	
	FileInputStream input;
	BufferedInputStream buffer = null;
	int frameClip;
	Player clip = null;
	
	public AudioOS(){
	}
	
	public boolean play(String song){
		try {
			input = new FileInputStream(song+".mp3");
			buffer = new BufferedInputStream(input);
			clip = new Player(buffer);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		try {
			clip.play();
			System.out.println("Playing");
			return true;
		} catch (JavaLayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public void stop(){
		clip.close();
		System.out.println(clip);
	}
	
	public static void main(String args[]){
		
		AudioOS audio = new AudioOS();
		audio.play("El Mono de Alambre");
		audio.stop();
	}
}
