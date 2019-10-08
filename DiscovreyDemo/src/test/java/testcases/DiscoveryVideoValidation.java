package testcases;

import java.util.ArrayList;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.Locators;
import util.FileReader;

public class DiscoveryVideoValidation {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeTest
	public void DiverSetup() {
		System.setProperty("webdriver.chrome.driver", "src\\test\\java\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();// set driver as a chrome driver	 
	}

	@Test
	public void VideoValidation() throws InterruptedException {

		wait = new WebDriverWait(driver, 50);
		FileReader r = new FileReader();
		driver.get(r.reader("Discovery_url"));
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		driver.findElement(Locators.shows).click();
		WebElement SeeAllShows = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.seeAllShows));
		SeeAllShows.click();
		Thread.sleep(10000);
		js.executeScript("window.scrollBy(0,5000)");
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.apolloShows));
		List<WebElement> element1 = driver.findElements(Locators.apolloShows);
		List<String> Fav_Title = new ArrayList<String>();
		List<String> Unfav_Title = new ArrayList<String>();

		for (int i = 0; i < element1.size(); i++) {
			List<WebElement> element2 = driver.findElements(Locators.apolloShows);
			element2.get(i).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.iCon_Plus_OR_Minus));

			if (driver.findElement(Locators.iCon_Plus).isDisplayed()) {
				System.out.println("Add to my favorit(+) displaying");
				driver.findElement(Locators.iCon_Plus).click();
				Fav_Title.add(driver.findElement(Locators.favShow_Title).getAttribute("alt"));
				Thread.sleep(2000);
				if (driver.findElement(Locators.iCon_Minus).isDisplayed()) {
					System.out.println("Show has done as favorit. Title of shows=   " + Fav_Title.get(i));
				}

				driver.navigate().back();
				Thread.sleep(2000);
				js.executeScript("window.scrollBy(0,5000)");
			}

			else if (driver.findElement(Locators.iCon_Minus).isDisplayed()) {
				System.out.println("Remove from my favorit(-) Displaying");
				driver.findElement(Locators.iCon_Minus).click();
				Unfav_Title.add(driver.findElement(By.xpath(r.reader("FavShow_Title"))).getAttribute("alt"));
				Thread.sleep(2000);
				if (driver.findElement(Locators.iCon_Plus).isDisplayed()) {
					System.out.println("Show has done as Un-favorit. Title of shows=   " + Unfav_Title.get(i));
				}
				driver.navigate().back();
				Thread.sleep(2000);
				js.executeScript("window.scrollBy(0,5000)");

			}

		}
		driver.findElement(Locators.menuBar).click();
		driver.findElement(Locators.myVideos).click();
		Thread.sleep(5000);
		js.executeScript("window.scrollBy(0,350)");
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.favShowsHeader));
		List<WebElement> MyVideo_Fav_Title = driver.findElements(Locators.favShowsAvailable);

		for (int i = 0; i < Fav_Title.size(); i++) {
			int count = 0;
			for (int j = 0; j < MyVideo_Fav_Title.size(); j++)

			{

				if (Fav_Title.get(i).equals(MyVideo_Fav_Title.get(j).getAttribute("textContent"))) {
					System.out.println(
							"Show added successfully to my favorite and available in my favorite shows. Title of shows=   "
									+ Fav_Title.get(i));
					count = count + 1;
					break;
				}

			}
			if (count == 0) {
				System.out.println(Fav_Title.get(i) + "   show not available in my favorite shows");
			}

		}

		for (int i = 0; i < Unfav_Title.size(); i++) {
			int count = 0;
			for (int j = 0; j < MyVideo_Fav_Title.size(); j++) {

				if (Unfav_Title.get(i).equals(MyVideo_Fav_Title.get(j).getAttribute("textContent"))) {
					System.out.println(Unfav_Title.get(i) + "video not able to make as un-favorite shows ");
					count = count + 1;

				}

			}
			if (count == 0) {
				System.out.println(Unfav_Title.get(i) + "video successfully done as un-favorite shows");
			}

		}
	}
	@AfterTest
	public void releasetest()
	{
		driver.quit();
	}

}
