package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class CheckOutLayoutAPage extends BasePage{

	final String RADIO_BTN_FRETE = "//input[@id='freightMenu-options-item-CONVENTIONAL-input']";
	final String BTN_FORMA_PAGAMENTO = "//label[@id='paymentMenu-optionLabel__CREDIT_CARD']";
	final String CARTAO_CREDITO = "//body/div[@id='root']/div[1]/main[1]/section[3]/div[1]/div[1]/form[1]/div[1]/div[2]/label[1]/div[1]/input[1]";
	final String NOME_CARTAO_CREDITO = "//body/div[@id='root']/div[1]/main[1]/section[3]/div[1]/div[1]/form[1]/div[1]/div[3]/label[1]/div[1]/input[1]";
	final String VALIDADE_CARTAO = "//body/div[@id='root']/div[1]/main[1]/section[3]/div[1]/div[1]/form[1]/div[1]/div[4]/div[1]/label[1]/div[1]/input[1]";
	final String CVV = "//body/div[@id='root']/div[1]/main[1]/section[3]/div[1]/div[1]/form[1]/div[1]/div[4]/div[2]/label[1]/div[1]/input[1]";
	final String NUMERO_PARCELAS = "";
	final String CHECKBOX_SALVAR_CARTAO = "//label[contains(text(),'salvar o cartão')]";

	public CheckOutLayoutAPage(WebDriver driver) {
		super(driver);
	}

	public void selecionaFrete() throws InterruptedException, IOException {
		driver.findElement(By.xpath(RADIO_BTN_FRETE)).click();
		screenShot("seleciona o Frete");
		logger.info("Frete selecionado com sucesso.");
	}

	public void selecionaFormaPagamento() throws IOException {
		driver.findElement(By.xpath(BTN_FORMA_PAGAMENTO)).click();
		screenShot("seleciona a Forma de Pagamento");
		logger.info("Forma de Pagamento selecionada com sucesso.");
	}

	public void preencheCartaoCredito(String numeroCartao) throws InterruptedException, IOException {
		driver.findElement(By.xpath(CARTAO_CREDITO)).click();
		driver.findElement(By.xpath(CARTAO_CREDITO)).sendKeys(numeroCartao);
		driver.findElement(By.xpath(CARTAO_CREDITO)).sendKeys(Keys.TAB);
		screenShot("preenche Numero do Cartão de Credito");
		logger.info("Numero do Cartao de Credito preenchido com sucesso.");
	}

	public void preencheNomeCartaoCredito(String nomeCartaoCredito) throws InterruptedException, IOException {

		driver.findElement(By.xpath(NOME_CARTAO_CREDITO)).click();
		driver.findElement(By.xpath(NOME_CARTAO_CREDITO)).sendKeys(nomeCartaoCredito);
		screenShot("prenche o Nome");
		logger.info("Nome do Titular do Cartao preenchido com sucesso.");
	}

	public void preencheValidade(String validade) throws IOException {
		driver.findElement(By.xpath(VALIDADE_CARTAO)).click();
		driver.findElement(By.xpath(VALIDADE_CARTAO)).sendKeys(validade);
		screenShot("preenche a Data de Validade do Cartao");
		logger.info("Validade do Cartao preenchida com sucesso.");
	}
	
	public boolean validadeEstaVisivel() throws IOException {
		return driver.findElement(By.xpath(VALIDADE_CARTAO)).isDisplayed();
	}

	public void preencheCVV(String cvv) throws IOException {
		driver.findElement(By.xpath(CVV)).sendKeys(cvv);
		screenShot("preenche o CVV");
		logger.info("CVV do Cartao preenchido com sucesso.");

	}

	public boolean salvarCartao() throws InterruptedException, IOException {
		driver.findElement(By.xpath(CHECKBOX_SALVAR_CARTAO)).click();
		screenShot("seleciona checkbox 'salvar o cartao'");
		logger.info("Checkbox de gravacao de Dados de Cartao selecionado com sucesso.");
		logger.info("Execução concluída com sucesso! :)");
		return driver.findElement(By.xpath(CHECKBOX_SALVAR_CARTAO)).isSelected();
	}
	
	
}
