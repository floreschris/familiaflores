package com.familiaflores.controladores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.familiaflores.modelos.Familia;
import com.familiaflores.modelos.Regalo;
import com.familiaflores.servicios.IRegaloServicio;

@RestController
@RequestMapping("/apiFamilias")
public class RegaloControladores {

	@Autowired
	private IRegaloServicio serv;

	@GetMapping(value = "/regalos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Regalo>> listar1() {
		List<Regalo> regalo = new ArrayList<>();
		regalo = serv.listar();
		return new ResponseEntity<List<Regalo>>(regalo, HttpStatus.OK);

	}

	@GetMapping("/regalo/{id}")
	public Regalo listarRegalosId(@PathVariable Long id) {
		return serv.leer(id);
	}

	@PostMapping("/regalo")
	@ResponseStatus(HttpStatus.CREATED)
	public Regalo create(@RequestBody Regalo regalo) {
		return serv.registrar(regalo);
	}

	@PostMapping("/regalo/{id}")
	public Regalo update(@RequestBody Regalo regalo, @PathVariable Long id) {
		Regalo regaloActual = serv.leer(id);
		
		regaloActual.setIdFamilia(regalo.getIdFamilia());
		regaloActual.setNombre(regalo.getNombre());
		regaloActual.setUrl1(regalo.getUrl1());
		regaloActual.setUrl2(regalo.getUrl2());

		return serv.modificar(regaloActual);

	}

	@DeleteMapping("/regalo/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		serv.eliminar(id);
	}

}
