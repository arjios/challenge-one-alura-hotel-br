package entities;

import java.io.Serializable;
import java.time.Instant;

public class Hospede implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private String sobrenome;
	private String nacionalidade;
	private String telefone;
	private Instant dataNascimento;
	private Integer idReserva;
	
	public Hospede() {

	}

	public Hospede(Long id, String nome, String sobrenome, String nacionalidade, String telefone,
			Instant dataNascimento, Integer idReserva) {
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.nacionalidade = nacionalidade;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
		this.idReserva = idReserva;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Instant getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Instant dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Integer getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(Integer idReserva) {
		this.idReserva = idReserva;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hospede other = (Hospede) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
