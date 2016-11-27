package packt.selenium.chap3_9;

import java.io.File;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import packt.selenium.chap3_9.pageobjects.Google;
import packt.selenium.chap3_9.pageobjects.GoogleSearchPage;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxProfile;

/**
 * Created by Ripon on 11/19/2015.
 */
public class SearchGoogleTest {
    private WebDriver driver;
    public Google googlePage;
    public GoogleSearchPage searchPage;

    @Before
    public void setUp() throws Exception {
File pathToBinary = new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
        FirefoxProfile firefoxProfile = new FirefoxProfile();       
 driver = new FirefoxDriver(ffBinary,firefoxProfile);

//        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
    @Test
    public void testGoogleSearch(){
        googlePage = new Google(driver);
        searchPage = googlePage.goToSearchPage();
        searchPage.getNumberOfResults();
    }
}