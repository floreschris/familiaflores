package com.familiaflores.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "regalos")
public class Regalo {


  
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long idRegalo;
    
    //@Column(name = "icono", length = 20)
	private Integer idFamilia;
    
	private String nombre;
	private String url1;
	private String url2;
	
	
	public Long getIdRegalo() {
		return idRegalo;
	}
	public void setIdRegalo(Long idRegalo) {
		this.idRegalo = idRegalo;
	}
	public Integer getIdFamilia() {
		return idFamilia;
	}
	public void setIdFamilia(Integer idFamilia) {
		this.idFamilia = idFamilia;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getUrl1() {
		return url1;
	}
	public void setUrl1(String url1) {
		this.url1 = url1;
	}
	public String getUrl2() {
		return url2;
	}
	public void setUrl2(String url2) {
		this.url2 = url2;
	}
	
	
	
	
	
	

}
