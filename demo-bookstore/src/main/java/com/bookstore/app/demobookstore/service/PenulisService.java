package com.bookstore.app.demobookstore.service;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.bookstore.app.demobookstore.entity.Penulis;

@Validated
public interface PenulisService {
	
	/** list penulis **/
	@NotNull Iterable<Penulis> getAllPenulis();
	
	/** get penulis by id **/
	Penulis getByIdpenulis(@Min(value = 1L, message = "kode penulis tidak valid") long id);
	
	/** save penulis **/
	Penulis save(Penulis penulis);
	
	/** update penulis **/
	Penulis update(@Min(value = 1L, message = "kode penulis tidak valid")long id, Penulis penulis);
}
