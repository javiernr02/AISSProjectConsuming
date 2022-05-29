package aiss.model.resources;

import java.util.Arrays;
import java.util.Collection;

import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.Librarie;



public class LibrarieResource {
	
	private String uri = "https://aiss-integracion-l8g1.ey.r.appspot.com/api/libraries";
	private static final String NETFLIX_API_KEY = "consumo";
	
	public Collection<Librarie> getAll() {
			
			ClientResource cr = null;
			Librarie [] lists = null;
			try {
				cr = new ClientResource(uri + "?token=" + NETFLIX_API_KEY);
				lists = cr.get(Librarie[].class);
				
			} catch (ResourceException re) {
				System.err.println("Error when retrieving the collections of libraries: " + cr.getResponse().getStatus());
			}
			
			return Arrays.asList(lists);
		}
	public Librarie getLibrarie(String librarieId) {
			
			ClientResource cr = null;
			Librarie list = null;
			try {
				cr = new ClientResource(uri + "/" + librarieId + "?token=" + NETFLIX_API_KEY);
				list = cr.get(Librarie.class);
				
			} catch (ResourceException re) {
				System.err.println("Error when retrieving the librarie: " + cr.getResponse().getStatus());
			}
			
			return list;
	
		}
	
	public boolean updateLibrarie(Librarie l) {
		ClientResource cr = null;
		boolean success = true;
		try {
			cr = new ClientResource(uri + "?token=" + NETFLIX_API_KEY);
			cr.setEntityBuffering(true);		// Needed for using RESTlet from JUnit tests
			cr.put(l);
			
			
		} catch (ResourceException re) {
			System.err.println("Error when updating the librarie: " + cr.getResponse().getStatus());
			success = false;
		}
		
		return success;
	}
	
	
	public Librarie addLibrarie(Librarie l) {
			
			ClientResource cr = null;
			Librarie resultLibrarie = null;
			try {
				cr = new ClientResource(uri + "?token=" + NETFLIX_API_KEY);
				cr.setEntityBuffering(true);		// Needed for using RESTlet from JUnit tests
				resultLibrarie = cr.post(l,Librarie.class);
				
			} catch (ResourceException re) {
				System.err.println("Error when adding the librarie: " + cr.getResponse().getStatus());
			}
			
			return resultLibrarie;
		}
	
	public Librarie addLike(String librarieId) {
		
		ClientResource cr = null;
		Librarie resultLibrarie = null;
		try {
			cr = new ClientResource(uri + "/"+ librarieId  +  "?token=" + NETFLIX_API_KEY);
			cr.setEntityBuffering(true);		// Needed for using RESTlet from JUnit tests
			resultLibrarie = cr.post(null,Librarie.class);
			
		} catch (ResourceException re) {
			System.err.println("Error when adding the librarie: " + cr.getResponse().getStatus());
		}
		
		return resultLibrarie;
	}
	
	
	public boolean deleteLibrarie(String librarieId) {
		ClientResource cr = null;
		boolean success = true;
		try {
			cr = new ClientResource(uri + "/" + librarieId + "?token=" + NETFLIX_API_KEY);
			cr.setEntityBuffering(true);		// Needed for using RESTlet from JUnit tests
			cr.delete();
			
		} catch (ResourceException re) {
			System.err.println("Error when deleting the librarie: " + cr.getResponse().getStatus());
			success = false;
		}
		
		return success;
	}
	
	public boolean addFilm(String librarieId, String filmId) {
		
		
		ClientResource cr = null;
		boolean success = true;
		try {
			cr = new ClientResource(uri + "/" + librarieId + "/" + filmId + "?token=" + NETFLIX_API_KEY);
			cr.setEntityBuffering(true);
			cr.post(" ");
			
		} catch (ResourceException re) {
			System.err.println("Error when adding the song to the playlist: "
					+ cr.getResponse().getStatus());
			success = false;
		}
		return success;
		
	}
	
	public boolean removeFilm(String librarieId, String filmId) {
		// TODO
		
		ClientResource cr = null;
		boolean success = true;
		try {
			cr = new ClientResource(uri + "/" + librarieId + "/" + filmId + "?token=" + NETFLIX_API_KEY);
			cr.setEntityBuffering(true);
			cr.delete();
			
		} catch (ResourceException re) {
			System.err.println("Error when deleting the film of the librarie: " + cr.getResponse()
			.getStatus());
			success = false;
		}
		
		return success;
	}
	
	

}
