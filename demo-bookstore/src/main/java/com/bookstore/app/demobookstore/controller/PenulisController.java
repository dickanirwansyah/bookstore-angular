package com.bookstore.app.demobookstore.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.app.demobookstore.entity.Penulis;
import com.bookstore.app.demobookstore.service.PenulisService;

@RestController
@RequestMapping(value = "/api/penulis")
public class PenulisController {

	@Autowired private PenulisService penulisService;
	
	@GetMapping(value = {"/", ""})
	public @NotNull Iterable<Penulis> getAllPenulis(){
		return penulisService.getAllPenulis();
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Penulis> getId(@PathVariable("id") Long id) {
		Penulis penulisId = penulisService.getByIdpenulis(id);
		return ResponseEntity
				.ok()
				.body(penulisId);
	}
	
	@PostMapping
	public ResponseEntity<Penulis> save(@Valid @RequestBody Penulis penulis){
		Penulis newPenulis = penulisService.save(penulis);
		return ResponseEntity
				.ok()
				.body(newPenulis);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Penulis> update(@PathVariable("id") Long id,
										  @Valid @RequestBody Penulis penulis){
		
		Penulis updatePenulis = penulisService.update(id, penulis);
		return ResponseEntity
				.ok()
				.body(updatePenulis);
	}
}
