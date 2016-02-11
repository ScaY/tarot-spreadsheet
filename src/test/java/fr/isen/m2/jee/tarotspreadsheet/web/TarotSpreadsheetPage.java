package fr.isen.m2.jee.tarotspreadsheet.web;

import com.google.common.collect.Lists;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.sql.Driver;
import java.util.List;

public class TarotSpreadsheetPage {

    @FindBy(id = "inputName")
    WebElement inputName;

    @FindBy(tagName = "table")
    WebElement tableSpreadsheet;

    @FindBy(id = "submitSpreadsheet")
    WebElement submitSpreadsheet;

    public TarotSpreadsheetPage(WebDriver driver) {
        driver.get("http://localhost:9090/tarotspreadsheet/index.jsp");
    }

    public void createSpreadsheet(String name) {
        inputName.sendKeys(name);
        submitSpreadsheet.click();
    }

    public int getSpreadsheetNumber() {
        String xpath = "//tbody";
        List<WebElement> cells = Lists.reverse(tableSpreadsheet.findElements(By.xpath(xpath)));
        return cells.size();
    }

    public void goToSpreadsheetCreated() {
        String xpath = "//tbody/tr/td/a";
        List<WebElement> cells = Lists.reverse(tableSpreadsheet.findElements(By.xpath(xpath)));
        cells.get(1).click();
    }
}
