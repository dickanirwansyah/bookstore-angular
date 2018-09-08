package com.bookstore.app.demobookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.app.demobookstore.entity.Buku;
import com.bookstore.app.demobookstore.service.BukuService;

@RestController
@RequestMapping(value = "/api/buku")
public class BukuController {
	
	@Autowired BukuService bukuService;

	@GetMapping
	public List<Buku> getAllBuku(){
		return bukuService.getAllBuku();
	}
	
	@PostMapping(value = "/{penulisId}/{kategoriId}")
	public ResponseEntity<Buku> save(@PathVariable("penulisId") Long penulisId,
									 @PathVariable("kategoriId") Long kategoriId,
									 @RequestBody Buku buku){
		
		Buku newBuku = bukuService.save(penulisId, kategoriId, buku);
		return ResponseEntity
				.ok()
				.body(newBuku);
	}
	
	@PutMapping(value = "/{penulisId}/{kategoriId}/{bukuId}")
	public ResponseEntity<Buku> update(@PathVariable("penulisId") Long penulisId,
									   @PathVariable("kategoriId") Long kategoriId,
									   @PathVariable("bukuId") Long bukuId,
									   @RequestBody Buku buku){
		
		Buku updateBuku = bukuService.update(penulisId, kategoriId, bukuId, buku);
		return ResponseEntity
				.ok()
				.body(updateBuku);
	}
	
	@DeleteMapping(value = "/{bukuId}")
	public ResponseEntity<?> delete(@PathVariable("bukuId") Long bukuId){
		
		bukuService.delete(bukuId);
		return ResponseEntity
				.ok()
				.build();
	}
	
	@GetMapping(value = "/{bukuId}")
	public ResponseEntity<Buku> getId(@PathVariable("bukuId") Long bukuId){
		Buku Idbuku = bukuService.getId(bukuId);
		return ResponseEntity
				.ok()
				.body(Idbuku);
	}
}
