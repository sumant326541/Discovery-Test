package config;

import org.openqa.selenium.By;

public class Locators {
    
	public static By shows = By.xpath("//span[contains(text(), 'Shows')]");
	
    public static By seeAllShows = By.xpath("//*[@id='show-drop-desktop']//a[@class= 'dscShowsDropContent__seeAllShows']");
    public static By apolloShows = By.xpath("//div[@class= 'showGridTile__container']/*[contains(@href, 'apollo')]");
    public static By iCon_Plus_OR_Minus = By.xpath("//*[@class= 'flipIconCore__icon icon-plus ' or @class= 'flipIconCore__icon icon-minus ']");
    public static By iCon_Plus = By.xpath("//i[@class= 'flipIconCore__icon icon-plus ']");
    public static By favShow_Title = By.xpath("//img[@class='showHero__showLogo']");
    public static By iCon_Minus = By.xpath("//*[@class= 'flipIconCore__icon icon-minus ']");
    
    public static By menuBar = By.xpath("//*[@class= 'dscHeaderMain__iconMenu']");
    public static By myVideos = By.xpath("//span[contains(text(), 'My Videos')]");
    public static By favShowsAvailable = By.xpath("//h2[contains(text(), 'Favorite Shows')]/parent::div//h3/div");
    public static By favShowsHeader = By.xpath("//h2[text()='Favorite Shows']");
   
    

}


