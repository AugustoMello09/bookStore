package com.io.github.AugustoMello09.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.io.github.AugustoMello09.bookstore.domain.Livro;

@Repository
public interface LivroRepository  extends JpaRepository<Livro, Integer>{

}
