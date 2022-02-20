package es.redmetro.asc.procesamiento;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

import es.redmetro.asc.vo.Mongo.Linea;


public class MongoDbDatos {

	
	
	
	public  List<Linea> lineasFromJson(){
		
		
		
		ObjectMapper objectMapper = new JsonMapper();
		
		
		InputStream input;
		
		List<Linea>lineas = null;
		
		
		try {
			
			String json = getJSONDesdeURL("http://dam2.actividad.cf:55555/rest/lineas");
			
			
			
			
			TypeReference<List<Linea>> typeReference = new TypeReference<List<Linea>>() {}; 
			
			
			lineas = objectMapper.readValue(json, typeReference);
		
		
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
	
	
	
	
	
	private String getJSONDesdeURL(String urlPeticion) {
 		String infoJSON=null;
		System.out.println("Inicio consumo petición HTTP: " + urlPeticion);
		HttpClient cliente = HttpClient.newHttpClient();
		URI uriPrueba= URI.create(urlPeticion);
		HttpRequest request = HttpRequest.newBuilder().uri(uriPrueba).GET().build();
		    
		try {
		    HttpResponse<String> respuesta=cliente.send(request, BodyHandlers.ofString());
		    infoJSON = respuesta.body();
		    //System.out.println(infoJSON);
		} catch (IOException | InterruptedException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}  
		System.out.println("FIN consumo petición HTTP: " + urlPeticion);
		return infoJSON;
    }
}
