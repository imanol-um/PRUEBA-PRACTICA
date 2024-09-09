package com.mx.Empleado.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.Empleado.Domain.Empleado;

public interface IEmpleadoDao extends JpaRepository<Empleado, String> {
	
	// METODOS PERSONALIZADOS

}
