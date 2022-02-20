package es.redmetro.asc.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@Entity
@JacksonXmlRootElement(localName = "color")
public class Color implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2912273826423982087L;

	
	 
	 @Id @GeneratedValue
	 @Column(name="cod_color")
	@JacksonXmlProperty(localName = "cod_color")
	private int codigoColor;

	
	@JacksonXmlProperty(localName = "cod_hexadecimal")
	@Column(name = "cod_hexadecimal")
	private String codigoHexadecimal;
	
	
	@JacksonXmlProperty(localName = "nombre")
	private String nombre;
	
	

	

	@Override
	public String toString() {
		return "Color [codigoColor=" + codigoColor + ", nombre=" + nombre + ", codigoHexadecimal=" + codigoHexadecimal
				+ "]";
	}

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

	public Color(int codigoColor, String nombre, String codigoHexadecimal) {
		super();
		this.codigoColor = codigoColor;
		this.nombre = nombre;
		this.codigoHexadecimal = codigoHexadecimal;
	}

	public Color() {
		// TODO Auto-generated constructor stub
	}


	
	


}
