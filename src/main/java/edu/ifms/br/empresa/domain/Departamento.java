package edu.ifms.br.empresa.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "DEPARTAMENTOS")
public class Departamento extends AbstractEntity<Long> {
	
	@NotBlank(message = "Informe um nome")
	@Size(min=3, max=60, 
	  message = "O nome do departamento deve ter entre {min} e {max} caracteres")
	@Column(name = "nome", nullable = false, unique = true, length = 60)
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
