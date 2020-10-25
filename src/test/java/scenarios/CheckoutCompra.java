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
import pages.CheckOutLayoutAPage;
import pages.CheckOutLayoutBPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProdutoPage;
import utils.LeitorJsonWithGson;

public class CheckoutCompra {

	WebDriver driver = new ChromeDriver();
	HomePage homepage = new HomePage(driver);
	ProdutoPage produto = new ProdutoPage(driver);
	CarrinhoPage carrinho = new CarrinhoPage(driver);
	LoginPage login = new LoginPage(driver);
	CheckOutLayoutAPage checkoutA = new CheckOutLayoutAPage(driver);
	CheckOutLayoutBPage checkoutB = new CheckOutLayoutBPage(driver);
	long inicioTeste;
	long fimTeste;
	public static final Logger logger = Logger.getLogger(CheckoutCompra.class);

	LeitorJsonWithGson leitorMassa;

	@Before
	public void before() throws IOException {
		configuraChromeDriver();
		inicioTeste = System.currentTimeMillis();
		leitorMassa = new LeitorJsonWithGson();
		leitorMassa.leitorJson();
	}

	@Test
	public void checkoutCompra() throws InterruptedException, IOException {

		try {
			homepage.acessaUrl(leitorMassa.getMassa("url"));
			homepage.aceitaCookies();
			homepage.efetuaBusca(leitorMassa.getMassa("produto"));
			homepage.selecionaProduto();
			produto.incluiProduto();
			carrinho.confirmaCarrinho();
			login.preencheEmail(leitorMassa.getMassa("email")); 
			login.preencheSenha(leitorMassa.getMassa("senha")); 
			login.efetuaLogin();

			if (checkoutA.validadeEstaVisivel() == true) {
				
				checkoutA.selecionaFrete();
				checkoutA.selecionaFormaPagamento();
				checkoutA.preencheCartaoCredito(leitorMassa.getMassa("cartao_credito"));
				checkoutA.preencheNomeCartaoCredito(leitorMassa.getMassa("nome_cartao_credito"));
				checkoutA.preencheValidade(leitorMassa.getMassa("validade"));
				checkoutA.preencheCVV(leitorMassa.getMassa("cvv"));
				checkoutA.salvarCartao();
				Assert.assertEquals(true, checkoutA.salvarCartao());

			} else {
				checkoutB.selecionaFrete();
				checkoutB.selecionaFormaPagamento();
				checkoutB.preencheCartaoCredito(leitorMassa.getMassa("cartao_credito"));
				checkoutB.preencheNomeCartaoCredito(leitorMassa.getMassa("nome_cartao_credito"));
				checkoutB.preencheMesValidade(leitorMassa.getMassa("mes_validade"));
				checkoutB.preencheAnoValidade(leitorMassa.getMassa("ano_validade"));
				checkoutB.preencheCVV(leitorMassa.getMassa("cvv"));
				checkoutB.salvarDadosComprasFuturas();
				Assert.assertEquals(true, checkoutB.salvarDadosComprasFuturas());
			}

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

	/**
	 * Configura o Chrome Driver com espera Implicita de 120 Segundos
	 */
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
