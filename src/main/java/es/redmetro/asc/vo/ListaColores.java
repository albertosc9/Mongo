package es.redmetro.asc.vo;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "T_color")
public class ListaColores {

	@JacksonXmlElementWrapper(useWrapping = false)
	@JacksonXmlProperty(localName = "color")
	List<Color>colores;
	
	public void setColores(List<Color> colores) {
		this.colores = colores;
	}

	public List<Color>getColores(){
		return colores;
	}
}
