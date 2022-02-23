package nz.co.buggycars.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class OverallRatingPage {

    private static By ratings = By.xpath("//*/table[@class='cars table table-hover']");
    private static By make = By.xpath("//*/table[@class='cars table table-hover']/tbody/tr[1]/td[2]/a");
    private static By model = By.xpath("//*/table[@class='cars table table-hover']/tbody/tr[1]/td[3]/a");

    public static OverallRatingPage expect() {
        OverallRatingPage overallRatingPage =  new OverallRatingPage();
        overallRatingPage.loadOverallRatingPage();
        return overallRatingPage;
    }

    private void loadOverallRatingPage() {
        $(ratings).scrollIntoView(true).shouldBe(visible);
    }

    public void clickOnMake() {
        $(make).shouldBe(visible).click();
    }

    public void clickOnModel() {
        $(model).shouldBe(visible).click();
    }
}
