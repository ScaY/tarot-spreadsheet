package fr.isen.m2.jee.tarotspreadsheet.web;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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
    public void itCanBrowseThePage() throws Exception {
        assertThat(page.hasHomePage()).isTrue();
    }

    @Test
    public void itCanCreateSpreadsheet() {
        int previousSize = page.getSpreadsheetNumber();
        page.createSpreadsheet("testSpreadsheet");
        driver.get("http://localhost:9090/tarotspreadsheet/index.jsp");
        assertEquals(1, page.getSpreadsheetNumber() - previousSize);
    }

    @Test
    public void itCanEditSpreadsheet() throws Exception {
        page.createSpreadsheet("testSpreadsheet2");
        driver.get("http://localhost:9090/tarotspreadsheet/index.jsp");
        page.goToSpreadsheetCreated("testSpreadsheet2");
        page.addScore(1, 3, 1, 42);
        List<Integer> scores = page.getScore();
        assertEquals(3, scores.size());
        assertEquals(-12, scores.get(0).intValue());
        assertEquals(24, scores.get(1).intValue());
        assertEquals(-12, scores.get(2).intValue());
    }

    @Test
    public void itCanAddMultipleScore() throws Exception {
        page.createSpreadsheet("testSpreadsheet3");
        driver.get("http://localhost:9090/tarotspreadsheet/index.jsp");
        page.goToSpreadsheetCreated("testSpreadsheet3");
        page.addScore(1, 3, 1, 42);
        page.addScore(1, 3, 1, 42);
        page.addScore(1, 3, 1, 42);
        List<Integer> total = page.getTotalScore();
        assertEquals(3, total.size());
        assertEquals(-36, total.get(0).intValue());
        assertEquals(72, total.get(1).intValue());
        assertEquals(-36, total.get(2).intValue());

    }

}
