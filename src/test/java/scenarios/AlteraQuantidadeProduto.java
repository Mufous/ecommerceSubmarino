package scenarios;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.CarrinhoPage;
import pages.HomePage;
import pages.ProdutoPage;

public class AlteraQuantidadeProduto {

	WebDriver driver = new ChromeDriver();
	HomePage homepage = new HomePage(driver);
	ProdutoPage produto = new ProdutoPage(driver);
	CarrinhoPage carrinho = new CarrinhoPage(driver);

	public static final Logger logger = Logger.getLogger(AlteraQuantidadeProduto.class);

	@Test
	public void alteraQuantidadeProduto() throws InterruptedException, IOException {

		try {
			homepage.acessaUrl("https://www.submarino.com.br/");
			homepage.aceitaCookies();
			homepage.efetuaBusca("ração magnus premium filhotes");
			homepage.selecionaProduto();
			produto.incluiProduto();
			carrinho.alteraQuantidade();
		} catch (Exception e) {
			logger.info(e.getStackTrace() + " " + e.getMessage());
		}
	}

	@After
	public void after() {
		driver.quit();
	}
}
