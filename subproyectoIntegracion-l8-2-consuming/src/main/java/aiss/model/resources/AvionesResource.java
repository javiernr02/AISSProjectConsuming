package aiss.model.resources;

import java.util.Arrays;

import java.util.Collection;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.Aviones;


public class AvionesResource {
	
	
	private String uri = "https://proyectoentregableapiones.ew.r.appspot.com/api/v1/aviones";
	
	
	
	public Collection<Aviones> getAll(){
		
		ClientResource cr = null;
		Aviones [] aviones = null;
		try {
			cr = new ClientResource(uri);
			aviones = cr.get(Aviones[].class);
			
		} catch(ResourceException re) {
			System.err.println("Error when retrieving the collections of planes: " + cr.getResponse().getStatus());
		}
		return Arrays.asList(aviones);
	}
	
	
	
	
	
	public Aviones getAvion(String avionId) {
		
		ClientResource cr = null;
		Aviones avion = null;
		try {
			cr = new ClientResource(uri + "/" + avionId);
			avion = cr.get(Aviones.class);
			
		} catch(ResourceException re) {
			System.err.println("Error when retrieving the plane: " + cr.getResponse().getStatus());
		}
		return avion;
	}
	
	
	
	
	
	public Aviones addAvion(Aviones a) {
		
		ClientResource cr = null;
		Aviones avion = null;
		try {
			cr = new ClientResource(uri);
			cr.setEntityBuffering(true);
			avion = cr.post(a, Aviones.class);
			
		} catch(ResourceException re) {
			System.err.println("Error when adding the plane: " + cr.getResponse().getStatus());
		}
		return avion;
	}
	
	
	
	
	
	public boolean updateAvion(Aviones a) {
		
		ClientResource cr = null;
		boolean success = true;
		try {
			cr = new ClientResource(uri);
			cr.setEntityBuffering(true);
			cr.put(a);
			
		} catch(ResourceException re) {
			System.err.println("Error when updating the flight: " + cr.getResponse().getStatus());
			success = false;
		}
		return success;
	}
}
