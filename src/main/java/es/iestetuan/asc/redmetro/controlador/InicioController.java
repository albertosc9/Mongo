package es.iestetuan.asc.redmetro.controlador;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class InicioController {
	@Value("${conf.saludo}")
	private String saludo;
	
	@RequestMapping("/")
	@ResponseBody
	public String iniciar(){
		return "Bienvenido a DAM2 con Spring WEB. Recibe un saludo de: " + saludo;
	}

	@RequestMapping("/ini")
	public String iniciarConPlantilla(){
		return "inicio";
	}

	@RequestMapping("/ini1")
	public String iniciar1(Model modelo){
		modelo.addAttribute("saludo_dam2", saludo);
		return "inicio";
	}


}
