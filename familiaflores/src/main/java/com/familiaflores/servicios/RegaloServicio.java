package com.familiaflores.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.familiaflores.modelos.Familia;
import com.familiaflores.modelos.Regalo;
import com.familiaflores.repositorios.IRegaloRepositorio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class RegaloServicio implements IRegaloServicio{
	
	
	private final Logger log = LoggerFactory.getLogger(RegaloServicio.class);
	
	@Autowired
	private IRegaloRepositorio rep;
	

	@Override
	public Regalo registrar(Regalo t) {
		// TODO Auto-generated method stub
		return rep.save(t);
	}

	@Override
	public Regalo modificar(Regalo t) {
		
		// TODO Auto-generated method stub
		log.info("nombre: "+t.getNombre());
		log.info("idfamilia: "+t.getIdFamilia());
		log.info("url1: "+t.getUrl1());
		log.info("url2: "+t.getUrl2());
		
		return rep.save(t);
	}

	@Override
	public Regalo leer(Long id) {
		// TODO Auto-generated method stub
		Optional<Regalo> op = rep.findById(id);
		return op.isPresent() ? op.get() : new Regalo();
	}

	@Override
	public List<Regalo> listar() {
		// TODO Auto-generated method stub
		return rep.findAll();
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		rep.deleteById(id);
	}

}
