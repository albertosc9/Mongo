package es.iestetuan.asc.redmetro.controlador;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import es.redmetro.asc.dao.IRedMetro;
import es.redmetro.asc.dao.jpa.ColorJpa;
import es.redmetro.asc.dao.jpa.LineaJpa;
import es.redmetro.asc.vo.Color;
import es.redmetro.asc.vo.Linea;

@RestController
public class LineaControladorRest {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@GetMapping(path = "/rest/linea/{codigoLinea}",produces = {"application/json"})
	public Linea mostrarColor( @PathVariable int codigoLinea) {
	IRedMetro<Linea> acciones = new LineaJpa();
	
	
	Linea linea = acciones.buscar(codigoLinea);
	
	
	return linea;
	}
	
	
	@GetMapping(path = "/rest/lineas",produces = {"application/json"})
	public List<Linea> mostrarColores() {
	IRedMetro<Linea> acciones = new LineaJpa();
	
	
	List<Linea> lineas = acciones.getLista();
	
	
	return lineas;
	}
	
}
