package com.mx.Direccion.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.Direccion.Domain.Direccion;
import com.mx.Direccion.Service.DireccionServiceImplements;

@RestController
@RequestMapping(path = "/Direccion")
@CrossOrigin
public class DireccionWS {

	@Autowired
	private DireccionServiceImplements service;
	
	
	//url: http://localhost:8002/Direccion
	
	//listar                 http://localhost:8002/Direccion/listar
	@GetMapping("/listar")
	public ResponseEntity<?> listarDireccion() {
		List<Direccion> direcciones = service.listar();
		if (direcciones.isEmpty()) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(direcciones);	
		}
	}	
	
	
	
	//guardar              http://localhost:8002/Direccion/guardar
	@PostMapping("/guardar")
	public ResponseEntity<?> guardarDireccion(@RequestBody Direccion direccion) {
		
		if (service.buscar(direccion.getIdDireccion()) == null) {
			service.guardar(direccion);
			return ResponseEntity.ok(direccion);
		}else {
			return ResponseEntity.status(HttpStatus.FOUND).build();
		}
		
	}
	

	
	//editar            http://localhost:8002/Direccion/editar
	@PutMapping("/editar")
	public ResponseEntity<?> editarDireccion(@RequestBody Direccion direccion) {
		
		if (service.buscar(direccion.getIdDireccion()) == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}else {
			service.editar(direccion);
			return ResponseEntity.ok(direccion);
		}
	}
	
	//Buscar 		 http://localhost:8002/Direccion/buscar/{idDireccion}
	@GetMapping("/buscar/{idDireccion}")
	public ResponseEntity<?> buscar(@PathVariable int idDireccion) {
		Direccion encontrado = service.buscar(idDireccion);
		if (encontrado == null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.status(HttpStatus.FOUND).body(encontrado);
		}
	}
	
	
	
	
}
