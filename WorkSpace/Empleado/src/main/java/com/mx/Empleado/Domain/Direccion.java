package com.mx.Empleado.Domain;



import lombok.Data;

@Data
public class Direccion {
	
	private int idDireccion;
    private String calle;
    private int noExterior; 
    private int noInterior;
    private String colonia;
    private String municipio;
    private String estado;
    private String pais;
	
	
	
}
