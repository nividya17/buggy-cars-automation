package nz.co.buggycars.tests

import com.codeborne.selenide.Selenide
import nz.co.buggycars.common.WebSpecification
import nz.co.buggycars.pages.CarMakePage
import nz.co.buggycars.pages.CarModelPage
import nz.co.buggycars.pages.HomePage
import nz.co.buggycars.pages.OverallRatingPage

class HomePageTest extends WebSpecification {

    def "Home page should load properly"() {
        when: "When I open home page"
            Selenide.open(appConfig.getWebAppUrl())
        then: "I see homepage is loaded properly"
            HomePage.expect()
    }

    def "Popular Make page should load properly"() {
        given: "I am in the home page"
            HomePage homePage = HomePage.expect()
        when: "I click on the popular make image"
            homePage.clickPopularMake()
        then: "I should land in  popular car make page"
            CarMakePage.expect()
        and: "I return back to home page"
            // TODO: Uncomment below code once the Navigation to home page from Make Page is fixed. (JIRA ticket URL here)
//            homePage.goToHomePage()
            Selenide.open(appConfig.getWebAppUrl())
    }

    def "Popular model page should load properly"() {
        given: "I am in the home page"
            HomePage homePage = HomePage.expect()
        when: "I click on the popular model car image"
            homePage.clickPopularModel()
        then: "I should land in the popular model page"
            CarModelPage.expect()
        and: "I return back to home page"
            homePage.goToHomePage()
    }

    def "Overall rating page loading"() {
        given: "I am in the home page"
            HomePage homePage = HomePage.expect()
        when: "I click on the overall rating car image"
            homePage.clickOverAllRating()
        then: "I should land in the rating car image"
            OverallRatingPage.expect()
        and: "I return back to home page"
            homePage.goToHomePage()
    }
}
