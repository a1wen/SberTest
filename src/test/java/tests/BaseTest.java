package tests;

import net.thucydides.core.annotations.Managed;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

/**
 * Created by a1wen on 28.08.2017.
 */
public class BaseTest {
    @Managed(driver = "chrome")
    public WebDriver driver;

    public Map<String,String> readProperties(String fileName){
        FileInputStream fis;
        Properties property = new Properties();
        try {
            fis = new FileInputStream("src/main/resources/"+fileName+".properties");
            property.load(fis);
        } catch (IOException e) {
            System.err.println("ОШИБКА: Отсутствует файл \"setup.properties\"!");
        }
        Map<String, String> map = (Map)property;
        return map;
    }

    @Before
    public void setUp(){
        Map setupMap = readProperties("setup");
        System.setProperty("webdriver.chrome.driver", setupMap.get("webdriver.chrome.driver").toString());
        driver.manage().window().maximize();
        driver.get(setupMap.get("main.url").toString());
    }

    @After
    public void finished(){
        driver.quit();
    }
}
