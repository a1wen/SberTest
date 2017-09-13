package ru.sbt.autotest.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by a1wen on 28.08.2017.
 */
public class MainPage extends PageObject{

    @FindBy(xpath = "//div[@class='region-list']//a")
    public WebElement regionSelector;

    @FindBy(xpath = "//div[@class='kit-modal-body']//input[@class='kit-input__control']")
    public WebElement regionInput;

    @FindBy(xpath = "//div[@class='kit-autocomplete-input__option']")
    public List<WebElement> regionSearchResults;

    @FindBy(xpath = "//div[@class = 'footer-info']")
    public WebElement footer;

    @FindBy(xpath = "//div[@class = 'social__wrapper']")
    public WebElement socialWrapper;

    @FindBy(xpath = "//li[@class = 'social__item']/a")
    public List<WebElement> socialButtons;

}
