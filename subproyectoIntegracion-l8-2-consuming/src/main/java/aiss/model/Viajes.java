package aiss.model;

import java.util.HashMap;

import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "origen",
    "destino",
    "fecha",
    "vuelos"
})
@Generated("jsonschema2pojo")
public class Viajes {

    @JsonProperty("id")
    private String id;
    @JsonProperty("origen")
    private String origen;
    @JsonProperty("destino")
    private String destino;
    @JsonProperty("fecha")
    private String fecha;
    @JsonProperty("vuelos")
    private Vuelos vuelos;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Viajes(String id) {
		this.id = id;
	}

	public Viajes(String viajeOrigen, String viajeDestino, String viajeFecha) {
		// TODO Auto-generated constructor stub
	}

	@JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("origen")
    public String getOrigen() {
        return origen;
    }

    @JsonProperty("origen")
    public void setOrigen(String origen) {
        this.origen = origen;
    }

    @JsonProperty("destino")
    public String getDestino() {
        return destino;
    }

    @JsonProperty("destino")
    public void setDestino(String destino) {
        this.destino = destino;
    }

    @JsonProperty("fecha")
    public String getFecha() {
        return fecha;
    }

    @JsonProperty("fecha")
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @JsonProperty("vuelos")
    public Vuelos getVuelos() {
        return vuelos;
    }

    @JsonProperty("vuelos")
    public void setVuelos(Vuelos vuelos) {
        this.vuelos = vuelos;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

