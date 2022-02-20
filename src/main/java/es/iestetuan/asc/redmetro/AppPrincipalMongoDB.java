package es.iestetuan.asc.redmetro;



import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import es.redmetro.asc.dao.mongodb.LineaMongoDb;
import es.redmetro.asc.procesamiento.MongoDbDatos;
import es.redmetro.asc.vo.Mongo.Linea;


public class AppPrincipalMongoDB {
	private final static String URL_PRUEBA = "http://localhost:8081/rest/coloresr";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AppPrincipalMongoDB appPrincipal = new AppPrincipalMongoDB();
		
	  //  appPrincipal.probarAccesoDB();
	    appPrincipal.implementacionLinea();
		
	}
	private void probarAccesoDB() {
		
		MongoClient mongoClient =new MongoClient( new MongoClientURI("mongodb://localhost:27017"));
		
		String nombreBaseDatos = "PruebaBBDD";
		MongoDatabase baseDatosMongoDB = mongoClient.getDatabase(nombreBaseDatos);
		
		String nombreCollection = "prueba";
		
		MongoCollection<Document> coleccionPrueba = baseDatosMongoDB.getCollection(nombreCollection);
		
		
//		Document persona = new Document("alberto","asc");
//		
//		coleccionPrueba.insertOne(persona);
//		
//		Document alumno1 = new Document("id","jsp").append("nombre", "juan").append("edad", 26);
//		Document alumno2 = new Document("id","alc").append("nombre", "alberto").append("edad", 28);
//		Document alumno3 = new Document("id","rod").append("nombre","Rocio").append("edad", 33);
//		
//		List<Document>listaAlumnos = new ArrayList<Document>();
//		listaAlumnos.add(alumno1);
//		listaAlumnos.add(alumno2);
//		listaAlumnos.add(alumno3);
//		
//		coleccionPrueba.insertMany(listaAlumnos);
//		
		
		
		//borrado de un elemento
		
		Document documento = new Document();
		
		BasicDBObject filtrado = new BasicDBObject("id","rod");
		
		coleccionPrueba.deleteOne(filtrado);
		
		
		//consulta 
		
		BasicDBObject filtroConsulta = new BasicDBObject("nombre","juan");
		Document documentoConsulta = coleccionPrueba.find(filtroConsulta).first();
		System.out.println("resultado"+documentoConsulta);
		
		//consulta todos 
		
		Iterator<Document> iteratorDocumentos = coleccionPrueba.find().iterator();
		
		while(iteratorDocumentos.hasNext()) {
			Document docu = iteratorDocumentos.next();
			System.out.println(docu);
			
		}
		
		//actualizacion 
		
		BasicDBObject filtradoActu = new BasicDBObject("_id",5);
		Document infoset = new Document("codigo_emple",7).append("nombre","dd");
		
		BasicDBObject objetoActualizar = new BasicDBObject();
		objetoActualizar.put("$set", infoset);
		
		coleccionPrueba.updateOne(filtradoActu, objetoActualizar);
		
		
		
		//insertarDocumentoDesdeJSON(coleccionPrueba);
		
		
		
	}
	
	
	private void implementacionLinea() {
		
		LineaMongoDb accionesLinea = new LineaMongoDb();
		MongoDbDatos datos = new MongoDbDatos();
		
		
		
		List<es.redmetro.asc.vo.Mongo.Linea> lineas = datos.lineasFromJson();
	
	
		 for (Linea linea : lineas) {
			 
			 accionesLinea.crear(linea);
			 
			 
		 }
		
		
	}
	
	private void insertarDocumento(MongoCollection<Document>collecion) {

		
		List<String> modulos = Arrays.asList("0486","0490");
		Document persona = new Document("alberto","asc");
		
		collecion.insertOne(persona);;
		
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
	 public void insertarDocumentoDesdeJSON(MongoCollection<Document> coleccion){
		 String infoJSON = getJSONDesdeURL(URL_PRUEBA);
		
		
		 List<Document> documentoMongoDB = (List<Document>) Document.parse(infoJSON);
		// coleccion.insertOne(documentoMongoDB);
		 coleccion.insertMany(documentoMongoDB);
	 }


	
}
