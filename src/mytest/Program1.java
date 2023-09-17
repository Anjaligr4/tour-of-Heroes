package mytest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Program1 {
	WebDriver driver;
	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Anjali\\Downloads\\chromedriver-win32-new\\chromedriver-win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://localhost:5500/dashboard");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(250000));
	}
	
	@Test(priority=0)
	public void verifyTitle() {
		String actualTitle=driver.getTitle();
		String expectedTitle="Tour of Heroes";
		Assert.assertEquals(actualTitle,expectedTitle);		
	}
	
	@Test(priority=1)
	public void HeroSearch() {
		WebElement Hero= driver.findElement(By.id("search-box"));
		Hero.sendKeys("Magma");
	}
	
	
	@Test(priority=2)
	public void ListofHeroes() {
		WebElement Heroes =driver.findElement(By.xpath("//a[@href='/heroes']"));
		Heroes.click();
		WebElement Search= driver.findElement(By.id("new-hero"));
		Search.sendKeys("Herman");
		WebElement AddHero = driver.findElement(By.className("add-button"));
		AddHero.click();
		}
	
	@Test(priority=3)
	public void DeleteHero() {
		WebElement Heroes = driver.findElement(By.xpath("//a[contains(@href,'heroes')]"));
		Heroes.click();
		WebElement deleteHeroes = driver.findElement(By.className("delete"));
		deleteHeroes.click();
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}
