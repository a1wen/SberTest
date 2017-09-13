package ru.sbt.autotest.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.sbt.autotest.pages.MainPage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by a1wen on 28.08.2017.
 */
public class BaseSteps extends ScenarioSteps{
    MainPage mainpage;

    private WebElement waiter( WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 40, 500);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    @Step("Нажатие селектора региона")
    public void regionListClick(){
        waiter(mainpage.regionSelector).click();
    }

    @Step("Поиск нижегородской области")
    public void inputAndSelectRegion(String region){
        WebElement input = waiter(mainpage.regionInput);
        input.sendKeys(region);
    }

    @Step("Нажатие по всплывающей подсказке")
    public void regionSearchResultClick(){
        waiter(mainpage.regionSearchResults.get(0));
        for(WebElement region : mainpage.regionSearchResults){
            if(region.getText().equals("Нижегородская область"))
                region.click();
            break;
        }
    }

    @Step("Прокрутка к футеру страницы")
    public void scrollToFooter(){
        waiter(mainpage.footer).isEnabled();
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView();",mainpage.footer);
    }

    public String getRegionValue(){
        WebElement region = waiter(mainpage.regionSelector);
        return region.getAttribute("title");
    }

    @Step("Проверка соответствия выбранного региона")
    public void assertRegion(String expectedRegion){
        assertEquals(getRegionValue(),expectedRegion);
    }

    public boolean checkAllSocialButtons(Map<String,String> expectedButtons){
        boolean flag = true;
        List links = new ArrayList<String>();
        for(WebElement socBtn : mainpage.socialButtons){
            links.add(socBtn.getAttribute("href"));
        }
        for(String entry : expectedButtons.keySet()){
            if(!links.contains(expectedButtons.get(entry))) {
                flag = false;
                break;
            } else flag = true;
        }
        return flag;
    }

    @Step("Проверка наличия блока кнопок социальных сетей")
    public void assertSocialButton(Map<String,String> expectedButtons){
        assertTrue(checkAllSocialButtons(expectedButtons));
    }


}
