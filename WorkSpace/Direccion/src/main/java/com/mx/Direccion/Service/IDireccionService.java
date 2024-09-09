package com.mx.Direccion.Service;

import java.util.List;

import com.mx.Direccion.Domain.Direccion;

public interface IDireccionService {

	//Listar
	public List<Direccion> listar();
	
	//Guardar
	public void guardar(Direccion direccion);
	
	//Editar
	public void editar(Direccion direccion);
	
	//Buscar
	public Direccion buscar(int idDireccion);

	//Eliminar
	public void eliminar(Direccion direccion);
	

	
}
