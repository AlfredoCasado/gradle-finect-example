package finect

import spock.lang.*
import geb.*
import geb.spock.*

class FinectLoginSpec extends GebReportingSpec {

    def "can login in finect with valid credentilas"() {
        given: to FinectLoginPage

        when: login('casado.alfredo@gmail.com','acasado1978')

        then: at FinectUserHomePage
    }

    def "show error message when the password is not correct"() {
        given: to FinectLoginPage

        when: login('casado.alfredo@gmail.com','badPassword')

        then: showErrorMessageToTheUser()
    }

    def "show error message when the user not exits"() {
        given: to FinectLoginPage

        when: login('badUser','badPassword')

        then: showErrorMessageToTheUser()
    }

    def "when introduces 3 times a bad password a captcha is shown to the user"() {
        given: to FinectLoginPage

        when: 4.times { login('jmoscardo@unience.com','badPassword') }

        then: showCaptchToTheUser()  
    }

}