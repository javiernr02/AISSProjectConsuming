package aiss.model.resources;

import static org.junit.Assert.*;


import java.util.Collection;

import org.junit.Test;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import aiss.model.Vuelos;

public class VuelosResourceTest {
	
	
	static Vuelos vuelo1, vuelo2, vuelo3;
	static VuelosResource vr = new VuelosResource();
	
	
	@BeforeClass
	public static void setup() throws Exception {
		
		vuelo1 = vr.addVuelo(new Vuelos("Test id","Test compania","Test horaLlegada","Test horaSalida","Test precio","Test escala"));
		
		vuelo2 = vr.addVuelo(new Vuelos("Test id 2","Test compania 2","Test horaLlegada 2","Test horaSalida 2","Test precio 2",
				"Test escala 2"));
		
	}

	@AfterClass
	public static void tearDown() throws Exception {
		vr.deleteVuelo(vuelo1.getId());
		vr.deleteVuelo(vuelo3.getId());
	}
	
	
	

	@Test
	public void testGetAll() {
		Collection<Vuelos> vuelos = vr.getAll();
		
		assertNotNull("The collection of flights is null", vuelos);
		
		System.out.println("Listing all flights:");
		int i=1;
		for (Vuelos v : vuelos) {
			System.out.println("Flight " + i++ + " : " + " (ID=" + v.getId() + ")");
		}
	}

	
	@Test
	public void testGetVuelo() {
		Vuelos v = vr.getVuelo(vuelo1.getId());
		
		assertEquals("The id of the flight do not match", vuelo1.getId(), v.getId());
		assertEquals("The company of the flight do not match", vuelo1.getCompania(), v.getCompania());
		assertEquals("The arrival time of the flight do not match", vuelo1.getHoraLlegada(), v.getHoraLlegada());
		assertEquals("The departure time of the flight do not match", vuelo1.getHoraSalida(), v.getHoraSalida());
		assertEquals("The price of the flight do not match", vuelo1.getPrecio(), v.getPrecio());
		assertEquals("The flight scale of the flight do not match", vuelo1.getEscala(), v.getEscala());

		System.out.println("Flight id: " + v.getId());
		System.out.println("Flight company: " + v.getCompania());
		System.out.println("Flight arrival time: " + v.getHoraLlegada());
		System.out.println("Flight departure time: " + v.getHoraSalida());
		System.out.println("Flight price: " + v.getPrecio());
		System.out.println("Flight scale: " + v.getEscala());
	}

	@Test
	public void testAddVuelo() {
		String vueloCompania = "Add flight test company";
		String vueloHoraLlegada = "Add flight test name arrival time";
		String vueloHoraSalida = "Add flight test departure time";
		String vueloPrecio = "Add flight test price";
		String vueloEscala = "Add flight test flight scale";
		
		vuelo3 = vr.addVuelo(new Vuelos(vueloCompania, vueloHoraLlegada, vueloHoraSalida, vueloPrecio, vueloEscala));
		
		assertNotNull("Error when adding the flight", vuelo3);
		assertEquals("The flight's company has not been setted correctly", vueloCompania, vuelo3.getCompania());
		assertEquals("The flight's arrival time has not been setted correctly", vueloHoraLlegada, vuelo3.getHoraLlegada());
		assertEquals("The flight's departure time has not been setted correctly", vueloHoraSalida, vuelo3.getHoraSalida());
		assertEquals("The flight's price has not been setted correctly", vueloPrecio, vuelo3.getPrecio());
		assertEquals("The flight's scale has not been setted correctly", vueloEscala, vuelo3.getEscala());
		
	}

	@Test
	public void testUpdateVuelo() {
		String vueloCompania = "Update flight test company";
		String vueloHoraLlegada = "Update flight test name arrival time";
		String vueloHoraSalida = "Update flight test departure time";
		String vueloPrecio = "Update flight test price";
		String vueloEscala = "Update flight test flight scale";
		
		vuelo1.setCompania(vueloCompania);
		vuelo1.setHoraLlegada(vueloHoraLlegada);
		vuelo1.setHoraSalida(vueloHoraSalida);
		vuelo1.setPrecio(vueloPrecio);
		vuelo1.setEscala(vueloEscala);
		
		boolean success = vr.updateVuelo(vuelo1);
		
		assertTrue("Error when updating the flight", success);
		
		Vuelos vuelo  = vr.getVuelo(vuelo1.getId());
		assertEquals("The flights's company has not been updated correctly", vueloCompania, vuelo.getCompania());
		assertEquals("The flights's arrival time has not been updated correctly", vueloHoraLlegada, vuelo.getHoraLlegada());
		assertEquals("The flights's departure time has not been updated correctly", vueloHoraSalida, vuelo.getHoraSalida());
		assertEquals("The flights's price has not been updated correctly", vueloPrecio, vuelo.getPrecio());
		assertEquals("The flights's scale has not been updated correctly", vueloEscala, vuelo.getEscala());
	}

	@Test
	public void testDeleteVuelo() {
		boolean success = vr.deleteVuelo(vuelo2.getId());
		
		assertTrue("Error when deleting the flight", success);
		
		Vuelos vuelo  = vr.getVuelo(vuelo2.getId());
		assertNull("The flight has not been deleted correctly", vuelo);
	}

}
