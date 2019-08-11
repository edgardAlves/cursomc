package com.edgardalves.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edgardalves.cursomc.domain.Produto;

/**
 *@author edgardalves
 *
 * Foi inserido Integer pois a chave primaria de Produto (id) é um Integer
 *
 */

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
	
}
