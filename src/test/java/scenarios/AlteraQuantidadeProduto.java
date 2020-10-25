package scenarios;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.CarrinhoPage;
import pages.HomePage;
import pages.ProdutoPage;
import utils.LeitorJsonWithGson;

public class AlteraQuantidadeProduto {

	WebDriver driver = new ChromeDriver();
	HomePage homepage = new HomePage(driver);
	ProdutoPage produto = new ProdutoPage(driver);
	CarrinhoPage carrinho = new CarrinhoPage(driver);
	long inicioTeste;
	long fimTeste;

	public static final Logger logger = Logger.getLogger(AlteraQuantidadeProduto.class);
	
	LeitorJsonWithGson leitorMassa;
	
	@Before
	public void before() throws IOException {
		configuraChromeDriver();
		inicioTeste = System.currentTimeMillis();
		leitorMassa = new LeitorJsonWithGson();
		leitorMassa.leitorJson();
	}

	@Test
	public void alteraQuantidadeProduto() throws InterruptedException, IOException {

		try {
			homepage.acessaUrl(leitorMassa.getMassa("url"));
			homepage.aceitaCookies();
			homepage.efetuaBusca(leitorMassa.getMassa("produto"));
			homepage.selecionaProduto();
			produto.incluiProduto();
			carrinho.alteraQuantidade();
			Assert.assertEquals("2", carrinho.alteraQuantidade());
		} catch (Exception e) {
			logger.info(e.getStackTrace() + " " + e.getMessage());
			fail();
		}
	}

	@After
	public void after() {
		driver.quit();
		fimTeste = System.currentTimeMillis();
		logger.info("Tempo total de execução: " + calculaTempoExecucao(inicioTeste, fimTeste) + " segundos");
	}
	
	private void configuraChromeDriver() {
		// Configura espera de 120 Segundos para qualquer elemento.

//			driver.manage().window().maximize();		
//			ChromeOptions chromeOptions = new ChromeOptions();
//			chromeOptions.addArguments(
////					   "--headless"
//					   "--disable-web-security",
//					   "--ignore-certificate-errors",
//					   "--disable-gpu",
//					   "window-size=1200x600",
//					   "disable-popup-blocking",
//					   "disable-infobars"
//					  );
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	public long calculaTempoExecucao(long inicio, long fim) {
		return (fim - inicio) / 1000;
	}
}
