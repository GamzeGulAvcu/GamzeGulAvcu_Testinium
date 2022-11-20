package com.network.methods;

import com.network.driver.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Methods {

    WebDriver driver;
    FluentWait<WebDriver> wait;
    JavascriptExecutor jsdriver;
    Logger logger = LogManager.getLogger(Methods.class);

    public Methods() {
        driver = TestBase.driver;
        wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofMillis(300)).ignoring(NoSuchElementException.class);
        jsdriver = (JavascriptExecutor) driver;
    }
    public void goUrl(String url){

        driver.get(url);
        logger.info(url + " li adrese gidildi.");

    }

    public void checkUrlCont(String url) {

        String actualURL = driver.getCurrentUrl();

        if (actualURL.contains(url)) {
            logger.info("Sayfadaki URL " + url + " değerini içeriyor.");
        } else {
            Assert.fail("Su anki URL Beklenen URL Degerini Icermiyor");
        }

    }

    public WebElement findElement(By by) {

        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void click(By by, String elementAdı) {
        findElement(by).click();
        logger.info(elementAdı + " Elementine Tiklandi");
    }

    public void waitBySecond(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info(seconds + " saniye beklendi");
    }

    public void sendKeys(By by, String text, String elementAdi) {

        findElement(by).sendKeys(text);
        logger.info(elementAdi + " Elementine " + text + " Yazildi.");
    }

    public void sendEnter(By by, String elementAdi) {

        findElement(by).sendKeys(Keys.ENTER);
        logger.info(elementAdi + " Elementinde Enter Tusuna Basildi Yazildi.");
    }

    public boolean elementControl(By by, String elementAdi) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            logger.info(elementAdi + "Elementi Sayfada Gorunur");
            return true;
        } catch (Exception e) {
            logger.info(elementAdi + "Elementi Gorunur Degil" + e.getMessage());
            return false;
        }
    }

    public void scrollTo(By by, String elementAdi) {
        Actions actions = new Actions(driver);
        actions.moveToElement(findElement(by)).build().perform();
        logger.info(elementAdi + " ELementine Kaydirildi");
    }


    public void scrollWithJavaScript(By by) {
        jsdriver.executeScript("arguments[0].scrollIntoView()", findElement(by));
    }

    public String getAttribute(By by, String attributeName) {
        return findElement(by).getAttribute(attributeName);
    }


    public void getText(By by, String elementAdi) {
        String elementinTexti = findElement(by).getText();
        logger.info(elementAdi + " Elementindeki text: " + elementinTexti);
    }

    public void hoverElement(By by, String elementAdi) {
        Actions action = new Actions(driver);
        action.moveToElement(findElement(by)).build().perform();
        logger.info(elementAdi + "Elementinin Uzerinde Duruldu");
    }

    public void randomSelect(String elementAdi) {

        List<WebElement> productSelect = driver.findElements(By.xpath("//*[@class='product__size radio-box']"));
        int maxProducts = productSelect.size();

        Random random = new Random();
        int randomProduct = random.nextInt(maxProducts);

        productSelect.get(randomProduct).click();

        logger.info("Random " + elementAdi + " Yapildi ");
    }


}
