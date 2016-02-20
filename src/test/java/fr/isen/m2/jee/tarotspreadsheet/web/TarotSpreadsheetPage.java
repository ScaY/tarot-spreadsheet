package fr.isen.m2.jee.tarotspreadsheet.web;

import com.google.common.collect.Lists;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class TarotSpreadsheetPage {

    @FindBy(id = "inputName")
    WebElement inputName;

    @FindBy(tagName = "table")
    WebElement tableSpreadsheet;

    @FindBy(id = "submitSpreadsheet")
    WebElement submitSpreadsheet;

    @FindBy(id = "point")
    WebElement point;

    @FindBy(id = "selectNbPlayer")
    WebElement selectNbPlayer;

    @FindBy(id = "joueur_taken")
    WebElement joueurTaken;

    @FindBy(id = "nb_bout")
    WebElement nb_bout;

    @FindBy(id = "contrat")
    WebElement contrat;

    @FindBy(id = "add_score")
    WebElement add_score;

    @FindBy(id = "table_point")
    WebElement tablePoints;

    public TarotSpreadsheetPage(WebDriver driver) {
        driver.get("http://localhost:9090/tarotspreadsheet/index.jsp");
    }

    public void createSpreadsheet(String name) {
        inputName.sendKeys(name);
        submitSpreadsheet.click();
    }

    public boolean hasHomePage() {
        return inputName.isDisplayed() && tableSpreadsheet.isDisplayed() && selectNbPlayer.isDisplayed();
    }

    public int getSpreadsheetNumber() {
        String xpath = "//tbody/tr";
        List<WebElement> cells = Lists.reverse(tableSpreadsheet.findElements(By.xpath(xpath)));
        return cells.size();
    }

    public void goToSpreadsheetCreated(String name) {
        String xpath = "//tbody/tr/td/a";
        List<WebElement> cells = Lists.reverse(tableSpreadsheet.findElements(By.xpath(xpath)));
        boolean found = false;
        for (int i = 0; i < cells.size() && !found; i++) {
            if (cells.get(i).getAttribute("name").equals(name)) {
                cells.get(i).click();
                found = true;
            }
        }
    }

    public void addScore(int idPlayer, int nbAtout, int idContrat, int nbPoint) {
        Select selectPlayer = new Select(joueurTaken);
        selectPlayer.selectByIndex(idPlayer);
        Select selectAtout = new Select(nb_bout);
        selectAtout.selectByIndex(nbAtout);
        Select selectContrat = new Select(contrat);
        selectContrat.selectByIndex(idContrat);
        point.sendKeys(String.valueOf(nbPoint));
        add_score.click();
    }

    public List<Integer> getScore() {
        String xpath = "//tbody/tr/td";
        List<WebElement> trItems = Lists.reverse(tablePoints.findElements(By.xpath(xpath)));
        return retrieveItemFromWebElement(trItems);
    }

    public List<Integer> getTotalScore() {
        String xpath = "//tfoot/tr/td";
        List<WebElement> trItems = Lists.reverse(tablePoints.findElements(By.xpath(xpath)));
        return retrieveItemFromWebElement(trItems);
    }

    private List<Integer> retrieveItemFromWebElement(List<WebElement> trItems) {
        List<Integer> result = new ArrayList<>();
        for (WebElement trItem : trItems) {
            try {
                int value = Integer.valueOf(trItem.getText());
                result.add(value);
            } catch (NumberFormatException e) {
            }
        }

        return result;
    }
}
