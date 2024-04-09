package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

private final LivroService livroRepository;

@Autowired
public LivroController(LivroService livroService) {
	this.livroService = livroService;
}

@GetMapping("/{id}")
public ResponseEntity<Livro> buscarLivroId(@PathVariable Long id){
	Livro livro = livroService.buscaPorId(id);
	if (livro != null) {
		return ResponseEntity.ok(livro);
	}else {
		return ResponseEntity.notFound().build();
	}
}
@GetMapping
public ResponseEntity<List<Livro>> buscaTodosLivros(){
	list<livro> livro = livroService.buscaTodos();
	return ResponseEntity.ok(livro);
}
@PostMapping
public ResponseEntity<LivroDTO> criar(@ResquestBody @Valid Livro livro){
 LivroDTO salvarLivro = livroService.salvar(livro);
 return ResponseEntity.status(HttpStatus.Created). body(salvarLivro);
}
 @DeleteMapping ("{id}")
 public ResponseEntity<livro> deleteLivro(@PathVariable Long id){
	 boolean apagar = livroService.deletar(id);
	 if (apagar) {
		 return ResponseEntity.status(HttpStatus. NO_content). buind();
	 }
	 }
}
