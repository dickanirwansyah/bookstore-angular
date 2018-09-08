package com.bookstore.app.demobookstore.service;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.bookstore.app.demobookstore.entity.Kategori;

import io.micrometer.core.lang.Nullable;

@Validated
public interface KategoriService {

	List<Kategori> getAllKategori();
	
	Kategori getKategoriId(Long id);
	
	Kategori save(Kategori kategori);
	
	Kategori update(Long id, Kategori kategori);
	
	Kategori disableStatus(Long id);
}
