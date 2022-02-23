package nz.co.buggycars.common

import com.codeborne.selenide.Configuration
import com.codeborne.selenide.WebDriverRunner

class DriverUtils {

    private static final resolution = "1280x960"

    static void initialiseWebDriver() {

        Configuration.headless = false
        Configuration.browserSize = resolution
        WebDriverRunner.clearBrowserCache()
    }


    static void closeWebDriver() {
        WebDriverRunner.closeWebDriver()
    }

    static void browserRefresh() {
        WebDriverRunner.getWebDriver().navigate().refresh()
    }
}
