package com.PracticesProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
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
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class PracticeProject3 {
	WebDriver driver;
	WebElement myelement;
	PracticeProject3 BrowserRun;
	@Test(priority=0,enabled=true)
	public  void Practice3forBrokenLink() throws InterruptedException, IOException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		//https://www.google.com/
		driver.get("https://www.google.com/");
		//driver.get("https://www.worldometers.info/world-population/");
		List<WebElement>ListLnk=driver.findElements(By.tagName("a"));
		//ArrayList<String> urllist=new ArrayList<String>();

		System.out.println("this page has Total Link==="+ListLnk.size());
		Thread.sleep(5000);
		for(int i=0; i<ListLnk.size();i++) {
			WebElement Myelement=ListLnk.get(i);
			String URLPath=Myelement.getAttribute("href");
			//urllist.add(URLPath);
			System.out.println(URLPath);
			URL URLink=new URL(URLPath);
			
			HttpURLConnection Httpconact=(HttpURLConnection)URLink.openConnection();
			Thread.sleep(5000);
			Httpconact.connect();
			int Respond=Httpconact.getResponseCode();
			if(Respond>=400) {
				System.out.println(URLPath+"---   is Broken Link");
			}else {
				System.out.println(URLPath+"---    is Valid Link");
			}
		}
	}
	}

