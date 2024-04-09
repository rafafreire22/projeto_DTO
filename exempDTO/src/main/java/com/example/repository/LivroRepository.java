package com.example.repository;

import org.springframework.data.jpa.repository.JpaContext;
import com.example.exempDTO.entities.Livros;
public interface LivroRepository extends JpaRepository<Livro,Long>{
}
