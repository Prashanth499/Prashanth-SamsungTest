package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testbase.WebTestBase;
import utils.GenericUtility;

public class AccessoriesPage extends WebTestBase {


    @FindBy(xpath = "//a[@class='nv00-gnb__utility-btn mobile-only loginBtn']")
    WebElement loginIconHover;


    @FindBy(xpath = "//a[@class='nv00-gnb__utility-user-menu-link loginBtn']")
    WebElement accountClick;

    @FindBy(xpath = "//button[@an-la='home appliances']")
    WebElement appliancesHover;

    @FindBy(xpath = "//a[@href='/in/refrigerators/double-door/']")
    WebElement doubleDoor;

    @FindBy(xpath = "//span[@class='pd03-product-finder__filters-list-list-headline-text']")
    WebElement priceFilter;


    @FindBy(xpath = "//button[@class='cookie-bar__close cookie-bar__main-close']")
    WebElement downAdvertise;


    @FindBy(xpath = "//a[@href='//www.instagram.com/samsungindia/']")
    WebElement instagramClick;

    @FindBy(xpath = "//button[@class='nv00-gnb__utility-btn gnb__search-btn-js']")
    WebElement searchIcon;


    @FindBy(xpath = "//a[@href='//www.samsung.com/in/smartphones/galaxy-s23-ultra/']")
    WebElement searchQuick;


    public AccessoriesPage() {
        PageFactory.initElements(driver, this);
    }


    public void mouseHoverElement() {
        GenericUtility.mouseHoverOnElement(loginIconHover);
        accountClick.click();
    }

    public void clickRadioBtn() {
        GenericUtility.mouseHoverOnElement(appliancesHover);
        doubleDoor.click();
        GenericUtility.scrollDownByElement(priceFilter);
        GenericUtility.waitUntilElementToBeClick(priceFilter);
    }

    public void closeAdvertise() {
        downAdvertise.click();
    }

    public void handleWindow() {
        GenericUtility.getWindowHandles();
    }

    public void instagramClick() {
        GenericUtility.scrollDownByPixel();
        instagramClick.click();
    }

    public void searchBoxText() {
        searchIcon.click();
        searchQuick.click();


    }


}
