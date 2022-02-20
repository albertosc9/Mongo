package es.redmetro.asc.procesamiento;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import es.redmetro.asc.vo.Color;

public class Deseralitation {

	
	public static List<Color> getDeseratitation(){
		
	   	
		List<Color> colores=null;
		
		
			ObjectMapper objectMapper = new XmlMapper();
			ObjectMapper jj = new JsonMapper();
			
			
			InputStream input;
			
			
			
			try {
				input = new FileInputStream(new File("recursos/colores.xml"));
				
				
				TypeReference<List<Color>> typeReference = new TypeReference<List<Color>>() {}; 
				
				
				 colores = objectMapper.readValue(input, typeReference);
			
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (StreamReadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DatabindException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			return colores;
	    	
		
		
		
		
	}
	public static List<LineaXml> getDeseratitationLineas(){
		
		
		List<LineaXml> lineas=null;
		
		
		ObjectMapper objectMapper = new XmlMapper();
		
		InputStream input;
		
		
		try {
			input = new FileInputStream(new File("recursos/lineas_metro.xml"));
			
			
			TypeReference<List<LineaXml>> typeReference = new TypeReference<List<LineaXml>>() {}; 
			
			 lineas = objectMapper.readValue(input, typeReference);
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (StreamReadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatabindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return lineas;
    	
	}
}
