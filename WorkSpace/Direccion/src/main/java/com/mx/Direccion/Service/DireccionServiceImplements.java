package com.mx.Direccion.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.Direccion.Dao.IDireccionDao;
import com.mx.Direccion.Domain.Direccion;

@Service
public class DireccionServiceImplements implements IDireccionService {
	
	@Autowired
	private IDireccionDao dao;

	@Override
	public List<Direccion> listar() {
		return dao.findAll();
	}

	@Override
	public void guardar(Direccion direccion) {
		dao.save(direccion);
	}

	@Override
	public void editar(Direccion direccion) {
		dao.save(direccion);
	}

	@Override
	public Direccion buscar(int idDireccion) {
		return dao.findById(idDireccion).orElse(null);
	}

	@Override
	public void eliminar(Direccion direccion) {
		dao.delete(direccion);
	}

}
