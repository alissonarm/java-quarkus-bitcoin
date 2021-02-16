package br.com.alura.service;

import java.util.List;

//import javax.enterprise.inject.Produces;
import javax.ws.rs.Produces;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import br.com.alura.model.Bitcoin;

@Path("/bitcoins")                               // informar o recurso que sera consumido
@RegisterRestClient(configKey = "bitcoin-api")   // informa que este serviço pode ser injetado
public interface BitcoinService {

	@GET                                         // tipo de requisição
	@Produces(MediaType.APPLICATION_JSON)        // tipo de retorno - irá retornar o JSON
	public List<Bitcoin> listar();
	
	
}
