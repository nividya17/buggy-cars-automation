package nz.co.buggycars.tests

import com.codeborne.selenide.Selenide
import nz.co.buggycars.common.WebSpecification
import nz.co.buggycars.pages.CarMakePage
import nz.co.buggycars.pages.CarModelPage
import nz.co.buggycars.pages.HomePage
import nz.co.buggycars.pages.OverallRatingPage

class OverallRatingTest extends WebSpecification {

    def "Navigating to Car make page should succeed"() {
        given: "I am in the home page"
            Selenide.open(appConfig.getWebAppUrl())
            HomePage homePage = HomePage.expect()
        when: "I go to overall ratings page"
            homePage.clickOverAllRating()
            OverallRatingPage overallRatingPage = OverallRatingPage.expect()
        and: "I click on a particular make"
            overallRatingPage.clickOnMake()
        then: "I should go to car make page"
            CarMakePage.expect()
        and: "I return to home page"
            // TODO: Uncomment below code once the Navigation to home page from Make Page is fixed. (JIRA ticket URL here)
//            homePage.goToHomePage()
            Selenide.open(appConfig.getWebAppUrl())
            homePage.isVisible()
    }

    def "Navigating to Car model page  should succeed"() {
        given: "I am in the home page"
            HomePage homePage = HomePage.expect()
        when: "I go to overall ratings page"
            homePage.clickOverAllRating()
            OverallRatingPage overallRatingPage = OverallRatingPage.expect()
        and: "I click on a particular model"
            overallRatingPage.clickOnModel()
        then: "I should go to car model page"
            CarModelPage.expect()
        and: "I return to home page"
            homePage.goToHomePage()
            homePage.isVisible()
    }
}
