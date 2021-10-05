package com.bolsadeideas.springboot.form.app.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bolsadeideas.springboot.form.app.models.domain.Pais;

@Service
public class PaisServiceImpl implements PaisService {

	
	private List<Pais> list;
	
	public PaisServiceImpl() {

     this.list= Arrays.asList(new Pais(1, "ES", "España"), 
				new Pais(2, "MX", "Mexico"), 
				new Pais(3, "CL", "Chile"),
				new Pais(4, "AR", "Argentina"), 
				new Pais(5, "PE", "Perú"), 
				new Pais(6, "CO", "Colombia"),
				new Pais(7, "VE", "Venezuela"));
    		 
	}
	@Override
	public List<Pais> listar() {
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public Pais obtenerPorId(Integer id) {
		 Pais resultado = null;
		  for(Pais pais: this.list) {
			  if(id == pais.getId()) {
				  resultado = pais;
				  break;
			  }
		  } 
		  return resultado;
	}

}
