package steps;

import io.cucumber.java.en.Given;
import objects.request.authenticate.LoginRequest;
import org.testng.Assert;
import services.LoginService;

public class AuthenticationSteps extends BaseSteps {
    LoginService loginService = new LoginService();

    @Given("I login to Rawal by using email: {string} and password: {string}")
    public void loginToRawalWithValidUser(String email, String password) {
        LoginRequest loginRequest = new LoginRequest(email, password);
        String token = loginService.getToken(loginRequest);
        scenarioContext.setContext("TOKEN", token);
        Assert.assertTrue(loginService.verifyToken(token), "Token invalid");
    }
}
