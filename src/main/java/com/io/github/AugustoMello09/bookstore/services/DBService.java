package com.io.github.AugustoMello09.bookstore.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.io.github.AugustoMello09.bookstore.domain.Categoria;
import com.io.github.AugustoMello09.bookstore.domain.Livro;
import com.io.github.AugustoMello09.bookstore.repositories.CategoriaRepository;
import com.io.github.AugustoMello09.bookstore.repositories.LivroRepository;

@Service
public class DBService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private LivroRepository livroRepository;
	
	public void instaciaBaseDeDados() {
		
		Categoria cat1 = new Categoria(null, "Informática", "Livro de TI");
		Livro l1 = new Livro(null, "Clean Code", "Robert Martin", "Lorem ipsum", cat1);
		
		cat1.getLivros().addAll(Arrays.asList(l1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1));
		livroRepository.saveAll(Arrays.asList(l1));
	}
}
