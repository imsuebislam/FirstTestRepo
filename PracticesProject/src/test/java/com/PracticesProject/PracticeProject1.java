package com.PracticesProject;

import java.io.FileInputStream;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PracticeProject1 {
	WebDriver driver;
	WebElement myelement;


	@Test
	public void Practice1fordynamicelement() throws InterruptedException {


		//	 prop = new Properties();
		//		FileInputStream ip = new FileInputStream(
		//				"C:\\BFS\\Eclipse_Workspace\\eschoolautomation\\src\\main\\java\\eschoolautomation\\config.property");
		//		prop.load(ip);
		WebDriverManager.chromedriver().setup();


		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.worldometers.info/world-population/");
		//		String Locator1="//*[@id="maincounter-wrap"]/div/span";
		//		driver.findElement(By.xpath(Locator1));
		Thread.sleep(5000);
		List<WebElement>PopuList=driver.findElements(By.xpath("//*[@id=\"maincounter-wrap\"]/div/span"));
		Thread.sleep(5000);
		for(WebElement e:PopuList) {
			System.out.println("This is World Current population total Number= " +e.getText() );}
		Date currenttime= new Date();
		System.out.println(currenttime);


		List<WebElement>Poputoday=driver.findElements(By.xpath("/html/body/div[3]/div[2]/div[2]/div/div[3]/div[1]/div/div[2]/div[2]"));
		Thread.sleep(5000);
		for(WebElement e:Poputoday) {
			System.out.println("This is world ToDay population total Number= " +e.getText() );}

		System.out.println(currenttime);

		List<WebElement>PoputhisYear=driver.findElements(By.xpath("/html/body/div[3]/div[2]/div[2]/div/div[3]/div[2]/div/div[2]/div[2]/span"));
		Thread.sleep(5000);
		for(WebElement e:PoputhisYear) {
			System.out.println("This is World This Year population total Number= " +e.getText() );}

		System.out.println(currenttime);

		
	}
}
