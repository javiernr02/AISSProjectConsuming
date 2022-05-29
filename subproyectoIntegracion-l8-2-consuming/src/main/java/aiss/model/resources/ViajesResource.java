package aiss.model.resources;

import java.util.Arrays;

import java.util.Collection;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.Viajes;


public class ViajesResource {
	
	
	private String uri = "https://proyectoentregableapiones.ew.r.appspot.com/api/v1/viajes";
	
	
	
	public Collection<Viajes> getAll(){
		
		ClientResource cr = null;
		Viajes [] viajes = null;
		try {
			cr = new ClientResource(uri);
			viajes = cr.get(Viajes[].class);
			
		} catch(ResourceException re) {
			System.err.println("Error when retrieving the collections of trips: " + cr.getResponse().getStatus());
		}
		return Arrays.asList(viajes);
	}
	
	
	
	
	
	public Viajes getViaje(String viajeId) {
		
		ClientResource cr = null;
		Viajes viaje = null;
		try {
			cr = new ClientResource(uri + "/" + viajeId);
			viaje = cr.get(Viajes.class);
			
		} catch(ResourceException re) {
			System.err.println("Error when retrieving the trip: " + cr.getResponse().getStatus());
		}
		return viaje;
	}
	
	
	
	
	
	public Viajes addViaje(Viajes v) {
		
		ClientResource cr = null;
		Viajes viaje = null;
		try {
			cr = new ClientResource(uri);
			cr.setEntityBuffering(true);
			viaje = cr.post(v, Viajes.class);
			
		} catch(ResourceException re) {
			System.err.println("Error when adding the trip: " + cr.getResponse().getStatus());
		}
		return viaje;
	}
	
	
	
	
	
	public boolean addVuelo(String viajeId, String vueloId) {
		
		ClientResource cr = null;
		boolean success = true;
		try {
			cr = new ClientResource(uri + "/" + viajeId + "/" + vueloId);
			cr.setEntityBuffering(true);
			cr.post(" ");
			
		} catch(ResourceException re) {
			System.err.println("Error when adding the flight to the trip: " + cr.getResponse().getStatus());
			success = false;
		}
		return success;
	}
	
	
	
	
	
	public boolean updateViaje(Viajes v) {
		
		ClientResource cr = null;
		boolean success = true;
		try {
			cr = new ClientResource(uri);
			cr.setEntityBuffering(true);
			cr.put(v);
			
		} catch(ResourceException re) {
			System.err.println("Error when updating the trip: " + cr.getResponse().getStatus());
			success = false;
		}
		return success;
	}
	
	
	
	
	
	public boolean deleteViaje(String viajeId) {
		
		ClientResource cr = null;
		boolean success = true;
		try {
			cr = new ClientResource(uri + "/" + viajeId);
			cr.setEntityBuffering(true);
			cr.delete();
			
		} catch(ResourceException re) {
			System.err.println("Error when deleting the trip: " + cr.getResponse().getStatus());
			success = false;
		}
		return success;
	}
	
	
	
	
	
	public boolean deleteVuelo(String viajeId, String vueloId) {
		
		ClientResource cr = null;
		boolean success = true;
		try {
			cr = new ClientResource(uri + "/" + viajeId + "/" + vueloId);
			cr.setEntityBuffering(true);
			cr.delete();
			
		} catch(ResourceException re) {
			System.err.println("Error when removing the flight from the trip: " + cr.getResponse().getStatus());
			success = false;
		}
		return success;
	}
}
