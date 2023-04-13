package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AccessoriesPage;
import testbase.WebTestBase;
import utils.GenericUtility;

public class AccessoriesTest extends WebTestBase {

    public AccessoriesPage accessoriesPage;

    AccessoriesTest() {
        super();
    }

    @BeforeMethod
    public void beforeMethod() {
        initialization();

        accessoriesPage = new AccessoriesPage();
    }

    @Test
    public void verifyMouseHoverLogin() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();                        // LOGIN PASSED WITH MOUSE HOVER
        accessoriesPage.mouseHoverElement();
        softAssert.assertEquals("", "", "MouseHover On Element Accounts");
        Thread.sleep(5000);
        softAssert.assertAll();
    }

    @Test
    public void verifyRadioButtonClick() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        accessoriesPage.clickRadioBtn();                                  //RADIO BUTTON ON DOUBLE DOOR TYPE
        softAssert.assertEquals("", "", "Filters must be Clickable");
        Thread.sleep(5000);
        softAssert.assertAll();
    }

    @Test
    public void verifyInstagramLink() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        accessoriesPage.closeAdvertise();                 //INSTAGRAM OPENED ON NEW TAB WITH CLOSING AN COOKIE BOX
        accessoriesPage.instagramClick();
        softAssert.assertEquals("", "", "Instagram Tab should Open");
        Thread.sleep(5000);
        GenericUtility.getWindowHandles();
        softAssert.assertAll();
    }

    @Test
    public void verifySearchBoxText() {
        SoftAssert softAssert = new SoftAssert();               //DROP DOWN CLICK FROM QUICK SEARCH
        accessoriesPage.searchBoxText();
        softAssert.assertEquals("", "", "Text should be entered");
        softAssert.assertAll();
    }


    @AfterMethod
    public void afterMethod() {
        driver.close();
    }
}




