package com.familiaflores.controladores;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.familiaflores.modelos.Familia;
import com.familiaflores.servicios.IFamiliServicio;

@RestController
@RequestMapping("/apiFamilias")
public class FamiliaControladores {

	@Autowired
	private IFamiliServicio ser;

	/*
	 * @GetMapping(value = "/familias",produces = MediaType.APPLICATION_JSON_VALUE)
	 * public ResponseEntity<List<Familia>> listar1() { List<Familia> familia = new
	 * ArrayList<>(); familia = ser.listar(); return new
	 * ResponseEntity<List<Familia>>(familia, HttpStatus.OK); }
	 */

	@GetMapping("/familias")
	public Map<String, Object> listar() {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", ser.listar());
		return result;
	}

	@GetMapping("/familia/{id}")
	public Familia listarFamiliaId(@PathVariable Long id) {
		return ser.leer(id);
	}

	@PostMapping("/familia")
	@ResponseStatus(HttpStatus.CREATED)
	public Familia create(@RequestBody Familia familia) {
		return ser.registrar(familia);
	}

	@PostMapping("/familia/{id}")
	public Familia update(@RequestBody Familia familia, @PathVariable Long id) {
		Familia familiaActual = ser.leer(id);
		familiaActual.setNombre(familia.getNombre());
		familiaActual.setApellido(familia.getApellido());
		familiaActual.setEdad(familia.getEdad());
		familiaActual.setSexo(familia.getSexo());
		familiaActual.setTelefono(familia.getTelefono());
		return ser.modificar(familiaActual);
	}

	@DeleteMapping("/familia/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		ser.eliminar(id);
	}
}
