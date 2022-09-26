package com.registro.modelDOMEN;

import java.io.Serializable;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "viajantes")
public class Viajante implements Serializable {
	
	private static final long serialVersionUID = 1L; 

	//variaveis
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // indica identidade do cadastro - valor unico
	private long id;
	
	@Column
	private String nome;

	@Column
	private int documento;

	@Column
	private String telefone;

	@Column
	private String nascimento;

	@Column
	private String email;

	@Column
	private String senha;

	public Viajante() {  /* @NoArgsConstructor */
		super();
	}

	public Viajante(long id, String nome, int documento, String telefone, String nascimento, String email,
			String senha) { /* @AllArgsConstructor */
		super();
		this.id = id;
		this.nome = nome;
		this.documento = documento;
		this.telefone = telefone;
		this.nascimento = nascimento;
		this.email = email;
		this.senha = senha;
	}

	public long getId() { /* @Data faz os getters and setters */
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getDocumento() {
		return documento;
	}

	public void setDocumento(int documento) {
		this.documento = documento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getNascimento() {
		return nascimento;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override // faz verificação do identificador unico  /* @Data faz hashCode*/
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Viajante other = (Viajante) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Viajante [id=" + id + ", nome=" + nome + ", documento=" + documento + ", telefone=" + telefone
				+ ", nascimento=" + nascimento + ", email=" + email + ", senha=" + senha + "]";
	}
	
}
