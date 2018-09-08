package com.bookstore.app.demobookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.app.demobookstore.entity.Buku;

public interface BukuRepository extends JpaRepository<Buku, Long>{

}
