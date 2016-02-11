package fr.isen.m2.jee.tarotspreadsheet.web;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;

public class TarotSpreadsheetWebIT {

    private WebDriver driver;

    private TarotSpreadsheetPage page;

    @Before
    public void doBefore() throws Exception {
        driver = new FirefoxDriver();
        // Navigate to the right place
        driver.get("http://localhost:9090/tarotspreadsheet/index.jsp");
        page = PageFactory.initElements(driver, TarotSpreadsheetPage.class);
    }

    @After
    public void doAfter() {
        driver.quit();
    }

    @Test
    public void itCanCreateSpreadsheet() throws Exception {
        page.createSpreadsheet("testSpreadsheet");
        driver.get("http://localhost:9090/tarotspreadsheet/index.jsp");
        assertEquals(1, page.getSpreadsheetNumber());
    }

    @Test
    public void itCanEditSpreadsheet() throws Exception {
        page.goToSpreadsheetCreated();

    }

}
