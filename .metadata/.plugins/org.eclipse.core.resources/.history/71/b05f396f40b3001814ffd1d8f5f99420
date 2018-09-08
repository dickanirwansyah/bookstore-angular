package com.bookstore.app.demobookstore.service;

import java.util.List;

import org.springframework.validation.annotation.Validated;

import com.bookstore.app.demobookstore.entity.Buku;

@Validated
public interface BukuService {

	List<Buku> getAllBuku();
	
	Buku save(Long penulisId, Long kategoriId, Buku buku);
	
	Buku update(Long bukuId, Long penulisId, Long kategoriId, Buku buku);
	
	Buku getId(Long id);
	
	Buku delete(Long id);
}
