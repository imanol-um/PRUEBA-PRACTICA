package com.mx.Direccion.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "DIRECCION")
@Data
public class Direccion {

	/*
	ID_DIRECCION NUMBER, -- PK
    CALLE NVARCHAR2(100) NOT NULL,
    NO_EXTERIOR NUMBER NOT NULL,
    NO_INTERIOR NUMBER DEFAULT 0,
    COLONIA NVARCHAR2(100) NOT NULL,
    MUNICIPIO NVARCHAR2(100) NOT NULL,
    ESTADO NVARCHAR2(100) NOT NULL,
    PAIS NVARCHAR2(100) NOT NULL
	 */
	
	@Id
	private int idDireccion;
    private String calle;
    private int noExterior; 
    private int noInterior;
    private String colonia;
    private String municipio;
    private String estado;
    private String pais;
	
	
	
}
