package nz.co.buggycars.pages;


import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    private static By login = By.name("login");
    private static By password = By.name("password");
    private static By loginBtn = By.xpath("//button[contains(text(),'Login')]");
    private static By registerBtn = By.linkText("Register");
    private static By popularMakeLink = By.xpath("//*/div[@class='card']/h2[contains(text(), 'Popular Make')]/parent::*/a/img");
    private static By popularModelLink = By.xpath("//*/div[@class='card']/h2[contains(text(), 'Popular Model')]/parent::*/a/img");
    private static By overallRatingLink = By.xpath("//*/div[@class='card']/h2[contains(text(), 'Overall Rating')]/parent::*/a/img");
    private static By homepage = By.linkText("Buggy Rating");

    public static HomePage expect() {
        HomePage homePage = new HomePage();
        homePage.isVisible();
        return homePage;
    }

    public void isVisible() {
        $(login).shouldBe(visible);
        $(password).shouldBe(visible);
        $(loginBtn).shouldBe(visible);
        $(registerBtn).shouldBe(visible);
        $(popularMakeLink).shouldBe(visible);
        $(popularModelLink).shouldBe(visible);
        $(overallRatingLink).shouldBe(visible);
    }

    public void clickPopularMake() {
        $(popularMakeLink).click();
    }

    public void clickPopularModel() {
        $(popularModelLink).click();
    }

    public void clickOverAllRating() {
        $(overallRatingLink).click();
    }

    public void clickRegister() {
        $(registerBtn).click();
    }

    public void goToHomePage() {
        $(homepage).shouldBe(visible).click();
    }
}
