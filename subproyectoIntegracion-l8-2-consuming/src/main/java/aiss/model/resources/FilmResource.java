package aiss.model.resources;

import java.util.Arrays;
import java.util.Collection;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.Film;



public class FilmResource {
	
	private String uri = "https://aiss-integracion-l8g1.ey.r.appspot.com/api/films";
	private static final String NETFLIX_API_KEY = "consumo";
	
	
	
	public Collection<Film> getAll() {
		ClientResource cr = null;
		Film [] films = null;
		try {
			cr = new ClientResource(uri);
			films = cr.get(Film[].class);
			
		} catch (ResourceException re) {
			System.err.println("Error when retrieving all films: " + cr.getResponse().getStatus());
			throw re;
		}
		
		return Arrays.asList(films);
	}

	public Collection<Film> filtradoPorScore(String rango) {
		ClientResource cr = null;
		Film [] films = null;
		try {
			cr = new ClientResource(uri + "?score=" + rango);
			films = cr.get(Film[].class);
			
		} catch (ResourceException re) {
			System.err.println("Error when retrieving all films: " + cr.getResponse().getStatus());
			throw re;
		}
		
		return Arrays.asList(films);
	}
	
	public Film getFilm(String filmId) {
		
		ClientResource cr = null;
		Film film = null;
		try {
			cr = new ClientResource(uri + "/" + filmId);
			film = cr.get(Film.class);
			
		} catch (ResourceException re) {
			System.err.println("Error when retrieving the film: " + cr.getResponse().getStatus());
			throw re;
		}
		
		return film;
	}
	
	public Film addFilm(Film film) {
		// TODO
		
		ClientResource cr = null;
		Film resultFilm = null;
		try {
			cr = new ClientResource(uri + "?token="+ NETFLIX_API_KEY);
			cr.setEntityBuffering(true);
			resultFilm = cr.post(film, Film.class);
			
		} catch (ResourceException re) {
			System.err.println("Error when adding the film: " + cr.getResponse().getStatus());
			throw re;
		}
		
		return resultFilm;

	}
	
	public boolean updateFilm(Film film) {
		// TODO
		
		ClientResource cr = null;
		boolean success = true;
		try {
			cr = new ClientResource(uri + "?token="+ NETFLIX_API_KEY);
			cr.setEntityBuffering(true);
			cr.put(film);
			
		} catch (ResourceException re) {
			System.err.println("Error when updating the film: " + cr.getResponse().getStatus());
			success = false;
			throw re;
		}
		
		return success;
	}
	public boolean deleteFilm(String filmId) {
		ClientResource cr = null;
		boolean success = true;
		try {
			cr = new ClientResource(uri + "/" + filmId + "?token="+ NETFLIX_API_KEY);
			cr.setEntityBuffering(true);		// Needed for using RESTlet from JUnit tests
			cr.delete();
			
		} catch (ResourceException re) {
			System.err.println("Error when deleting the film: " + cr.getResponse().getStatus());
			success = false;
			throw re;
		}
		
		return success;
		
	}
	
}


