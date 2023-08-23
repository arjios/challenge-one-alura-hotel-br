package dto;

import entities.User;

public class UserDTO {

	private Long id;
	private String nome;
	private String senha;
	
	public UserDTO() {
	}

	public UserDTO(Long id, String nome, String senha) {
		this.id = id;
		this.nome = nome;
		this.senha = senha;
	}

	public UserDTO(User entity) {
		id = entity.getId();
		nome = entity.getNome();
		senha = entity.getSenha();
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
