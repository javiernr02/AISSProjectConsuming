
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
    "title",
    "genre",
    "premiere",
    "runtime",
    "score",
    "languages"
})
@Generated("jsonschema2pojo")
public class Film {

    @JsonProperty("id")
    private String id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("genre")
    private List<String> genre = null;
    @JsonProperty("premiere")
    private String premiere;
    @JsonProperty("runtime")
    private Integer runtime;
    @JsonProperty("score")
    private Double score;
    @JsonProperty("languages")
    private List<String> languages = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    
    public Film() {
    	
    }
    
    public Film(String title, List<String> genre, String premiere,
    		Integer runtime, Double score, List<String> languages) {
    	this.title = title;
		this.genre = genre;
		this.premiere = premiere;
		this.runtime = runtime;
		this.score = score;
		this.languages = languages;	
    }
    
    public Film(String id,String title, List<String> genre, String premiere,
    		Integer runtime, Double score, List<String> languages) {
    	this.id = id;
    	this.title = title;
		this.genre = genre;
		this.premiere = premiere;
		this.runtime = runtime;
		this.score = score;
		this.languages = languages;	
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("genre")
    public List<String> getGenre() {
        return genre;
    }

    @JsonProperty("genre")
    public void setGenre(List<String> genre) {
        this.genre = genre;
    }

    @JsonProperty("premiere")
    public String getPremiere() {
        return premiere;
    }

    @JsonProperty("premiere")
    public void setPremiere(String premiere) {
        this.premiere = premiere;
    }

    @JsonProperty("runtime")
    public Integer getRuntime() {
        return runtime;
    }

    @JsonProperty("runtime")
    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }

    @JsonProperty("score")
    public Double getScore() {
        return score;
    }

    @JsonProperty("score")
    public void setScore(Double score) {
        this.score = score;
    }

    @JsonProperty("languages")
    public List<String> getLanguages() {
        return languages;
    }

    @JsonProperty("languages")
    public void setLanguages(List<String> languages) {
        this.languages = languages;
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
