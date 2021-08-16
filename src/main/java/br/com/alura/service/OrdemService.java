package br.com.alura.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.SecurityContext;

import br.com.alura.model.Ordem;
import br.com.alura.model.Usuario;
import br.com.alura.repository.OrdemRepository;

@ApplicationScoped
public class OrdemService {
	
	@Inject
	OrdemRepository ordemRepository;
	
	public void inserir(SecurityContext securityContext, Ordem ordem) {
		Optional<Usuario> usuarioOptional = Usuario.findByIdOptional(ordem.getUserId()); //pesquisa o usuario com UserId(pode ou não existir) 
		Usuario usuario = usuarioOptional.orElseThrow();                                 // se existir move para usuario, senão lança a exceção 
		
		if(!usuario.getUsername().equals(securityContext.getUserPrincipal().getName())){
			throw new RuntimeException("O usuario logado e diferente do userId");
		}
		ordem.setData(LocalDate.now());
		ordem.setStatus("Enviada");
		ordemRepository.persist(ordem);
	}

	public List<Ordem> listar() {
		return ordemRepository.listAll();
	}

}
