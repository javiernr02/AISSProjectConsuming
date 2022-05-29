package aiss.model.resources;

import java.util.Arrays;

import java.util.Collection;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.Vuelos;



public class VuelosResource {
	
	
	private String uri = "https://proyectoentregableapiones.ew.r.appspot.com/api/v1/vuelos";
	
	
	
	public Collection<Vuelos> getAll(){
		
		ClientResource cr = null;
		Vuelos [] vuelos = null;
		try {
			cr = new ClientResource(uri);
			vuelos = cr.get(Vuelos[].class);
			
		} catch(ResourceException re) {
			System.err.println("Error when retrieving the collections of flights: " + cr.getResponse().getStatus());
		}
		return Arrays.asList(vuelos);
	}
	
	
	
	
	
	public Vuelos getVuelo(String vueloId) {
		
		ClientResource cr = null;
		Vuelos vuelo = null;
		try {
			cr = new ClientResource(uri + "/" + vueloId);
			vuelo = cr.get(Vuelos.class);
			
		} catch (ResourceException re) {
			System.err.println("Error when retrieving the flight: " + cr.getResponse().getStatus());
		}
		return vuelo;
	}
	
	
	
	
	
	public Vuelos addVuelo(Vuelos v) {
		
		ClientResource cr = null;
		Vuelos vuelo = null;
		try {
			cr = new ClientResource(uri);
			cr.setEntityBuffering(true);
			vuelo = cr.post(v, Vuelos.class);
			
		} catch (ResourceException re) {
			System.err.println("Error when adding the flight: " + cr.getResponse().getStatus());
		}
		return vuelo;
	}
	
	
	
	
	
	public boolean updateVuelo(Vuelos v) {
		
		ClientResource cr = null;
		boolean success = true;
		try {
			cr = new ClientResource(uri);
			cr.setEntityBuffering(true);
			cr.put(v);
			
		} catch (ResourceException re) {
			System.err.println("Error when updating the flight: " + cr.getResponse().getStatus());
			success = false;
		}
		return success;
	}
	
	
	
	
	
	public boolean deleteVuelo(String vueloId) {
		
		ClientResource cr = null;
		boolean success = true;
		try {
			cr = new ClientResource(uri + "/" + vueloId);
			cr.setEntityBuffering(true);
			cr.delete();
			
		} catch (ResourceException re) {
			System.err.println("Error when deleting the flight: " + cr.getResponse().getStatus());
			success = false;
		}
		return success;
	}
}
