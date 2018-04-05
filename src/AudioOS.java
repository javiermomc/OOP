import java.io.BufferedInputStream;
import java.io.FileInputStream;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class AudioOS implements Runnable{
	
	FileInputStream input;
	BufferedInputStream buffer = null;
	int frameClip;
	Player clip = null;
	String songName;
	Thread td;
	boolean playing=false;
	
	public void playFile(String song){
		try {
			input = new FileInputStream(song+".mp3");
			buffer = new BufferedInputStream(input);
			clip = new Player(buffer);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			clip.play();
			playing=true;
		} catch (JavaLayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			playing=false;
		}
	}
	
	public boolean findSong(String song){
		try {
			input = new FileInputStream(song+".mp3");
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public void stop(){
		if(playing){
			clip.close();
			td.interrupt();
		}
		playing=false;
	}
	
	public boolean isPlaying(){
		return playing;
	}
	
	public static void main(String args[]){
		AudioOS audio = new AudioOS();
		audio.play("El Mono de Alambre");
	}

	public boolean play(String song){
		songName = song;
		if(findSong(song)){
			td = new Thread(this);
			td.start();
			return true;
		}
		return false;
	}
	
	@Override
	public void run() {
		playFile(songName);
	}
}
