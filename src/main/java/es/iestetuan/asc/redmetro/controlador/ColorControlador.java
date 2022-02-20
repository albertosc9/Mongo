package es.iestetuan.asc.redmetro.controlador;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import es.redmetro.asc.dao.IRedMetro;
import es.redmetro.asc.dao.jpa.ColorJpa;
import es.redmetro.asc.vo.Color;

@Controller
public class ColorControlador {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/colores")
	public String listarColores(Model modelo) {
		IRedMetro<Color> acciones = new ColorJpa();
		
		List<Color> colores = acciones.getLista();
		
		
		modelo.addAttribute("colores", colores);
		
		
		return "color/lista";
		
		
	}
	@GetMapping(value = {"/color/{codigoColor}"})
	public String mostrarColor(Model modelo, @PathVariable int codigoColor) {
	 Color color = null;
	    try {
	    	// Lo suyo es llamar a la operaciÃ³n de DAO de departamento que devuelve un departamento a partir de un cÃ³digo
	    	IRedMetro<Color> acciones = new ColorJpa();
	    	color = acciones.buscar(codigoColor);
	    } catch (Exception ex) {
	        modelo.addAttribute("mensajeError", "color no encontrado");
	    }
		
		modelo.addAttribute("color", color);
		
		return "color/Color";	
	}
}
