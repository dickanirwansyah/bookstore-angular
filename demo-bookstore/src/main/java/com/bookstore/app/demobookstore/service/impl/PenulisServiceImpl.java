package com.bookstore.app.demobookstore.service.impl;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookstore.app.demobookstore.entity.Penulis;
import com.bookstore.app.demobookstore.execption.ResourceNotFoundException;
import com.bookstore.app.demobookstore.repository.PenulisRepository;
import com.bookstore.app.demobookstore.service.PenulisService;

@Service
@Transactional
public class PenulisServiceImpl implements PenulisService{
	
	@Autowired PenulisRepository penulisRepository;

	@Override
	public @NotNull Iterable<Penulis> getAllPenulis() {
		return penulisRepository.findAll();
	}

	@Override
	public Penulis getByIdpenulis(@Min(value = 1, message = "kode penulis tidak valid") long id) {
		return penulisRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("kode penulis tidak ditemukan"));
	}

	@Override
	public Penulis save(Penulis penulis) {
		return penulisRepository.save(penulis);
	}

	@Override
	public Penulis update(@Min(value = 1, message = "kode penulis tidak valid") long id, Penulis penulis) {
		return penulisRepository.findById(id)
				.map(dataPenulis -> {
					dataPenulis.setName(penulis.getName());
					return penulisRepository.save(dataPenulis);
				}).orElseThrow(() -> new ResourceNotFoundException("kode penulis tidak ditemukan"));
	}

}
