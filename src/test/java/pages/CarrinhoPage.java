package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CarrinhoPage extends BasePage{

	final String BTN_CARRINHO = "//a[@class='crt-link']//*[local-name()='svg']";
	final String BTN_VER_MEU_CARRINHO = "//a[@class='crt-basquet']";
	final String BTN_MAIS = "//span[@class='quantityIcon icon-plus']";
	final String BTN_REMOVER = "//span[@class='basket-productRemoveAct link-primary']";
	final String BTN_CONTINUAR = "//div[@class='basket-wrapper']//button[@id='buy-button']";
	final String CALCULA_FRETE = "//span[contains(text(),'Calcule frete e prazo')]";

	public CarrinhoPage(WebDriver driver) {
		super(driver);
	}

	public void acessaCarrinho() throws IOException {

		driver.findElement(By.xpath(BTN_CARRINHO)).click();
		driver.findElement(By.xpath(BTN_VER_MEU_CARRINHO)).click();
		screenShot ("acesso ao Carrinho");
		logger.info("Carrinho acessado com sucesso.");
	}

	public void alteraQuantidade() throws InterruptedException, IOException {

		driver.findElement(By.xpath(BTN_MAIS)).click();
		screenShot ("altera a quantidade de produto");
		logger.info("Quantidade alterada com sucesso.");
	}

	public void limpaCarrinho() throws InterruptedException, IOException {

		driver.findElement(By.xpath(BTN_REMOVER)).click();
		screenShot ("limpa o carrinho");
		logger.info("Produto removido com sucesso.");
	}

	public void confirmaCarrinho() throws InterruptedException, IOException {

		driver.findElement(By.xpath(BTN_CONTINUAR)).click();
		screenShot("Carrinho confirmado com sucesso.");
	}
	
	public boolean calcularFrete() throws InterruptedException, IOException {

		return driver.findElement(By.xpath(CALCULA_FRETE)).isDisplayed(); 
	}
}
