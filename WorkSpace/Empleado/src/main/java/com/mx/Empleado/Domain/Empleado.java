package com.mx.Empleado.Domain;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "EMPLEADO")
public class Empleado {
	
	private String nombre;
	private String apellidos;
	@Id
	private String curp;
	private String puesto;
	private String claveJefeInmediato;
	private int direccionId;
	

}
