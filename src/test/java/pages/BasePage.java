package pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class BasePage {
	
	public static final Logger logger = Logger.getLogger(BasePage.class); //implementação do log4j
	
	public WebDriver driver;
	
	public BasePage (WebDriver driver) {
		this.driver = driver;
	}
	
	public void screenShot(String nomeMetodo) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver; // Criando um objeto do tipo TakesScreenshot
		File arquivo = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File("output" + File.separator + nomeMetodo +"_screenshot.jpg")); // o File.separator
																								// verifica e utiliza a
																								// barra invertida ou
																								// normal (/) de acordo
																								// com seu sistema
																								// operacional. Um
																								// diretório é criado,
																								// caso ele não exista
	}
}
