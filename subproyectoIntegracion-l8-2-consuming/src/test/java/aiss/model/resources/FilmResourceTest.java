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





public class FilmResourceTest {
	
	static Film film1, film2, film3;
	static FilmResource fr = new FilmResource();
	
	@BeforeClass
	public static void setup() throws Exception {
		
		List<String> generos = new ArrayList<String>();
		List<String> idiomas = new ArrayList<String>();
		
		idiomas.add("English");
		generos.add("Crime Drama");
		
		// Test song 1
		film1 = fr.addFilm(new Film("Test title",generos,"11/08/2019",120, 8.5,null));
		
		// Test song 2
		film2 = fr.addFilm(new Film("Test title 2",generos,"12/09/2018",120, 9.3,null));
		
	}

	@AfterClass
	public static void tearDown() throws Exception {
		fr.deleteFilm(film1.getId());
		fr.deleteFilm(film3.getId());
	}
	

	@Test
	public void testGetAll() {
	Collection<Film> films = fr.getAll();
			
			assertNotNull("The collection of films is null", films);
			
			// Show result
			System.out.println("List of Films:");
			int i=1;
			for (Film f : films) {
				System.out.println("Film " + i++ + " : " + f.getTitle() + " (ID=" + f.getId() + ")");
			}
		}

	@Test
	public void testGetFilm() {
	Film f = fr.getFilm(film1.getId());
			
			// Comprobamos todos los atributos de pelicula
			assertEquals("The id of the films do not match", film1.getId(), f.getId());
			assertEquals("The title of the films do not match", film1.getTitle(), f.getTitle());
			assertEquals("The genre name of the films do not match", film1.getGenre(), f.getGenre());
			assertEquals("The premiere of the films do not match", film1.getPremiere(), f.getPremiere());
			assertEquals("The runtime of the films do not match", film1.getRuntime(), f.getRuntime());
			assertEquals("The score of the films do not match", film1.getScore(), f.getScore());
	
			// Show result
			System.out.println("Film id: " + f.getId());
			System.out.println("Film title: " + f.getTitle());
			System.out.println("Film genre: " + f.getGenre());
			System.out.println("Film premiere: " + f.getPremiere());
			System.out.println("Film runtime: " + f.getRuntime());
			System.out.println("Film score: " + f.getScore());

	}
	@Test
	public void testAddFilm() {
		//TODO
		
		List<String> generos = new ArrayList<String>();
		List<String> idiomas = new ArrayList<String>();
		String filmTitle = "Test title";
		String filmPremiere = "11-08-2019";
		Integer filmRuntime = 120;
		Double filmScore = 8.5;
		
		idiomas.add("English");
		generos.add("Crime Drama");
		
		film3 = fr.addFilm(new Film(filmTitle,generos,filmPremiere,filmRuntime, filmScore,null));
		
		assertNotNull("Error when adding the film", film3);
		assertEquals("The film's title has not been setted correctly", filmTitle, film3.getTitle());
		assertEquals("The song's name artist has not been setted correctly", generos, film3.getGenre());
		assertEquals("The song's album has not been setted correctly", filmPremiere, film3.getPremiere());
		assertEquals("The song's year has not been setted correctly", filmRuntime, film3.getRuntime());
		assertEquals("The song's year has not been setted correctly", filmScore, film3.getScore());

	}
	
	@Test
	public void testUpdateFilm() {
		
			String filmTitle = "Update song test title";
			String filmPremiere = "02-02-2012";
			Integer filmRuntime = 120;
			Double filmScore = 7.3;
			
			// Update song
			film1.setTitle(filmTitle);
			film1.setPremiere(filmPremiere);
			film1.setRuntime(filmRuntime);
			film1.setScore(filmScore);
			
			boolean success = fr.updateFilm(film1);
			
			assertTrue("Error when updating the song", success);
			
			Film film = fr.getFilm(film1.getId());
			assertEquals("The song's title has not been updated correctly", filmTitle, film.getTitle());
			
		}
	
	@Test(expected = ResourceException.class)
	public void testDeleteFilm() {
		
		// Delete films
		boolean success = fr.deleteFilm(film2.getId());
		
		assertTrue("Error when deleting the song", success);
		
		Film film  = fr.getFilm(film2.getId());
		assertNull("The song has not been deleted correctly", film);
	}
	
	
	@Test(expected = ResourceException.class)
	public void testUpdateFilmError() {
			
			String filmTitle = "Update song test title";
			
			// Update song
			Film film5 = new Film("Test error",null,"11/08/2019",120, 8.5,null);
			
			boolean success = fr.updateFilm(film5);
			
			assertTrue("Error when updating the song", success);
			
			Film film = fr.getFilm(film1.getId());
			assertEquals("The song's title has not been updated correctly", filmTitle, film.getTitle());
			
		}
	@Test(expected = ResourceException.class)
	public void testAddFilmError() {
		//TODO
		
		List<String> generos = new ArrayList<String>();
		List<String> idiomas = new ArrayList<String>();
		String filmTitle = "Test title";
		String filmPremiere = "11-08-2019";
		Integer filmRuntime = 120;
		Double filmScore = 8.5;
		
		idiomas.add("English");
		generos.add("Crime Drama");
		
		film3 = fr.addFilm(new Film(filmTitle,generos,filmPremiere,filmRuntime, filmScore,idiomas));
		
		assertNotNull("Error when adding the film", film3);
		assertEquals("The film's title has not been setted correctly", filmTitle, film3.getTitle());
		assertEquals("The song's name artist has not been setted correctly", generos, film3.getGenre());
		assertEquals("The song's album has not been setted correctly", filmPremiere, film3.getPremiere());
		assertEquals("The song's year has not been setted correctly", filmRuntime, film3.getRuntime());
		assertEquals("The song's year has not been setted correctly", filmScore, film3.getScore());

	}
	
	@Test(expected = ResourceException.class)
	public void testDeleteFilmError() {
		Film film5 = new Film("Test error",null,"11/08/2019",120, 8.5,null);
		// Delete films
		boolean success = fr.deleteFilm(film5.getId());
		
		assertTrue("Error when deleting the song", success);
		
		Film film  = fr.getFilm(film5.getId());
		assertNull("The song has not been deleted correctly", film);
	}
	
	

}
