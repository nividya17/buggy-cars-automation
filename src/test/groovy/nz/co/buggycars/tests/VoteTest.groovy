package nz.co.buggycars.tests

import com.codeborne.selenide.Selenide
import nz.co.buggycars.common.WebSpecification
import nz.co.buggycars.pages.CarModelPage
import nz.co.buggycars.pages.HomePage
import nz.co.buggycars.pages.LoginPage
import nz.co.buggycars.pages.RegisterPage
import spock.lang.Shared

import java.time.Instant

import static org.junit.Assert.assertEquals

class VoteTest extends WebSpecification {

    @Shared
    String userName = "testUser" + Instant.now().getEpochSecond()
    String firstName = "${userName}FN"
    String lastName = "${userName}LN"
    String password = "Password@01"

    def "Should not allow voting without logging in"() {
        given: "I am in the home page"
            Selenide.open(appConfig.getWebAppUrl())
            HomePage homePage = HomePage.expect()
        when: "I click on the popular model"
            homePage.clickPopularModel()
            CarModelPage popularModelPage = CarModelPage.expect()
        and: "I try to vote for a model"
        then: "I should see a message saying that You need to be logged in to vote."
            popularModelPage.displayVotingMessage()
        and: "I return to the home page"
            homePage.goToHomePage()
            homePage.isVisible()
    }

    /*
    * This test scenario will create a new user every time as there is a restriction to not vote multiple times
    * Also there is no cleanup api available at the time of writing this test.
    * TODO: Implement clean up when enough information is available
    * */

    def "Should be able to vote for a selected car model"() {
        given: "I am in the home page"
            HomePage homePage = HomePage.expect()
        and: "I click on register"
            homePage.clickRegister()
            RegisterPage registerPage = RegisterPage.expect()
        and: "I register a new user"
            registerPage.registerNewUser(userName, firstName, lastName, password, password)
            registerPage.successfulRegister()
            homePage.goToHomePage()
        and: "I login with the newly created user"
            LoginPage loginPage = LoginPage.expect()
            loginPage.login(userName, password)
            loginPage.loginSuccess()
        when: "I go to popular model"
            homePage.clickPopularModel()
            CarModelPage carModelPage = CarModelPage.expect()
        then: "I see voting option enabled"
            carModelPage.voteButtonVisible()
        when: "I add a comment and click vote"
            Integer countBeforeVote = carModelPage.getNumberOfVotes()
            String comment = "Voted by ${userName}"
            carModelPage.enterComment(comment)
            carModelPage.clickVote()
            carModelPage.thanksMessageShouldBeDisplayed() == "Thank you for your vote!"
            Integer countAfterVote = carModelPage.getNumberOfVotes()
        then: "Vote should be incremented by 1 and my comment is displayed"
            assertEquals(countBeforeVote + 1, countAfterVote)
            carModelPage.getUserComment() == comment
        and: "I logout and return to home page"
            loginPage.logout()
            homePage.goToHomePage()
            homePage.isVisible()
    }
}
