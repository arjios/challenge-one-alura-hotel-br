package dto;

import java.time.Instant;

import entities.Hospede;

public class HospedeDTO {

	private Long id;
	private String nome;
	private String sobrenome;
	private String telefone;
	private Instant dataNascimento;
	private Integer idReserva;
	private String nacionalidade;
	
	public HospedeDTO() {
	}

	public HospedeDTO(Long id, String nome, String sobrenome, String telefone, Instant dataNascimento,
			Integer idReserva, String nacionalidade) {
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
		this.idReserva = idReserva;
		this.nacionalidade = nacionalidade;
	}
	
	public HospedeDTO(Hospede entity) {
		id = entity.getId();
		nome = entity.getNome();
		sobrenome = entity.getSobrenome();
		telefone = entity.getTelefone();
		dataNascimento = entity.getDataNascimento();
		idReserva = entity.getIdReserva();
		nacionalidade = entity.getNacionalidade();
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

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

}
