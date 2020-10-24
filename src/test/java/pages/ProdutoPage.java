package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProdutoPage extends BasePage{

	final String BTN_COMPRAR = "//a[@id='btn-buy']//span[contains(text(),'Comprar')]";

	public ProdutoPage(WebDriver driver) {
		super(driver);
	}

	public void incluiProduto() throws InterruptedException, IOException {

		driver.findElement(By.xpath(BTN_COMPRAR)).click();
		screenShot("inclui o Produto");
		logger.info("Produto adicionado com sucesso.");
	}

}
