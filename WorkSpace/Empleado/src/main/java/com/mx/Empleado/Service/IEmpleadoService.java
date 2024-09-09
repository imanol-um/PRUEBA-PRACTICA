package com.mx.Empleado.Service;

import java.util.List;

import com.mx.Empleado.Domain.Empleado;

public interface IEmpleadoService  {

	//Listar
	public List<Empleado> listar();
	
	//Guardar
	public void guardar(Empleado empleado);
	
	//Editar
	public void editar(Empleado empleado);
	
	//Buscar
	public Empleado buscar(Empleado empleado);

	//Eliminar
	public void eliminar(Empleado empleado);
	

	
}
