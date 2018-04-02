import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.peer.PanelPeer;
import java.util.Vector;
import java.util.concurrent.BrokenBarrierException;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;

public class AudioTunesGUI extends JFrame implements ActionListener{

	JPanel panelUser, panelArtists, panelAlbums, panelSongs, panelAudio,
		panelMain;
	JButton bCatalog, bArtist, bAlbums, bSongs,
		bPlay, bStop;
	JTextField tfArtist, tfAlbum, tfSong;
	JTextArea taArtists, taAlbums, taSongs;
	AudioOS audio = new AudioOS();
	AudioAD audioAD = new AudioAD();
	
	String artists, songs, albums;
	
	public AudioTunesGUI(){
		
		// Define objects
		
		tfArtist = new JTextField(10);
		tfAlbum = new JTextField(10);
		tfSong = new JTextField(10);
		
		bCatalog = new JButton("Catalog");
		bArtist = new JButton("Artist");
		bAlbums = new JButton("Albums");
		bSongs = new JButton("Songs");
		bPlay = new JButton("Play");
		bStop = new JButton("Stop");
		
		taArtists = new JTextArea("Artists", 15, 10);
		taAlbums = new JTextArea("Albums");
		taSongs = new JTextArea("Songs", 15, 10);
		
		panelUser = new JPanel();
		panelArtists = new JPanel();
		panelAlbums = new JPanel();
		panelSongs = new JPanel();
		panelAudio = new JPanel();
		panelMain = new JPanel();
		
		// Define button actions
		bCatalog.addActionListener(this);
		bArtist.addActionListener(this);
		bAlbums.addActionListener(this);
		bSongs.addActionListener(this);
		bPlay.addActionListener(this);
		bStop.addActionListener(this);
		
		// Define panel layouts
		panelUser.setLayout(new FlowLayout());
		panelArtists.setLayout(new GridLayout(1, 1));
		panelAlbums.setLayout(new GridLayout(1,1));
		panelSongs.setLayout(new GridLayout(1,1));
		panelAudio.setLayout(new FlowLayout());
		panelMain.setLayout(new BorderLayout());
		
		// Place attributes from objects in their respective panels
		panelUser.add(bCatalog);
		panelUser.add(new JLabel("Artista: "));
		panelUser.add(tfArtist);
		panelUser.add(bAlbums);
		panelUser.add(tfAlbum);
		panelUser.add(bSongs);
		
		panelArtists.add(new JScrollPane(taArtists));
		panelAlbums.add(new JScrollPane(taAlbums));
		panelSongs.add(new JScrollPane(taSongs));
		
		panelAudio.add(new JLabel("Song: "));
		panelAudio.add(tfSong);
		panelAudio.add(bPlay);
		panelAudio.add(bStop);
		
		panelMain.add(panelUser, BorderLayout.NORTH);
		panelMain.add(panelArtists, BorderLayout.WEST);
		panelMain.add(panelAlbums, BorderLayout.CENTER);
		panelMain.add(panelSongs, BorderLayout.EAST);
		panelMain.add(panelAudio, BorderLayout.SOUTH);
		
		// Add the main panel to JFrame
		add(panelMain);
		
		setSize(700, 400);
		setTitle("Audio Tunes Tec");
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==bSongs){
			// Get db attributes
			songs = audioAD.getSongs(tfAlbum.getText());
			
			// Set text on text areas
			taSongs.setText("Songs:\n"+songs);
		}
		else if(e.getSource()==bAlbums){
			// Get db attributes
			albums = audioAD.getAlbums(tfArtist.getText());
			
			// Set text on text areas
			taAlbums.setText("Albums:\n"+albums);
		}
		else if(e.getSource()==bCatalog){
			// Get db attributes
			artists = audioAD.getArtists();
			
			// Set text on text areas
			taArtists.setText("Artistas:\n"+artists);
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AudioTunesGUI();
	}

}
