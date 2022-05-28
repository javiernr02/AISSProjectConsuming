package aiss.model.resources;

import static org.junit.Assert.*;
import java.util.Collection;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.restlet.resource.ResourceException;

import aiss.model.Playlist;
import aiss.model.Song;

public class SongResourceTest {

	static Song song1, song2, song3;
	static SongResource sr = new SongResource();
	
	@BeforeClass
	public static void setup() throws Exception {
		
		// Test song 1
		song1 = sr.addSong(new Song("Test title","Test artist","Test album","2016"));
		
		// Test song 2
		song2 = sr.addSong(new Song("Test title 2","Test artist 2","Test album 2","2017"));
		
	}

	@AfterClass
	public static void tearDown() throws Exception {
		sr.deleteSong(song1.getId());
		sr.deleteSong(song3.getId());
	}
	
	@Test
	public void testGetAll() {
		Collection<Song> songs = sr.getAll();
		
		assertNotNull("The collection of songs is null", songs);
		
		// Show result
		System.out.println("Listing all songs:");
		int i=1;
		for (Song s : songs) {
			System.out.println("Song " + i++ + " : " + s.getTitle() + " (ID=" + s.getId() + ")");
		}
	}

	@Test
	public void testGetSong() {
		//TODO
		
		Song s = sr.getSong(song1.getId());
		
		// Comprobamos todos los atributos de canción
		assertEquals("The id of the songs do not match", song1.getId(), s.getId());
		assertEquals("The title of the songs do not match", song1.getTitle(), s.getTitle());
		assertEquals("The artist name of the songs do not match", song1.getArtist(), s.getArtist());
		assertEquals("The album of the songs do not match", song1.getAlbum(), s.getAlbum());
		assertEquals("The year of the songs do not match", song1.getYear(), s.getYear());

		// Show result
		System.out.println("Song id: " + s.getId());
		System.out.println("Song title: " + s.getTitle());
		System.out.println("Song artist name: " + s.getArtist());
		System.out.println("Song album: " + s.getAlbum());
		System.out.println("Song year: " + s.getYear());

	}

	@Test
	public void testAddSong() {
		//TODO
		
		String songTitle = "Add song test title";
		String songNameArtist = "Add song test name artist";
		String songAlbum = "Add song test album";
		String songYear = "Add song test year";
		
		song3 = sr.addSong(new Song(songTitle, songNameArtist, songAlbum, songYear));
		
		assertNotNull("Error when adding the song", song3);
		assertEquals("The song's title has not been setted correctly", songTitle, song3.getTitle());
		assertEquals("The song's name artist has not been setted correctly", songNameArtist, song3.getArtist());
		assertEquals("The song's album has not been setted correctly", songAlbum, song3.getAlbum());
		assertEquals("The song's year has not been setted correctly", songYear, song3.getYear());

	}

	@Test
	public void testUpdateSong() {
		
		String songTitle = "Update song test title";
		String songArtist = "Update song test artist";
		String songAlbum = "Update song test album";
		String songYear = "1995";
		
		// Update song
		song1.setTitle(songTitle);
		song1.setArtist(songArtist);
		song1.setAlbum(songAlbum);
		song1.setYear(songYear);
		
		boolean success = sr.updateSong(song1);
		
		assertTrue("Error when updating the song", success);
		
		Song song  = sr.getSong(song1.getId());
		assertEquals("The song's title has not been updated correctly", songTitle, song.getTitle());
		assertEquals("The song's artist has not been updated correctly", songArtist, song.getArtist());
		assertEquals("The song's album has not been updated correctly", songAlbum, song.getAlbum());
		assertEquals("The song's year has not been updated correctly", songYear, song.getYear());
	}

	@Test(expected = ResourceException.class)
	public void testDeleteSong() {
		
		// Delete songs
		boolean success = sr.deleteSong(song2.getId());
		
		assertTrue("Error when deleting the song", success);
		
		Song song  = sr.getSong(song2.getId());
		assertNull("The song has not been deleted correctly", song);
	}

}
