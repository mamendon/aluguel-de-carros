package br.ufg.inf.bsi.alugueldecarros.dto;

import java.io.Serializable;
import br.ufg.inf.bsi.alugueldecarros.domain.Pessoa;

public class PessoaDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer ID;
	private String nome;
	private String cpf;
	private String email;
	private String telefone;
		
	public PessoaDTO() {
		super();
	}
	
	
	
	public PessoaDTO(Pessoa obj) {
		this.ID = obj.getId();
		this.nome = obj.getNome();
		this.cpf = obj.getCpf();
	}



	public Integer getID() {
		return ID;
	}
	public void setID(Integer id) {
		ID = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
	
}
