package com.bookstore.app.demobookstore.service.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookstore.app.demobookstore.entity.Buku;
import com.bookstore.app.demobookstore.execption.ResourceNotFoundException;
import com.bookstore.app.demobookstore.repository.BukuRepository;
import com.bookstore.app.demobookstore.repository.KategoriRepository;
import com.bookstore.app.demobookstore.repository.PenulisRepository;
import com.bookstore.app.demobookstore.service.BukuService;

@Service
@Transactional
public class BukuServiceImpl implements BukuService{

	@Autowired PenulisRepository penulisRepository;
	
	@Autowired KategoriRepository kategoriRepository;
	
	@Autowired BukuRepository bukuRepository;
	
	@PersistenceContext EntityManager entityManager;
	
	/** clause inner join **/
	@Override
	public List<Buku> getAllBuku() {
		Query query = entityManager
				.createQuery("SELECT b FROM Buku b WHERE b.kategori.status=true");
		List<Buku> list = query.getResultList();
		return list;
	}

	@Override
	public Buku save(Long penulisId, Long kategoriId, Buku buku) {
		return penulisRepository.findById(penulisId)
				.map(penulis -> {
					return kategoriRepository.findById(kategoriId)
							.map(kategori -> {
								buku.setKategori(kategori);
								buku.setPenulis(penulis);
								return bukuRepository.save(buku);
							}).orElseThrow(() -> new ResourceNotFoundException("kode kategori tidak ada"));
				}).orElseThrow(() -> new ResourceNotFoundException("kode penulis tidak ada"));
	}


	@Override
	public Buku getId(Long id) {
		return bukuRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("kode buku tidak valid"));
	}

	@Override
	public void delete(Long id) {
		Buku bukuId = this.getId(id);
		if(bukuId == null) {
			throw new ResourceNotFoundException("kode buku tidak valid");
		}
		bukuRepository.delete(bukuId);
	}

	@Override
	public Buku update(Long penulisId, Long kategoriId, Long bukuId, Buku buku) {
		return penulisRepository.findById(penulisId)
				.map(penulis -> {
					return kategoriRepository.findById(kategoriId)
							.map(kategori -> {
								return bukuRepository.findById(bukuId)
										.map(mapperBuku -> {
											mapperBuku.setJudul(buku.getJudul());
											mapperBuku.setJumlah(buku.getJumlah());
											mapperBuku.setPenulis(penulis);
											mapperBuku.setKategori(kategori);
											return bukuRepository.save(mapperBuku);
										})
										.orElseThrow(() -> new ResourceNotFoundException("kode buku tidak valid"));
							})
							.orElseThrow(() -> new ResourceNotFoundException("kode kategori tidak ada"));
				})
				.orElseThrow(() -> new ResourceNotFoundException("kode penulis tidak ada"));
	}

}
