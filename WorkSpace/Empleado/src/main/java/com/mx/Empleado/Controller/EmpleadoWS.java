package com.mx.Empleado.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.Empleado.Domain.Direccion;
import com.mx.Empleado.Domain.Empleado;
import com.mx.Empleado.Service.EmpleadoServiceImplements;

@RestController
@CrossOrigin
@RequestMapping(path = "/Empleado")
public class EmpleadoWS {

	@Autowired
	private EmpleadoServiceImplements service;
	
	//url: http://localhost:8001/Empleado
	
	//listar                 http://localhost:8001/Empleado/listar
	@GetMapping("/listar")
	public ResponseEntity<?> listarEmpleado() {
		List<Empleado> empleados = service.listar();
		if (empleados.isEmpty()) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(empleados);	
		}
	}	
	
	
	
	//listarEmpleadoJefe                 http://localhost:8001/Empleado/listarEmpleadoJefe
	@GetMapping("/listarEmpleadoJefe")
	public ResponseEntity<?> listarEmpleadoJefe(@RequestBody Empleado empleado) {
		
		if (service.buscar(empleado) != null) {
			
			Empleado jefe = service.buscarJefe(empleado);
			List<Object> lista = new ArrayList<>();
			lista.add(empleado);
			lista.add(jefe);
			return ResponseEntity.ok(lista);
			
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Mensaje\":\"El empleado con el CURP " + empleado.getCurp()+ " NO existe.\"}");
		}

	}	
	
	
	
	
	
	//listarEmpleadoDireccion                 http://localhost:8001/Empleado/listarEmpleadoDireccion
	@GetMapping("/listarEmpleadoDireccion")
	public ResponseEntity<?> listarEmpleadoDireccion(@RequestBody Empleado empleado) {
		
		if (service.buscar(empleado) != null) {
			
			Direccion direccion = service.obtenerDireccion(empleado.getDireccionId());
			List<Object> lista = new ArrayList<>();
			lista.add(empleado);
			lista.add(direccion);
			return ResponseEntity.ok(lista);
			
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Mensaje\":\"El empleado con el CURP " + empleado.getCurp()+ " NO existe.\"}");
		}

	}	
	
	
	
	//guardar              http://localhost:8001/Empleado/guardar
	@PostMapping("/guardar")
	public ResponseEntity<?> guardarEmpleado(@RequestBody Empleado empleado) {
		
		if (service.buscar(empleado) == null) {
			service.guardar(empleado);
			return ResponseEntity.ok("{\"Mensaje\":\"El empleado con el CURP " + empleado.getCurp() + " Se ha almacenado correctamente.\"}");
		}else {
			return ResponseEntity.status(HttpStatus.FOUND).body("{\"Mensaje\":\"El empleado con el CURP " + empleado.getCurp()+ " ya existe.\"}");
		}
		
	}
	

	
	//editar             http://localhost:8001/Empleado/editar
	@PutMapping("/editar")
	public ResponseEntity<?> editarEmpleado(@RequestBody Empleado empleado) {
		
		if (service.buscar(empleado) == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}else {
			service.editar(empleado);
			return ResponseEntity.ok(empleado);
		}
	}
	
		
	
}
