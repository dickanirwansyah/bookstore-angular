package com.bookstore.app.demobookstore.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.app.demobookstore.entity.Kategori;
import com.bookstore.app.demobookstore.service.KategoriService;

@RestController
@RequestMapping(value = "/api/kategori")
public class KategoriController {

	@Autowired KategoriService kategoriService;
	
	@GetMapping
	public List<Kategori> getAllKategori(){
		return kategoriService.getAllKategori();
	}
	
	@PostMapping
	public ResponseEntity<Kategori> save(@Valid @RequestBody Kategori kategori){
		Kategori newKategori = kategoriService.save(kategori);
		return ResponseEntity
				.ok()
				.body(newKategori);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Kategori> update(@PathVariable("id") Long id,
										   @Valid @RequestBody Kategori kategori){
		
		Kategori updateKategori = kategoriService.update(id, kategori);
		return ResponseEntity
				.ok()
				.body(updateKategori);
	}
	
	@PutMapping(value = "/disabled/{id}")
	public ResponseEntity<Kategori> disabled(@PathVariable("id") Long id){
		
		Kategori disabled = kategoriService.disableStatus(id);
		return ResponseEntity
				.ok()
				.body(disabled);
	}
}
