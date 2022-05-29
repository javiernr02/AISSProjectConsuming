package aiss.model;


import java.util.HashMap;

import java.util.List;
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
    "capacidad",
    "modelo",
    "servicios"
})
@Generated("jsonschema2pojo")
public class Aviones {

    @JsonProperty("id")
    private String id;
    @JsonProperty("capacidad")
    private String capacidad;
    @JsonProperty("modelo")
    private String modelo;
    @JsonProperty("servicios")
    private List<String> servicios = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Aviones(String capacidad, String modelo) {
		this.capacidad = capacidad;
		this.modelo = modelo;
	}

	public Aviones(String capacidad, String modelo, List<String> servicios) {
		this.capacidad = capacidad;
		this.modelo = modelo;
		this.servicios = servicios;
	}

	@JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("capacidad")
    public String getCapacidad() {
        return capacidad;
    }

    @JsonProperty("capacidad")
    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    @JsonProperty("modelo")
    public String getModelo() {
        return modelo;
    }

    @JsonProperty("modelo")
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @JsonProperty("servicios")
    public List<String> getServicios() {
        return servicios;
    }

    @JsonProperty("servicios")
    public void setServicios(List<String> servicios) {
        this.servicios = servicios;
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

