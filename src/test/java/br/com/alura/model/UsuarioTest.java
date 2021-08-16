package br.com.alura.model;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import br.com.alura.model.Usuario;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.panache.mock.PanacheMock;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class UsuarioTest {

	@Test
	public void testarSeFindByIdOptionaRetornaUsuarioCorreto() {
		PanacheMock.mock(Usuario.class);

		Usuario u = new Usuario();

		Optional<PanacheEntityBase> usuario = Optional.of(u);

		Mockito.when(Usuario.findByIdOptional(9)).thenReturn(usuario);

		Assertions.assertSame(u, Usuario.findByIdOptional(9).get());

	}
}
