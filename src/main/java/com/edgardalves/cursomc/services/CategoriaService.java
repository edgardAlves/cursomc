package com.edgardalves.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edgardalves.cursomc.domain.Categoria;
import com.edgardalves.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	
	/**
	 * Autowired - Spring instancia e faz a injecao de dependencia
	 * automaticamente ou inversao de controle
	 */
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer paramId) {
		Optional<Categoria> obj = repo.findById(paramId);
		
		return obj.orElse(null);
	}
	
	public List<Categoria> listarCategorias(){
		List<Categoria> listaCategorias = repo.findAll();
		
		return listaCategorias;
	}
}
