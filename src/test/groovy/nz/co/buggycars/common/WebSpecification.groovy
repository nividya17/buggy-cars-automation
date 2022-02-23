package nz.co.buggycars.common

import nz.co.buggycars.configuration.AppConfig
import spock.lang.Shared
import spock.lang.Specification

class WebSpecification extends Specification {

    @Shared
    AppConfig appConfig

    def setupSpec() {
        appConfig = AppConfig.INSTANCE
        DriverUtils.initialiseWebDriver()
    }

    def cleanupSpec() {
        DriverUtils.closeWebDriver()
    }
}
