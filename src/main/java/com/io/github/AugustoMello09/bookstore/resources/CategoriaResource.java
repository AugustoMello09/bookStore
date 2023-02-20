package com.io.github.AugustoMello09.bookstore.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.io.github.AugustoMello09.bookstore.domain.Categoria;
import com.io.github.AugustoMello09.bookstore.dto.CategoriaDTO;
import com.io.github.AugustoMello09.bookstore.services.CategoriaService;

@RestController
@RequestMapping(value = "/categoria")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService categoriaService; 
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Integer id){
		Categoria obj = categoriaService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> findAll(){
		 List<Categoria> list = categoriaService.findAll();
		 List<CategoriaDTO> listDTO = 
				 list.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
		 return ResponseEntity.ok().body(listDTO);
	}
	
	@PostMapping
	public ResponseEntity<Categoria> create(@RequestBody Categoria obj){
		obj = categoriaService.create(obj);
		URI  uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId())
				.toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<CategoriaDTO> update(@PathVariable Integer id,@RequestBody CategoriaDTO objDto){
		Categoria newObj = categoriaService.update(id, objDto);
		return ResponseEntity.ok().body(new CategoriaDTO(newObj));
	}
}
