package es.iestetuan.asc.redmetro.controlador;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import es.redmetro.asc.dao.IRedMetro;
import es.redmetro.asc.dao.jpa.ColorJpa;
import es.redmetro.asc.vo.Color;

@RestController
public class ColorControladorRest {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@GetMapping(path = "/rest/color/{codigoColor}",produces = {"application/json"})
	public Color mostrarColor( @PathVariable int codigoColor) {
	IRedMetro<Color> acciones = new ColorJpa();
	
	Color color = acciones.buscar(codigoColor);
	
	
	return color;
	}
	@GetMapping(path = "/rest/colores",produces = {"application/json"})
	public List<Color> mostrarColores() {
	IRedMetro<Color> acciones = new ColorJpa();
	
	List<Color> colores = acciones.getLista();
	
	
	return colores;
	}
	
}

