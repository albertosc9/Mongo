package es.iestetuan.asc.redmetro;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class AppPruebaProyectos {
	
	private final static String URL_PRUEBA = "http://localhost:8081/rest/color/1";
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AppPruebaProyectos appPruebaProyectos = new AppPruebaProyectos();
		appPruebaProyectos.probarConsumirAPIRest();
	}
	
	public void probarConsumirAPIRest() {
		HttpClient cliente = HttpClient.newHttpClient();
		URI uriPrueba = URI.create(URL_PRUEBA);
		HttpRequest request = HttpRequest.newBuilder().uri(uriPrueba).GET().build();
		
		HttpResponse<String> respuesta;
		try {
			respuesta = cliente.send(request,BodyHandlers.ofString());
			String resultado = respuesta.body();
			
			System.out.println(resultado);
		
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

}
}

