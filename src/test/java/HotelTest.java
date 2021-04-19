import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HotelTest extends SelectBrowser {
	private String expectedHeader = "Application Tutoriel pour la base de données des hotels";
	private String expectedSelection = "New-York";
	@Before
	public void setUp() throws Exception {
		selectBrowser(this.browser);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		driver.get("http://192.168.1.91:8090/HotelWebapp");
		String header = driver.findElement(By.xpath("//h2")).getText();
		assertEquals("Le header ne correspond pas", expectedHeader, header);
		WebElement select = driver.findElement(By.xpath("//select"));
		Select selectVilles = new Select(select);
		selectVilles.selectByValue(expectedSelection);
		assertEquals("La ville sélectionnée ne correspond pas", expectedSelection, selectVilles.getFirstSelectedOption().getText());
		
		driver.findElement(By.xpath("//button")).click();
	}

}
