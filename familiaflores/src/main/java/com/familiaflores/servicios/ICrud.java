package com.familiaflores.servicios;

import java.util.List;

public interface ICrud<T> {
 
	T registrar(T t);
	T modificar(T t);
	T leer(Long id);
	List<T> listar();
	void eliminar(Long id);
	
	
	// String nombre
}
