package aiss.model.resources;

import static org.junit.Assert.*;


import java.util.Collection;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import aiss.model.Viajes;
import aiss.model.Vuelos;

public class ViajesResourceTests {

	static Viajes viaje, viaje2, viaje3, viaje4;
	static Vuelos vuelo;
	static ViajesResource vjr = new ViajesResource();
	static VuelosResource vr = new VuelosResource();
	
	@BeforeClass
	public static void setUp() throws Exception {
		
		viaje = vjr.addViaje(new Viajes("Test trip 1"));
		viaje2 = vjr.addViaje(new Viajes("Test trip 2"));
		viaje3 = vjr.addViaje(new Viajes("Test trip 3"));
		
	
		vuelo = vr.addVuelo(new Vuelos("Test id","Test compania","Test horaLlegada","Test horaSalida","Test precio","Test escala"));
		if(vuelo!=null)
			vjr.addVuelo(viaje.getId(), vuelo.getId());
	}

	@AfterClass
	public static void tearDown() throws Exception {
		vjr.deleteViaje(viaje.getId());
		vjr.deleteViaje(viaje3.getId());
		vjr.deleteViaje(viaje4.getId());
		if(vuelo!=null)
			vr.deleteVuelo(vuelo.getId());
	}

	@Test
	public void testGetAll() {
		Collection<Viajes> viajes = vjr.getAll(); 
		
		assertNotNull("The collection of trips is null", viajes);
		
		System.out.println("Listing all trips:");
		int i=1;
		for (Viajes vj : viajes) {
			System.out.println("Trip " + i++ + " : " + " (ID = " + vj.getId() + ")");
		}
		
	}

	@Test
	public void testGetViaje() {
		Viajes vj = vjr.getViaje(viaje.getId());
		
		assertEquals("The id of the trip do not match", viaje.getId(), vj.getId());
		
		System.out.println("Trip id: " +  vj.getId());

	}

	@Test
	public void testAddViaje() {
		String viajeOrigen = "Add trip test source city";
		String viajeDestino = "Add trip test target city";
		String viajeFecha = "Add trip test date";
		
		viaje4 = vjr.addViaje(new Viajes(viajeOrigen,viajeDestino,viajeFecha));
		
		assertNotNull("Error when adding the trip", viaje4);
		assertEquals("The trip's source city has not been setted correctly", viajeOrigen, viaje4.getOrigen());
		assertEquals("The trip's target city has not been setted correctly", viajeDestino, viaje4.getDestino());
		assertEquals("The trip's date has not been setted corrdctly", viajeFecha, viaje4.getFecha());
	}

	@Test
	public void testUpdateViaje() {
		String viajeFecha = "Updated trip's date";

		viaje.setFecha(viajeFecha);

		boolean success = vjr.updateViaje(viaje);
		
		assertTrue("Error when updating the trip", success);
		
		Viajes vj  = vjr.getViaje(viaje.getId());
		assertEquals("The trip's date has not been updated correctly", viajeFecha, vj.getFecha());

	}

	@Test
	public void testDeleteViaje() {
		boolean success = vjr.deleteViaje(viaje2.getId());
		assertTrue("Error when deleting the trip", success);
		
		Viajes vj = vjr.getViaje(viaje2.getId());
		assertNull("The trip has not been deleted correctly", vj);
	}

	@Test
	public void testAddVuelo() {
		if(vuelo!=null) {
			boolean success = vjr.addVuelo(viaje3.getId(), vuelo.getId());
			assertTrue("Error when adding the flight", success);
		}
	}

	@Test
	public void testDeleteVuelo() {
		
		if(vuelo!=null) {
			boolean success = vjr.deleteVuelo(viaje3.getId(), vuelo.getId());
			assertTrue("Error when deleting the flight of the trip", success);
		}
		
	}

}
