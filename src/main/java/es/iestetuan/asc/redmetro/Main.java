package es.iestetuan.asc.redmetro;

import java.util.List;

import es.redmetro.asc.dao.IRedMetro;
import es.redmetro.asc.dao.jpa.ColorJpa;
import es.redmetro.asc.vo.Color;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		IRedMetro<Color> acciones = new ColorJpa();
		
		
		
		Color color = acciones.buscar(1);
		System.out.println(color);
		
		
		List<Color>colores = acciones.getLista();
		
		for (Color string : colores) {
			System.out.println(string);
		}
	}

}
