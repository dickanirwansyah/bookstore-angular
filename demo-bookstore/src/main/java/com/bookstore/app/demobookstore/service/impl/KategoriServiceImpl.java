package com.bookstore.app.demobookstore.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookstore.app.demobookstore.entity.Kategori;
import com.bookstore.app.demobookstore.execption.ResourceNotFoundException;
import com.bookstore.app.demobookstore.repository.KategoriRepository;
import com.bookstore.app.demobookstore.service.KategoriService;

@Service
@Transactional
public class KategoriServiceImpl implements KategoriService{
	
	@Autowired KategoriRepository kategoriRepository;

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public Kategori getKategoriId(Long id) {
		return kategoriRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("kode kategori tidak ada"));
	}

	@Override
	public Kategori save(Kategori kategori) {
		return kategoriRepository.save(kategori);
	}

	@Override
	public Kategori update(Long id, Kategori kategori) {
		return kategoriRepository.findById(id)
				.map(dataKategori -> {
					dataKategori.setName(kategori.getName());
					dataKategori.setStatus(kategori.isStatus());
					return kategoriRepository.save(dataKategori);
				}).orElseThrow(() -> new ResourceNotFoundException("kode kategori tidak ada"));
	}

	@Override
	public Kategori disableStatus(Long id) {
		return kategoriRepository.findById(id)
				.map(dataKategori -> {
					dataKategori.setStatus(false);
					return kategoriRepository.save(dataKategori);
				}).orElseThrow(() -> new ResourceNotFoundException("kode kategori tidak ada"));
	}
	
	/** clause where dengan JPQL **/
	@Override
	public List<Kategori> getAllKategori() {
		Query query = entityManager.createQuery("SELECT k FROM Kategori k WHERE k.status=true");
		List<Kategori> list = (List<Kategori>) query.getResultList();
		return list;
	}

}
