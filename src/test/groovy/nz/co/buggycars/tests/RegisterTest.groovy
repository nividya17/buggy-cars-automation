package nz.co.buggycars.tests

import com.codeborne.selenide.Selenide
import nz.co.buggycars.common.WebSpecification
import nz.co.buggycars.pages.HomePage
import nz.co.buggycars.pages.RegisterPage
import spock.lang.Shared

import java.time.Instant

class RegisterTest extends WebSpecification {
    @Shared
    String userName = "testUser" + Instant.now().getEpochSecond()
    @Shared
    String firstName = "${userName}FN"
    @Shared
    String lastName = "${userName}LN"
    String password = appConfig.testUserPassword

    def setupSpec() {
        Selenide.open(appConfig.getWebAppUrl())
    }

    def "Registering a new user should be successful"() {
        given: "I am in the homepage"
            HomePage homePage = HomePage.expect();
        when: "I click on register"
            homePage.clickRegister()
            RegisterPage registerPage = RegisterPage.expect()
        and: "I enter all the required details"
            registerPage.registerNewUser(userName, firstName, lastName, password, password)
        then: "I should see a successful registration message"
            registerPage.successfulRegister()
        and: "I return to home page"
            registerPage.navigateToHomePage()
    }

    def "Registering same user details should not be allowed"() {
        given: "I am in the homepage"
            HomePage homePage = HomePage.expect()
        when: "I click on register"
            homePage.clickRegister()
            RegisterPage registerPage = RegisterPage.expect()
        and: "I enter all the details required as earlier"
            registerPage.registerNewUser(userName, firstName, lastName, password, password)
        then: "I should see an error message"
            registerPage.failedRegister()
        and: "I return to home page"
            registerPage.navigateToHomePage()
    }

    def "Cancelling a registration should take me to home page"() {
        given: "I am in the home page"
            HomePage homePage = HomePage.expect()
        when: "I click on register"
            homePage.clickRegister()
        and: "I see the register page and cancel the registration"
            RegisterPage registerPage = RegisterPage.expect()
            registerPage.cancelRegistration()
        then: "I should return to the home page"
            homePage.isVisible()
    }
}
