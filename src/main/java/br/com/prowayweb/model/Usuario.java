package br.com.prowayweb.model;

public class Usuario {
	
	private Long id;
	private String nome;
	private Tipo_usuario id_tipo_usuario;
	
	public Usuario(Long id, String nome) {
		this.id = id;
		this.nome = nome;
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
	public Tipo_usuario getId_tipo_usuario() {
		return id_tipo_usuario;
	}
	public void setId_tipo_usuario(Tipo_usuario id_tipo_usuario) {
		this.id_tipo_usuario = id_tipo_usuario;
	}
	

	
}
