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
    "compania",
    "horaLlegada",
    "horaSalida",
    "precio",
    "escala",
    "avion"
})
@Generated("jsonschema2pojo")
public class Vuelos {

    @JsonProperty("id")
    private String id;
    @JsonProperty("compania")
    private String compania;
    @JsonProperty("horaLlegada")
    private String horaLlegada;
    @JsonProperty("horaSalida")
    private String horaSalida;
    @JsonProperty("precio")
    private String precio;
    @JsonProperty("escala")
    private String escala;
    @JsonProperty("avion")
    private Aviones avion;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Vuelos(String id, String compania, String horaLlegada, String horaSalida, String precio, String escala) {
		this.id = id;
    	this.compania = compania;
		this.horaLlegada = horaLlegada;
		this.horaSalida = horaSalida;
		this.precio = precio;
		this.escala = escala;
	}

	public Vuelos(String compania, String horaLlegada, String horaSalida, String precio, String escala) {
    	this.compania = compania;
		this.horaLlegada = horaLlegada;
		this.horaSalida = horaSalida;
		this.precio = precio;
		this.escala = escala;
	}

	@JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("compania")
    public String getCompania() {
        return compania;
    }

    @JsonProperty("compania")
    public void setCompania(String compania) {
        this.compania = compania;
    }

    @JsonProperty("horaLlegada")
    public String getHoraLlegada() {
        return horaLlegada;
    }

    @JsonProperty("horaLlegada")
    public void setHoraLlegada(String horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    @JsonProperty("horaSalida")
    public String getHoraSalida() {
        return horaSalida;
    }

    @JsonProperty("horaSalida")
    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    @JsonProperty("precio")
    public String getPrecio() {
        return precio;
    }

    @JsonProperty("precio")
    public void setPrecio(String precio) {
        this.precio = precio;
    }

    @JsonProperty("escala")
    public String getEscala() {
        return escala;
    }

    @JsonProperty("escala")
    public void setEscala(String escala) {
        this.escala = escala;
    }

    @JsonProperty("avion")
    public Aviones getAvion() {
        return avion;
    }

    @JsonProperty("avion")
    public void setAvion(Aviones avion) {
        this.avion = avion;
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
