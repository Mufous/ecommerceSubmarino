package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

	final String BTN_ACEITA_COOKIES = "//button[@id='lgpd-accept']";
	final String BUSCA = "//input[@id='h_search-input']";
	final String BTN_EFETUA_BUSCA = "//button[@id='h_search-btn']";
	final String PRODUTO = "//body/div[@id='root']/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[6]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/a[1]/section[1]/div[1]/div[1]/div[1]/picture[1]/img[1]";

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void acessaUrl(String url) throws IOException { // a variavel url é declarada dentro do parenteses, e o valor
															// da variavel é
		// definido na classe de testes, de modo a tornar esse metodo capaz de abrir
		// qualquer url
		driver.get(url);
		screenShot("acessa a URL");
		logger.info("URL acessada com sucesso.");
	}

	public void aceitaCookies() throws IOException {

		driver.findElement(By.xpath(BTN_ACEITA_COOKIES)).click();
		screenShot("aceita os cookies");
		logger.info("Cookies aceitos com sucesso.");
	}

	public void efetuaBusca(String produtoDesejado) throws InterruptedException, IOException {

		driver.findElement(By.xpath(BUSCA)).sendKeys(produtoDesejado);
		driver.findElement(By.xpath(BTN_EFETUA_BUSCA)).click();
		screenShot("busca o Produto");
		logger.info("Busca efetuada com sucesso.");
	}

	public void selecionaProduto() throws InterruptedException, IOException {
		driver.findElement(By.xpath(PRODUTO)).click();
		screenShot("seleciona o Produto");
		logger.info("Produto selecionado com sucesso.");
	}
}
