package com.edgardalves.cursomc.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.edgardalves.cursomc.domain.Categoria;
import com.edgardalves.cursomc.services.CategoriaService;

/**
 * 
 * @author edgardalves
 * 
 * Endpoint: categorias/{id} 	-- 		Retornar Categoria e seus Produtos
 * Endpoint: clientes/{id} 	 	-- 		Retornar Cliente, seus telefones e seus endereços
 * Endpoint: pedidos/{id} 	 	-- 		Retornar Pedido, seu cliente, seu pagamento, seus itens de pedido, seu endereço de entrega
 *
 */

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService service;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Categoria obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Categoria> getListaCategorias() {
		return service.listarCategorias();
	}

}
