package scenarios;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.CarrinhoPage;
import pages.CheckOutLayoutBPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProdutoPage;
import utils.LeitorJsonWithGson;

public class CheckoutCompraLayoutB {

	WebDriver driver = new ChromeDriver();
	HomePage homepage = new HomePage(driver);
	ProdutoPage produto = new ProdutoPage(driver);
	CarrinhoPage carrinho = new CarrinhoPage(driver);
	LoginPage login = new LoginPage(driver);
	CheckOutLayoutBPage checkoutB = new CheckOutLayoutBPage(driver);
	public static final Logger logger = Logger.getLogger(CheckoutCompraLayoutB.class);
	
	LeitorJsonWithGson leitorMassa;

	@Before
	public void before() throws IOException {
		configuraChromeDriver();
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
			login.preencheEmail(leitorMassa.getMassa("email")); // preencher com e-mail de conta Submarino valida, entre // aspas duplas ("")
			login.preencheSenha(leitorMassa.getMassa("senha")); // preencher com senha de conta Submarino valida, entre aspas duplas ("")
			login.efetuaLogin();
			checkoutB.selecionaFrete();
			checkoutB.selecionaFormaPagamento();
			checkoutB.preencheCartaoCredito(leitorMassa.getMassa("cartao_credito"));
			checkoutB.preencheNomeCartaoCredito(leitorMassa.getMassa("nome_cartao_credito"));
			checkoutB.preencheMesValidade("7");
			checkoutB.preencheAnoValidade("2021");
			checkoutB.preencheCVV(leitorMassa.getMassa("cvv"));
			checkoutB.salvarDadosComprasFuturas();

		} catch (Exception e) {
			logger.info(e.getStackTrace() + " " + e.getMessage());
		}
	}

	@After
	public void after() {
		driver.quit();
	}

	/**
	 * Configura o Chrome Driver com espera Implicita de at� 90 Segundos
	 */
	private void configuraChromeDriver() {
		// Configura espera de at� 120 Segundos qualquer elemento.

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
}
