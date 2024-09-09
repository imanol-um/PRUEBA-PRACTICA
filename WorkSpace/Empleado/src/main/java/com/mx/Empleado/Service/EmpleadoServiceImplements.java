package com.mx.Empleado.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mx.Empleado.Dao.IEmpleadoDao;
import com.mx.Empleado.Domain.Direccion;
import com.mx.Empleado.Domain.Empleado;

@Service
public class EmpleadoServiceImplements implements IEmpleadoService{

	@Autowired
	private IEmpleadoDao dao;
	
	@Override
	public List<Empleado> listar() {
		
		List<Empleado> empleados = dao.findAll();
		return empleados;
	}

	@Override
	public void guardar(Empleado empleado) {
		dao.save(empleado);
	}

	@Override
	public void editar(Empleado empleado) {
		dao.save(empleado);
	}

	@Override
	public Empleado buscar(Empleado empleado) {
		return dao.findById(empleado.getCurp()).orElse(null);
	}

	@Override
	public void eliminar(Empleado empleado) {
		dao.delete(empleado);
	}
	
	//------------------
	public Empleado buscarJefe(Empleado empleado) {
		return dao.findById(empleado.getClaveJefeInmediato()).orElse(null);
	}
	
	
	
	//---------------------------------------------------------------------------------------------------------
	//RestTemplate Metodo para conseguir Direccion
	@Autowired
	private RestTemplate restTemplate;

	@SuppressWarnings("unchecked")
	public Direccion obtenerDireccion(int idDireccion){
		
		Direccion direccion = restTemplate.getForObject("http://localhost:8002/Direccion/buscar/" + idDireccion, Direccion.class);
		return direccion;
	}
	
	
	
	

}
