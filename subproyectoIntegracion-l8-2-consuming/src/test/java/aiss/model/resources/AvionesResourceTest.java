package aiss.model.resources;

import static org.junit.Assert.*;


import java.util.Collection;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.restlet.resource.ResourceException;

import aiss.model.Aviones;

public class AvionesResourceTest {
	
	static Aviones avion1, avion2, avion3;
	static AvionesResource ar = new AvionesResource();
	
	
	@BeforeClass
	public static void setup() throws Exception {
		
		avion1 = ar.addAvion(new Aviones("Test capacity","Test model"));
		
		avion2 = ar.addAvion(new Aviones("Test capacity 2","Test model 2"));
		
	}
	

	@Test
	public void testGetAll() {
		Collection<Aviones> aviones = ar.getAll();
		
		assertNotNull("The collection of planes is null", aviones);
		
		System.out.println("Listing all planes:");
		int i=1;
		for (Aviones a : aviones) {
			System.out.println("Plane " + i++ + " : " + " (ID=" + a.getId() + ")");
		}
	}

	@Test
	public void testGetAvion() {
		Aviones a = ar.getAvion(avion1.getId());
		
		assertEquals("The id of the plane do not match", avion1.getId(), a.getId());
		assertEquals("The capacity of the plane do not match", avion1.getCapacidad(), a.getCapacidad());
		assertEquals("The model of the plane do not match", avion1.getModelo(), a.getModelo());
		assertEquals("The services of the plane do not match", avion1.getServicios(), a.getServicios());

		System.out.println("Plane id: " + a.getId());
		System.out.println("Plane capacity: " + a.getCapacidad());
		System.out.println("Plane model: " + a.getCapacidad());
		System.out.println("Plane sevices: " + a.getServicios());
	}

	@Test
	public void testAddAvion() {
		String avionCapacidad = "Add plane's test capacity";
		String avionModelo = "Add plane's test model";
		
		avion3 = ar.addAvion(new Aviones(avionCapacidad, avionModelo, avionServicios));
		
		assertNotNull("Error when adding the plane", avion3);
		assertEquals("The plane's capacity has not been setted correctly", avionCapacidad, avion3.getCapacidad());
		assertEquals("The plane's model has not been setted correctly", avionModelo, avion3.getModelo());
	}

	@Test
	public void testUpdateAvion() {
		String avionCapacidad = "Update plane's test capacity";
		String avionModelo = "Update plane's test model";
		
		avion1.setCapacidad(avionCapacidad);
		avion1.setModelo(avionModelo);
		
		boolean success = ar.updateAvion(avion1);
		
		assertTrue("Error when updating the plane", success);
		
		Aviones avion  = ar.getAvion(avion1.getId());
		assertEquals("The plane's capacity has not been updated correctly", avionCapacidad, avion.getCapacidad());
		assertEquals("The plane's model has not been updated correctly", avionModelo, avion.getModelo());
	}

}
