package aiss.model.resources;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.restlet.resource.ResourceException;

import aiss.model.Film;
import aiss.model.Librarie;




public class LibrarieResourceTest {
	
	static Librarie librarie, librarie2, librarie3, librarie4;
	static Film film;
	static LibrarieResource lr = new LibrarieResource();
	static FilmResource fr = new FilmResource();
	
	@BeforeClass
	public static void setUp() throws Exception {
		
		librarie = lr.addLibrarie(new Librarie("Test list 1", "description 1"));
		librarie2 = lr.addLibrarie(new Librarie("Test list 2", "description 2"));
		librarie3 = lr.addLibrarie(new Librarie("Test list 3", "description 3"));
		List<String> generos = new ArrayList<String>();
		generos.add("Crime Drama");
	
		film = fr.addFilm(new Film("Test title",generos,"11/08/2019",120, 8.5,null));
		if(film!=null)
			lr.addFilm(librarie.getId(), film.getId());
	}
	
	@AfterClass
	public static void tearDown() throws Exception {
		lr.deleteLibrarie(librarie.getId());
		lr.deleteLibrarie(librarie3.getId());
		lr.deleteLibrarie(librarie4.getId());
		if(film!=null)
			fr.deleteFilm(film.getId());
	}

	
	@Test
	public void testGetAll() {
	Collection<Librarie> libraries = lr.getAll(); 
			
			assertNotNull("The collection of playlists is null", libraries);
			
			// Show result
			System.out.println("Listing all playlists:");
			int i=1;
			for (Librarie pl : libraries) {
				System.out.println("Playlist " + i++ + " : " + pl.getName() + " (ID=" + pl.getId() + ")");
			}
			
	
		}
	@Test
	public void testGetLibrarie() {
		Librarie l = lr.getLibrarie(librarie.getId());
		
		assertEquals("The id of the playlists do not match", librarie.getId(), l.getId());
		assertEquals("The name of the playlists do not match", librarie.getName(), l.getName());
		
		// Show result
		System.out.println("Playlist id: " +  l.getId());
		System.out.println("Playlist name: " +  l.getName());

	}

	@Test
	public void testAddLibrarie() {
		String librarieName = "Add librarie test title";
		String librarieDescription = "Add librarie test description";
		
		librarie4 = lr.addLibrarie(new Librarie(librarieName,librarieDescription));
		
		assertNotNull("Error when adding the playlist", librarie4);
		assertEquals("The librarie's name has not been setted correctly", librarieName, librarie4.getName());
		assertEquals("The librarie's description has not been setted correctly", librarieDescription, librarie4.getDescription());
	}
	
	
	@Test(expected = ResourceException.class)
	public void testDeleteLibrarie() {
		
		boolean success = lr.deleteLibrarie(librarie2.getId());
		assertTrue("Error when deleting the librarie", success);
		
		Librarie l = lr.getLibrarie(librarie2.getId());
		assertNull("The libraire has not been deleted correctly", l);
	}

	@Test
	public void testAddFilm() {
		if(film!=null) {
			boolean success = lr.addFilm(librarie3.getId(), film.getId());
			assertTrue("Error when adding the film", success);
		}
	}

	@Test
	public void testRemoveFilm() {
		//TODO
		
		if(film!=null) {
			boolean success = lr.removeFilm(librarie3.getId(), film.getId());
			assertTrue("Error when deleting the film of the librarie", success);
		}
		
	}
	@Test
	public void testGetLibrarieError() {
		Librarie l = lr.getLibrarie("l38");
		
		assertEquals("The id of the playlists do not match", librarie.getId(), l.getId());
		assertEquals("The name of the playlists do not match", librarie.getName(), l.getName());
		
		// Show result
		System.out.println("Playlist id: " +  l.getId());
		System.out.println("Playlist name: " +  l.getName());

	}

	@Test(expected = ResourceException.class)
	public void testAddFilmError() {
		lr.addFilm("l500", "f63636");
		
	}
	
	@Test(expected = ResourceException.class)
	public void testDeleteLibrarieError() {
		
		boolean success = lr.deleteLibrarie("l500");
		assertTrue("Incorrect Id", success);
		
		
	}
	@Test
	public void testRemoveFilmError() {
		//TODO
		
		if(film!=null) {
			boolean success = lr.removeFilm("l500", "f63636");
			assertTrue("Incorrect Id", success);
		}
		
	}
	


}
