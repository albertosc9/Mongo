package es.redmetro.asc.vo.Mongo;

import java.io.Serializable;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class ColorMongo implements Serializable{

	
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = 4623233535654213945L;

	@JsonProperty("codigo_color_json")
	private int codigoColor;

	@JsonProperty("codigo_hexadecimal_json")
	private String codigoHexadecimal;
	
	@JsonProperty("nombre_json")
	private String nombre;
	
}
