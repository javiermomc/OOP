import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class AudioTunesGUI extends JFrame implements ActionListener, ListSelectionListener{

	JPanel panelUser, panelArtists, panelAlbums, panelSongs, panelAudio,
		panelMain;
	JButton bCatalog, bArtist, bAlbums, bSongs,
		bPlay, bStop;
	JTextField tfArtist, tfAlbum, tfSong;
	JTextArea taArtists, taAlbums, taSongs;
	AudioOS audio = new AudioOS();
	AudioAD audioAD = new AudioAD();
	
	Vector artists, songs, albums;
	JList artistList, songList, albumList;
	
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
		
		taArtists = new JTextArea("Artists", 1, 10);
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
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==bSongs){
			// Get db attributes
			songs = audioAD.getSongsVector(tfAlbum.getText());
			songList = new JList(songs);
			songList.addListSelectionListener(this);
			
			// Set text on text areas
			panelSongs.setVisible(false);
			panelSongs.removeAll();
			panelSongs.add(songList);
			panelSongs.setVisible(true);
		}
		else if(e.getSource()==bAlbums){
			// Get db attributes
			albums = audioAD.getAlbumsVector(tfArtist.getText());
			
			albumList = new JList(albums);
			albumList.addListSelectionListener(this);
			
			// Set text on text areas
			panelAlbums.setVisible(false);
			panelAlbums.removeAll();
			panelAlbums.add(albumList);
			panelAlbums.setVisible(true);
		}
		else if(e.getSource()==bCatalog){
			// Get db attributes
			artists = audioAD.getArtistsVector();
			
			artistList = new JList(artists);
			artistList.addListSelectionListener(this);
			
			// Set text on text areas
			panelArtists.setVisible(false);
			panelArtists.removeAll();
			panelArtists.add(artistList);
			panelArtists.setVisible(true);
		}else if(e.getSource()==bPlay){
			if(!audio.play(tfSong.getText()))
				tfSong.setText("Not found");
		}else if(e.getSource()==bStop){
			if(audio.isPlaying())
				audio.stop();
		}
	}
	
	public void valueChanged(ListSelectionEvent ls){
		if(ls.getValueIsAdjusting()==true){
			if(ls.getSource()==artistList){
				String desiredArtist;
				desiredArtist = (String)artistList.getSelectedValue();
				tfArtist.setText(desiredArtist);
				
				// Get db attributes
				albums = audioAD.getAlbumsVector(tfArtist.getText());
				
				albumList = new JList(albums);
				albumList.addListSelectionListener(this);
				
				// Set text on text areas
				panelAlbums.setVisible(false);
				panelAlbums.removeAll();
				panelAlbums.add(albumList);
				panelAlbums.setVisible(true);
			}else if(ls.getSource()==albumList){
				String desiredAlbum;
				desiredAlbum = (String)albumList.getSelectedValue();
				tfAlbum.setText(desiredAlbum);
				
				// Get db attributes
				songs = audioAD.getSongsVector(tfAlbum.getText());
				songList = new JList(songs);
				songList.addListSelectionListener(this);
				
				// Set text on text areas
				panelSongs.setVisible(false);
				panelSongs.removeAll();
				panelSongs.add(songList);
				panelSongs.setVisible(true);
			}else if(ls.getSource()==songList){
				String desiredSong;
				desiredSong = (String)songList.getSelectedValue();
				tfSong.setText(desiredSong);
			}
		}	
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AudioTunesGUI();
	}

}
