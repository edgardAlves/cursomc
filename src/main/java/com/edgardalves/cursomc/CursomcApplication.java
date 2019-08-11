package com.edgardalves.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.edgardalves.cursomc.domain.Categoria;
import com.edgardalves.cursomc.domain.Produto;
import com.edgardalves.cursomc.repositories.CategoriaRepository;
import com.edgardalves.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Escritório");
		Categoria cat2 = new Categoria(null, "Informática");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		/**
		 * Categoria 1 de acordo com o mapeamento relacional ela tem 3 produtos || Categoria 1 (Escritório) - ("Computador", "Impressora", "Mouse")
		 * 
		 * Categoria 2 de acordo com o mapeamento relacional ela tem somente 1 produto || Categoria 2 (Informática) - ("Impressora")
		 */
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		/**
		 * Com isso as Categorias conhecem quais produtos elas tem (Quais produtos estao associados com elas), porem os Produtos nao sabem quais Categorias deles
		 * Fazer o mesmo com Produtos
		 */
		
		/**
		 * Produto 1 e somente da Categoria 1
		 */
		p1.getCategorias().add(cat1);
		
		/**
		 * Produto 2 esta relacionado a 2 Categorias ("Escritorio e Informatica")
		 */
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		
		p3.getCategorias().add(cat1);
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
	}

}
