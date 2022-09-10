package com.PracticesProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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

public class PracticeProject2 {
	WebDriver driver;
	WebElement myelement;
	PracticeProject BrowserRun;



	@Test(priority=1,enabled=false)
	public void Practice1forImageReading() throws InterruptedException, TesseractException, IOException {
		BrowserRun=new PracticeProject();
		BrowserRun.Practice();

		Thread.sleep(5000);
		File SourceFile=new File("C:/Users/rumana/Desktop/Image/LoginProcessTest_1625501699352.png");
		ITesseract tesser=new Tesseract();
		tesser.setDatapath("C:/BFS/Eclipse_Workspace/PracticesProject/TessData");
		String Result=tesser.doOCR(SourceFile);
		System.out.println("This is Image  Text== "+Result);
		if(Result.contains("your first order")) {
			System.out.println("===Image reader is successfully working===");
		}else {
			System.out.println("Image Reader are not working Yet====");
		}
	}


	@Test(priority=2,enabled=true)
	public void Practice2forBrokenLink() throws Exception  {

		BrowserRun=new PracticeProject();
		BrowserRun.Practice();
		Thread.sleep(3000);
		List<WebElement>ListLnk=driver.findElements(By.tagName("a"));

		System.out.println("this page has Total Link==="+ListLnk.size());
		Thread.sleep(3000);
		for(int i=0; i<ListLnk.size();i++) {
			WebElement Myelement=ListLnk.get(i);
			String URLPath=Myelement.getAttribute("href");
			Thread.sleep(3000);
			System.out.println("Link validation ======================================");
			//System.out.println(URLPath);
			Thread.sleep(3000);
			
			
			URL LinkUrl=new URL(URLPath);
			HttpURLConnection Httpconact=(HttpURLConnection)LinkUrl.openConnection();
			Thread.sleep(3000);
			Httpconact.connect();
			int Respond=Httpconact.getResponseCode();
			if(Respond>=400) {
				System.out.println(URLPath+"---   is Broken Link");
			}else {
				System.out.println(URLPath+"---    is Valid Link");
			}
		}


	}}




