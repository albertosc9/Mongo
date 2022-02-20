package es.redmetro.asc.vo;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@Entity
@JacksonXmlRootElement(localName = "linea")
@JsonIgnoreProperties
public class Linea implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6739014535633900802L;


	@Column(name="codigoLinea")
	private int codigoLinea;
	
	
	private String nombreCorto;
	
	
	private String nombreLargo;
	
	 @OneToOne(optional=false)
	    @JoinColumn(
	    	name="cod_color", unique=true, nullable=false, updatable=false)
	private Color color;
	
	private float kilometros;
	
	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name="imagen_linea")
	private byte[] imagenLinea;

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

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public double getKilometros() {
		return kilometros;
	}

	public void setKilometros(float kilometros) {
		this.kilometros = kilometros;
	}

	public byte[] getImagenEmpleado() {
		return imagenLinea;
	}

	public void setImagenEmpleado(byte[] imagenLinea) {
		this.imagenLinea = imagenLinea;
	}

	@Override
	public String toString() {
		return "Linea [codigoLinea=" + codigoLinea + ", nombreCorto=" + nombreCorto + ", nombreLargo=" + nombreLargo
				+ ", color=" + color + ", kilometros=" + kilometros + "]";
	}   
	
	

	 
}
