package testfacelogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class FacebookSteps {
	
	private static WebDriver driver;
	
	@Dado("^Abra Firefox e Start Aplicacao$")
	public void abra_Firefox_e_Start_Aplicacao(){
		System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.facebook.com"); 	   
	}

	@Quando("^Eu entro com usuario e password validas$")
	public void eu_entro_com_usuario_e_password_validas() throws Throwable{
		driver.findElement(By.id("email")).sendKeys("luizcssoares@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.id("pass")).sendKeys("Lucas@2001");
		Thread.sleep(2000);
	}

	@Entao("^Usuario deve fazer Login com sucesso$")
	public void usuario_deve_fazer_Login_com_sucesso() throws Throwable {
		driver.findElement(By.id("loginbutton")).click();
		Thread.sleep(2000);
		driver.close();
	}
}
