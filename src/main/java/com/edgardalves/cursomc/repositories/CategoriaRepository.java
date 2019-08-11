package com.edgardalves.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edgardalves.cursomc.domain.Categoria;

/**
 *@author edgardalves
 *
 * Foi inserido Integer pois a chave primaria de Categoria (id) é um Integer
 *
 */

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{
	
}
