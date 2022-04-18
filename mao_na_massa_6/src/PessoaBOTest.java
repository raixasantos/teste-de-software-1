import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.sistema.crud.jdbc.bo.PessoaBO;
import br.sistema.crud.jdbc.dao.PessoaDAO;
import br.sistema.crud.jdbc.dto.PessoaDTO;
import br.sistema.crud.jdbc.exception.NegocioException;
import br.sistema.crud.jdbc.exception.PersistenciaExcpetion;

public class PessoaBOTest {
	PessoaBO pessoaBO;
	PessoaDAO pessoaDAO;
	PessoaDTO pessoaDTO;
	
	@Before
	public void setUp() throws Exception {
		pessoaDTO = new PessoaDTO();
		pessoaDAO = new PessoaDAO();
		pessoaBO = new PessoaBO();
	}

	@Test
	public void testValidarCadastroComSucesso() throws NegocioException, PersistenciaExcpetion {
		pessoaDTO.setCpf(10000000000L);
		pessoaDTO.setIdPessoa(1);
		try {
			pessoaBO.cadastrar(pessoaDTO, pessoaDAO);
			assertEquals(pessoaDTO, pessoaDAO.buscarPorId(pessoaDTO.getIdPessoa()));
		} catch (NegocioException e) {
			fail("Cadastro lançou uma exceção inesperada");
		}		
	}
	
	@Test
	public void testValidarCadastroSemSucesso() throws NegocioException, PersistenciaExcpetion {
		// pensar melhor
		try {
			pessoaBO.cadastrar(pessoaDTO, pessoaDAO);			
			fail("Cadastro não lançou uma exceção inesperada");
		} catch (NegocioException e) {
			assertNotNull(e);
		}		
	}

}
