package nz.co.buggycars.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CarMakePage {

    private static By header = By.xpath("//*/div[@class = 'card']/h3[@class='card-header']");
    private static By contents = By.xpath("//*/table[@class='cars table table-hover']");

    public static CarMakePage expect() {
        CarMakePage carMakePage = new CarMakePage();
        carMakePage.loadCarMakePage();
        return carMakePage;
    }

    private void loadCarMakePage() {
        $(header).shouldBe(visible);
        $(contents).scrollIntoView(true).shouldBe(visible);
    }
}
