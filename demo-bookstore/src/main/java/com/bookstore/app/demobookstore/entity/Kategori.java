package com.bookstore.app.demobookstore.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "kategori", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Kategori {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "status")
	private boolean status;
	
	@OneToMany(mappedBy = "kategori")
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Set<Buku> bukus = new HashSet<>();
	
	public Kategori() {
		
	}
	
	public Kategori(Long id, String name, boolean status) {
		this.id = id;
		this.name = name;
		this.status = status;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public Set<Buku> getBukus(){
		return bukus;
	}
	
	public void setBukus(Set<Buku> bukus) {
		this.bukus = bukus;
	}
}
