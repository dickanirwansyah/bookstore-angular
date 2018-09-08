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
@Table(name = "penulis",
		uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Penulis {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@OneToMany(mappedBy = "penulis")
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Set<Buku> bukus = new HashSet<>();
	
	public Penulis() {
		
	}
	
	public Penulis(Long id, String name) {
		this.id = id;
		this.name = name;
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

	public Set<Buku> getBukus(){
		return bukus;
	}
	
	public void setBukus(Set<Buku> bukus) {
		this.bukus = bukus;
	}
}
