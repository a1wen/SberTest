package tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import ru.sbt.autotest.steps.BaseSteps;


/**
 * Created by a1wen on 28.08.2017.
 */

@RunWith(SerenityRunner.class)
public class checkRegionAndSocialNetworkButtons extends BaseTest {

    @Steps
    BaseSteps steps;

    @Title("Проверка региона и наличия кнопок соц.сетей")
    @Test
    public void testCheckRegionAndSocialButtons() throws Exception{
        steps.regionListClick();
        steps.inputAndSelectRegion("ниж");
        steps.regionSearchResultClick();
        steps.assertRegion("Нижегородская область");
        steps.scrollToFooter();
        steps.assertSocialButton(readProperties("expected"));
    }
}
