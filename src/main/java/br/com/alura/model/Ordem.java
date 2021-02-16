package br.com.alura.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ordem {
	
	// anotações com definição da chave e autoincremento
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private double preco;
	
	private String tipo;
	
	private LocalDate data;
	
	private String status;

	@Column(name = "user_id")
	private Long userId;

	public Long getUserId() {
		return userId;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getId() {
		return id;
	}

	public double getPreco() {
		return preco;
	}

	public String getTipo() {
		return tipo;
	}

	public LocalDate getData() {
		return data;
	}

	public String getStatus() {
		return status;
	}
	
}
