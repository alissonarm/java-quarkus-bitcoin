package br.com.alura.model;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.security.jpa.Password;
import io.quarkus.security.jpa.Roles;
import io.quarkus.security.jpa.UserDefinition;
import io.quarkus.security.jpa.Username;

@Entity
@UserDefinition   // indica que o framework irá utilizar para validar as informações do usuário
public class Usuario extends PanacheEntityBase {
	
	// anotações com definição da chave e autoincremento
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private String cpf;
	
	@Username
	private String username;
	
	@Password
	private String password;
	
	@Roles
	private String role;

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	@JsonbTransient                    // não devolve esta informação para o usuario - desconsidera a  informação 
	public String getPassword() {
		return password;
	}

	public String getRole() {
		return role;
	}
	
	public String getNome() {
		return nome;
	}

	public static void adicionar(Usuario usuario) {
		usuario.password = BcryptUtil.bcryptHash(usuario.password);
		usuario.role = validarUsername(usuario.username);
		usuario.persist();
	}

	private static String validarUsername(String username) {
		if (username.equals("alura")) {
			return "admin";
		}
		return "user";
	}
	
	
}
