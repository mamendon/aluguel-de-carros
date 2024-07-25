package br.ufg.inf.bsi.alugueldecarros.dto;

import java.io.Serializable;
import br.ufg.inf.bsi.alugueldecarros.domain.Pessoa;

public class PessoaDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer ID;
	private String nome;
		
	public PessoaDTO() {
		super();
	}
	
	
	
	public PessoaDTO(Pessoa obj) {
		this.ID = obj.getId();
		this.nome = obj.getNome();
	}



	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
}
