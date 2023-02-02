package com.familiaflores.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.familiaflores.modelos.Familia;
import com.familiaflores.repositorios.IFamiliaRepositorio;


@Service
public class FamiliaServicio implements IFamiliServicio{
	
	@Autowired
	private IFamiliaRepositorio repo;

	@Override
	public Familia registrar(Familia t) {
		// TODO Auto-generated method stub
		return repo.save(t);
	}

	@Override
	public Familia modificar(Familia t) {
		// TODO Auto-generated method stub
		return repo.save(t);
	}

	@Override
	public Familia leer(Long id) {
		// TODO Auto-generated method stub
		Optional<Familia> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Familia();
	}

	@Override
	public List<Familia> listar() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		
		repo.deleteById(id);
		
	}

}
