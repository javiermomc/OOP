import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.Vector;

public class AudioAD {
	
	BufferedReader fileIn;
	
	String readFile(String fileName){
		// Define objects
		String item = "";
		String str = "";
		try{
			// Open data file
			fileIn = new BufferedReader(new FileReader(fileName));
			
			// Read data file
			while(fileIn.ready()){
				item = fileIn.readLine();
				str += item + "\n";
			}
			
			// Close file
			fileIn.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return str;
	}
	
	public String getArtists(){
		return readFile("Artistas.txt");
	}
	
	public String getAlbums(String artist){
		String albumsFile = readFile("Albums.txt");
		String artists = "";
		int tokens;
		StringTokenizer tokenizer = new StringTokenizer(albumsFile, "_,\n");
		tokens = tokenizer.countTokens();
		for(int i=0; i<tokens/2; i++){
			if(tokenizer.nextToken().equalsIgnoreCase(artist))
				artists += tokenizer.nextToken()+"\n";
			else tokenizer.nextToken();
		}
		return artists;
	}
	
	public String getSongs(String album){
		String songsFile = readFile("Songs.txt");
		String songs = "";
		int tokens;
		StringTokenizer tokenizer = new StringTokenizer(songsFile, "_,\n");
		tokens = tokenizer.countTokens();
		for(int i=0; i<tokens/2; i++)
			if(tokenizer.nextToken().equalsIgnoreCase(album))
				songs += tokenizer.nextToken()+"\n";
			else tokenizer.nextToken();
		return songs;
	}

}