package scenarios;

import static org.junit.Assert.fail;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.CarrinhoPage;
import pages.HomePage;
import pages.ProdutoPage;

public class AdicionaProduto {

	WebDriver driver = new ChromeDriver();
	HomePage homepage = new HomePage(driver);
	ProdutoPage produto = new ProdutoPage(driver);
	CarrinhoPage carrinho = new CarrinhoPage(driver);

	public static final Logger logger = Logger.getLogger(AdicionaProduto.class);

	@Test
	public void adicionaProduto() throws InterruptedException, IOException {

		try {
			homepage.acessaUrl("https://www.submarino.com.br/");
			homepage.aceitaCookies();
			homepage.efetuaBusca("ração magnus premium filhotes");
			homepage.selecionaProduto();
			produto.incluiProduto();
			Assert.assertTrue("Calcule frete e prazo", carrinho.calcularFrete());
		} catch (Exception e) {
			logger.info(e.getStackTrace() + " " + e.getMessage());
			fail();
		}
	}

	@After
	public void after() {
		driver.quit();
	}
}
