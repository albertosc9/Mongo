package es.redmetro.asc.dao;

import java.util.List;

import es.redmetro.asc.vo.Color;

public interface IRedMetro<T>{
	
	public void crear(T entidad);
	public void borrar(T entidad);
	public T buscar(int codigo);
	public void actualizar(T entidad);
	public List<T> getLista();
}
