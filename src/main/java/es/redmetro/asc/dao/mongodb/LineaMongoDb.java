package es.redmetro.asc.dao.mongodb;

import java.util.List;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import es.redmetro.asc.dao.IRedMetro;
import es.redmetro.asc.procesamiento.MongoDbDatos;
import es.redmetro.asc.vo.Mongo.Linea;


public class LineaMongoDb implements IRedMetro<Linea>{

	
	@Override
	public void crear(Linea entidad) {
		// TODO Auto-generated method stub
		
		//esto ponerlo en utilidades para que me devuelva una base de datos. 
		MongoClient mongoClient =new MongoClient( new MongoClientURI("mongodb://localhost:27017"));
		
		String nombreBaseDatos = "PruebaBBDD";
		MongoDatabase baseDatosMongoDB = mongoClient.getDatabase(nombreBaseDatos);
		
		/// hasta aquí 
		
		
		String nombreCollection = "Lineas";
		
		MongoCollection<Document> coleccionPrueba = baseDatosMongoDB.getCollection(nombreCollection);
		
		MongoDbDatos mongo = new MongoDbDatos();
		
	
			
			Document documentoLinea = new Document("_id",entidad.getCodigoLinea());
			Document documentoColor = new Document("_id",entidad.getCodigoColor());
			documentoLinea.append("nombre corto", entidad.getNombreCorto());
			documentoLinea.append("nombre_largo", entidad.getNombreLargo());
			documentoLinea.append("kilometros", entidad.getKilometros());
			documentoColor.append("nombre",entidad.getNombre());
			documentoColor.append("codigoHexadecimal", entidad.getCodigoHexadecimal());
			
			documentoLinea.append("color", documentoColor);
			
		
			

	}

	@Override
	public void borrar(Linea entidad) {
		
	MongoClient mongoClient =new MongoClient( new MongoClientURI("mongodb://localhost:27017"));
		
		String nombreBaseDatos = "PruebaBBDD";
		MongoDatabase baseDatosMongoDB = mongoClient.getDatabase(nombreBaseDatos);
		
		/// hasta aquí 
		
		
		String nombreCollection = "Lineas";
		
		MongoCollection<Document> coleccionPrueba = baseDatosMongoDB.getCollection(nombreCollection);
		
		MongoDbDatos mongo = new MongoDbDatos();
		
		Document documento = new Document();

        BasicDBObject filtrado = new BasicDBObject("_id",entidad.getCodigoLinea());

        coleccionPrueba.deleteOne(filtrado);
		
	}

	@Override
	public Linea buscar(int codigo) {
		MongoClient mongoClient =new MongoClient( new MongoClientURI("mongodb://localhost:27017"));
		
		String nombreBaseDatos = "PruebaBBDD";
		MongoDatabase baseDatosMongoDB = mongoClient.getDatabase(nombreBaseDatos);
		
		String nombreCollection = "Lineas";
		
		MongoCollection<Document> coleccionPrueba = baseDatosMongoDB.getCollection(nombreCollection);
		
		BasicDBObject filtroConsulta = new BasicDBObject("_id",codigo);
		Document documentoConsulta = coleccionPrueba.find(filtroConsulta).first();

		
		Linea linea = new Linea();
		
		
		
		
		linea.setCodigoLinea(Integer.parseInt(documentoConsulta.getString("_id")));
		linea.setNombre(documentoConsulta.getString("nombre_corto_json"));
		linea.setNombreLargo(documentoConsulta.getString("nombre_largo_json"));
		linea.setCodigoColor(documentoConsulta.getInteger("_id"));
		linea.setImagenLinea(documentoConsulta.getString("url_imagen_linea_json"));
		linea.setKilometros(Float.valueOf(documentoConsulta.getString("kilometros_json"));
		
		
		return null;
	}

	@Override
	public void actualizar(Linea entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Linea> getLista() {
		// TODO Auto-generated method stub
		return null;
	}
	
	



}
