package es.iestetuan.asc.redmetro.controlador;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import es.redmetro.asc.dao.IRedMetro;
import es.redmetro.asc.dao.jpa.ColorJpa;
import es.redmetro.asc.dao.jpa.LineaJpa;
import es.redmetro.asc.vo.Color;
import es.redmetro.asc.vo.Linea;

@Controller
public class LineaControlador {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	

	@GetMapping("/lineas")
	public String listarLineas(Model modelo) {
		IRedMetro<Linea> acciones = new LineaJpa();
		
		List<Linea> lineas = acciones.getLista();
		
		
		modelo.addAttribute("lineas", lineas);
		
		
		return "linea/lista";
		
		
	}
	@GetMapping(value = {"/linea/{codigoLinea}"})
	public String mostrarColor(Model modelo, @PathVariable int codigoLinea) {
	Linea linea = null;
	
	    try {
	    	// Lo suyo es llamar a la operaciÃ³n de DAO de departamento que devuelve un departamento a partir de un cÃ³digo
	    	IRedMetro<Linea> acciones = new LineaJpa();
	    	linea = acciones.buscar(codigoLinea);
	    } catch (Exception ex) {
	        modelo.addAttribute("mensajeError", "linea no encontrada");
	    }
		
		modelo.addAttribute("linea", linea);
		
		return "linea/buscar";	
	}
}
