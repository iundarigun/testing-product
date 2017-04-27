package br.com.devcave.product;

import br.com.devcave.product.domain.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.RestTemplate;

@ContextConfiguration(classes = ProductApplication.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.DEFINED_PORT)
public class PesquisaProdutosStepDefs {


	private String url;
	private String id;
	private String result;
	private Exception exception;
	private Product product;

	@Before
	private void setup(){
		this.url = null;
		this.id = null;
		this.result = null;
		this.exception = null;
		this.product = null;
	}

	@Dado("^que o usuário deseje consultar pelo identificador$")
	public void queOUsuárioDesejeConsultarPeloIdentificador() throws Throwable {
		this.url = "http://localhost:8181/products/id/";
	}

	@Quando("^acionar a consulta com id vazio$")
	public void acionarAConsultaComIdVazio() throws Throwable {
		this.id = "";
		consultaPorId();
	}

	private void consultaPorId(){
		RestTemplate restTemplate = new RestTemplate();

		try {
			this.result = restTemplate.getForObject(this.url + id, String.class);
		}
		catch(Exception e){
			this.exception = e;
		}

	}

	@Então("^a consulta deve retornar uma exceção$")
	public void aConsultaDeveRetornarUmaExceção() throws Throwable {
		Assert.assertNotNull(exception);
	}

	@Quando("^acionar a consulta com id \"([^\"]*)\"$")
	public void acionarAConsultaComId(String id) throws Throwable {
		this.id = id;
		consultaPorId();
	}

	@Então("^a consulta não deve retornar produtos$")
	public void aConsultaNãoDeveRetornarProdutos() throws Throwable {
		Assert.assertNull(exception);
		Assert.assertNull(result);
	}

	@Então("^a consulta deve retornar o produto válido$")
	public void aConsultaDeveRetornarOProdutoVálido() throws Throwable {
		Assert.assertNull(exception);
		Assert.assertNotNull(result);
		ObjectMapper mapper = new ObjectMapper();
		this.product = mapper.readValue(result, Product.class);
		Assert.assertNotNull(this.product);
	}

	@E("^o nome do produto deve ser \"([^\"]*)\"$")
	public void oNomeDoProdutoDeveSer(String nome) throws Throwable {
		Assert.assertEquals(nome,product.getName());
	}

	@E("^a categoria do produto deve ser \"([^\"]*)\"$")
	public void aCategoriaDoProdutoDeveSer(String categoria) throws Throwable {
		Assert.assertNotNull(product.getCategory());
		Assert.assertEquals(categoria,product.getCategory().getName());
	}
}
