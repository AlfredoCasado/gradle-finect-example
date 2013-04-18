package finect

import geb.*
import static util.UrlBuilder.*

class FinectLoginPage extends Page {
    
    static url = buildUrl("/login")
    static at = { title.contains("Sign in")}

    static content = {
    	username {$("input[name='j_username']").last()}
    	password {$("input[name='j_password']").last()}

    	signInButton {$("input[name='input']").last()}

    	loginErrorMessage {$('.error-message').last()}

    	captcha {$('#recaptcha_table')}
    }

    def login(user, pass) {
        username.value user
        password.value pass
        signInButton.click()
    }

    def showErrorMessageToTheUser() {
        loginErrorMessage.text().contains("Check username or password")
    }

    def showCaptchToTheUser() {
        captcha != null
    }

}