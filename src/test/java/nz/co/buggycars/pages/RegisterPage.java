package nz.co.buggycars.pages;


import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.visible;


public class RegisterPage {

    private static By header = By.xpath("//*/div[@class='col-md-6']/h2[contains(text(),'Register with Buggy Cars Rating')]");
    private static By username = By.id("username");
    private static By firstName = By.id("firstName");
    private static By lastName = By.id("lastName");
    private static By password = By.id("password");
    private static By confirmPassword = By.id("confirmPassword");
    private static By registerButton = By.xpath("//button[contains(text(),'Register')]");
    private static By cancelBtn = By.linkText("Cancel");
    private static By successMsg = By.xpath("//*/div[@class='result alert alert-success']");
    private static By failureMsg = By.xpath("//*/div[@class='result alert alert-danger']");
    private static By homePage = By.linkText("Buggy Rating");

    public static RegisterPage expect() {
        RegisterPage registerPage = new RegisterPage();
        registerPage.isRegisterPageLoaded();
        return registerPage;
    }

    public void registerNewUser(String userName, String firstName, String lastName, String passwd, String confirmPwd) {
        $(username).setValue(userName);
        $(RegisterPage.firstName).setValue(firstName);
        $(RegisterPage.lastName).setValue(lastName);
        $(password).setValue(passwd);
        $(confirmPassword).setValue(confirmPwd);
        $(registerButton).click();
    }

    private void isRegisterPageLoaded() {
        $(header).shouldBe(visible);
    }

    public void cancelRegistration() {
        $(cancelBtn).scrollIntoView(true).shouldBe(visible).click();
    }

    public void successfulRegister() {
        $(successMsg).shouldBe(visible).getText().equals("Registration is successful");
    }

    public void failedRegister() {
        $(failureMsg).shouldBe(visible).getText().contains("UsernameExistsException: User already exist");
    }

    public void navigateToHomePage() {
        $(homePage).shouldBe(visible).click();
    }
}
