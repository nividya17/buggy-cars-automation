package nz.co.buggycars.tests

import com.codeborne.selenide.Selenide
import nz.co.buggycars.common.WebSpecification
import nz.co.buggycars.pages.HomePage
import nz.co.buggycars.pages.LoginPage

class LoginPageTest extends WebSpecification {

    def "Should be able to login with valid credentials"() {
        given: "I open the home page"
            Selenide.open(appConfig.getWebAppUrl())
            HomePage.expect()
        when: "I login with valid credentials"
            LoginPage loginPage = LoginPage.expect()
            loginPage.login(appConfig.testUserLoginId, appConfig.testUserPassword)
        then: "login should be successful"
            loginPage.loginSuccess()
        and: "I logout"
            loginPage.logout()
    }

    def "Should not login with invalid credentials"() {
        given: "I am in the home page"
            HomePage.expect()
        when: "I login with incorrect password"
            LoginPage loginPage = new LoginPage()
            loginPage.login("test", "password")
        then: "I see a error message"
            loginPage.loginError()
    }
}
