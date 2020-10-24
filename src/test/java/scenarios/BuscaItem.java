package scenarios;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.HomePage;

public class BuscaItem {

	WebDriver driver = new ChromeDriver();
	HomePage homepage = new HomePage(driver);

	public static final Logger logger = Logger.getLogger(BuscaItem.class);

	@Test
	public void buscaItem() throws InterruptedException, IOException {

		try {
			homepage.acessaUrl("https://www.submarino.com.br/");
			homepage.aceitaCookies();
			homepage.efetuaBusca("ração magnus premium filhotes");
		} catch (Exception e) {
			logger.info(e.getStackTrace() + " " + e.getMessage());
		}
	}

	@After
	public void after() {
		driver.quit();
	}
}
