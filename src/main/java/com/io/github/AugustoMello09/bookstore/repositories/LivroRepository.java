package com.io.github.AugustoMello09.bookstore.repositories;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.io.github.AugustoMello09.bookstore.domain.Livro;

@Repository
public interface LivroRepository  extends JpaRepository<Livro, Integer>{
	
	@Query("SELECT obj FROM Livro obj WHERE obj.categoria.id = :id_cat ORDER BY titulo")
	List<Livro> findAllByCategoria(@Param(value ="id_cat") Integer id_cat);

}
