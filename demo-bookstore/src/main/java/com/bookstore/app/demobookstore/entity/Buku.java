package com.bookstore.app.demobookstore.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name = "buku", 
uniqueConstraints = @UniqueConstraint(columnNames="judul"))
public class Buku implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "judul", nullable = false)
	private String judul;
	
	@Max(100)
	@Min(1)
	@Column(name = "jumlah", nullable = false)
	private Integer jumlah;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "kategori_id", nullable = false)
	private Kategori kategori;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "penulis_id", nullable = false)
	private Penulis penulis;
	
	public Buku() {
		
	}
	
	public Buku(Long id, String judul, Integer jumlah, Kategori kategori, Penulis penulis) {
		this.id = id;
		this.judul = judul;
		this.jumlah = jumlah;
		this.kategori = kategori;
		this.penulis = penulis;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getJudul() {
		return judul;
	}
	
	public void setJudul(String judul) {
		this.judul = judul;
	}
	
	public Integer getJumlah() {
		return jumlah;
	}
	
	public void setJumlah(Integer jumlah) {
		this.jumlah = jumlah;
	}
	
	public Kategori getKategori() {
		return kategori;
	}
	
	public void setKategori(Kategori kategori) {
		this.kategori = kategori;
	}
	
	public Penulis getPenulis() {
		return penulis;
	}
	
	public void setPenulis(Penulis penulis) {
		this.penulis = penulis;
	}
}
