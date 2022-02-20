package es.redmetro.asc.vo.Mongo;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;









@Entity

@JsonIgnoreProperties
public class Linea implements Serializable{



	/**
	 * 
	 */
	private static final long serialVersionUID = 6739014535633900802L;


	@Column(name="codigoLinea")
	@JsonProperty("codigo_linea_json")
	private int codigoLinea;
	
	@JsonProperty("nombre_corto_json")
	private String nombreCorto;
	
	@JsonProperty("nombre_largo_json")
	private String nombreLargo;
	

	@JsonProperty("color_linea")
	private ColorMongo color;
	
	
	@JsonProperty("codigo_color_json")
	private int codigoColor;
	
	@JsonProperty("nombre_json")
	private String nombre;
	
	@JsonProperty("kilometros_json")
	private float kilometros;
	
	@JsonProperty("codigo_hexadecimal_json")
	private String codigoHexadecimal; 
	
	
	public ColorMongo getColor() {
		return color;
	}

	public void setColor(ColorMongo color) {
		this.color = color;
	}

	public String getImagenLinea() {
		return imagenLinea;
	}



	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name="imagen_linea")
	@JsonProperty("url_imagen_linea_json")
	private String imagenLinea;
	
	
	
	
	public int getCodigoColor() {
		return codigoColor;
	}

	public void setCodigoColor(int codigoColor) {
		this.codigoColor = codigoColor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigoHexadecimal() {
		return codigoHexadecimal;
	}

	public void setCodigoHexadecimal(String codigoHexadecimal) {
		this.codigoHexadecimal = codigoHexadecimal;
	}

	public void setImagenLinea(String imagenLinea) {
		this.imagenLinea = imagenLinea;
	}

	public int getCodigoLinea() {
		return codigoLinea;
	}

	public void setCodigoLinea(int codigoLinea) {
		this.codigoLinea = codigoLinea;
	}

	public String getNombreCorto() {
		return nombreCorto;
	}

	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}

	public String getNombreLargo() {
		return nombreLargo;
	}

	public void setNombreLargo(String nombreLargo) {
		this.nombreLargo = nombreLargo;
	}

	

	public double getKilometros() {
		return kilometros;
	}

	public void setKilometros(float kilometros) {
		this.kilometros = kilometros;
	}

	

	@Override
	public String toString() {
		return "Linea [codigoLinea=" + codigoLinea + ", nombreCorto=" + nombreCorto + ", nombreLargo=" + nombreLargo
				+ ", color=" + color + ", kilometros=" + kilometros + "]";
	}   
	
	

	 
}
