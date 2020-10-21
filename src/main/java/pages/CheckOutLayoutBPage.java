package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CheckOutLayoutBPage extends BasePage{

	final String RADIO_BTN_FRETE = "//li[@id='CONVENTIONAL-menu-item']//label";
	final String BTN_FORMA_PAGAMENTO = "//li[@id='payment-option-menu-CREDIT_CARD']//span[contains(text(),'selecione')]";
	final String CARTAO_CREDITO = "//single-card-payment//input[@placeholder='Número do cartão']";
	final String NOME_CARTAO_CREDITO = "//single-card-payment//label[2]//input[1]";
	final String MES_VALIDADE = "//body//single-card-payment//select[1]";
	final String ANO_VALIDADE = "//body//single-card-payment//select[2]";
	final String CVV = "//article[@id='payment-option-CREDIT_CARD']//div//div//new-credit-card-payment//section//single-card-payment//ul//new-card-radio-input//li//form//label//div//input[contains(@placeholder,'CVV')]";
	final String CHECKBOX_COMPRAS_FUTURAS = "//single-card-payment//label[5]//div[1]";

	public CheckOutLayoutBPage(WebDriver driver) {
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
		screenShot("preenche Cartão de Crédito");
		logger.info("Número do Cartao preenchido com sucesso.");
	}

	public void preencheNomeCartaoCredito(String nomeCartaoCredito) throws InterruptedException, IOException {

		driver.findElement(By.xpath(NOME_CARTAO_CREDITO)).click();
		driver.findElement(By.xpath(NOME_CARTAO_CREDITO)).sendKeys(nomeCartaoCredito);
		screenShot("prenche o Nome");
		logger.info("Nome do Titular do Cartao preenchido com sucesso.");
	}

	public void preencheMesValidade(String mesValidade) throws IOException {
		Select optionMesValidade = new Select(driver.findElement(By.xpath(MES_VALIDADE)));
		optionMesValidade.selectByVisibleText(mesValidade);
		screenShot("preenche o Mês de Validade");
		logger.info("Mes de Validade do Cartao preenchido com sucesso.");
	}

	public void preencheAnoValidade(String anoValidade) throws IOException {
		Select optionAnoValidade = new Select(driver.findElement(By.xpath(ANO_VALIDADE)));
		optionAnoValidade.selectByVisibleText(anoValidade);
		screenShot("preenche o Ano de Validade");
		logger.info("Ano de Validade do Cartao preenchido com sucesso.");
	}

	public void preencheCVV(String cvv) throws IOException {
		driver.findElement(By.xpath(CVV)).sendKeys(cvv);
		screenShot("preenche o CVV");
		logger.info("CVV do Cartao preenchido com sucesso.");

	}

	public void salvarDadosComprasFuturas() throws InterruptedException, IOException {
		driver.findElement(By.xpath(CHECKBOX_COMPRAS_FUTURAS)).click();
		screenShot("seleciona Dados para Compras Futuras");
		logger.info("Checkbox de gravacao de Dados para Compras Futuras selecionado com sucesso.");
	}
}
