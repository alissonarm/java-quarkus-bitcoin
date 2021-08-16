package br.com.alura.resource;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.alura.model.Usuario;

@Path("/usuarios")
public class UsuarioResource {
	
	@POST
	@PermitAll
	@Transactional
	@Consumes(MediaType.APPLICATION_JSON)
	public void inserir(Usuario usuario) {
//		Usuario.persist(usuario);         -- Persiste sem validar
		Usuario.adicionar(usuario);       // Realiza validações antes de chamar o método persist.
	}
	
	@GET
	@RolesAllowed("admin")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Usuario> lista() {
		return Usuario.listAll();
	}

}
