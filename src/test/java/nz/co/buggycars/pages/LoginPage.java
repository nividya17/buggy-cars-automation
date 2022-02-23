package nz.co.buggycars.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
public class LoginPage {

    private static By userName = By.name("login");
    private static By password = By.name("password");
    private static By loginBtn = By.xpath("//button[contains(text(),'Login')]");
    private static By profile = By.linkText("Profile");
    private static By logout = By.linkText("Logout");
    private static By warning = By.xpath("//*/div[@class='form-group has-danger']/span");

    public static LoginPage expect() {
        return new LoginPage();
    }


    public void login(String login, String passwd) {
        $(userName).setValue(login);
        $(password).setValue(passwd);
        $(loginBtn).click();
    }

    public void loginError() {
        $(warning).shouldBe(visible).getText().equals("Invalid username/password");
    }

    public void  loginSuccess() {
        $(profile).shouldBe(visible);
    }

    public void logout() {
        $(logout).shouldBe(visible).click();
    }
}
