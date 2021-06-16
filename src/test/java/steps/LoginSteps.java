package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.DashBoardPage;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;

import java.util.List;
import java.util.Map;

public class LoginSteps extends CommonMethods {

    @When("user enters valid admin username and login")
    public void user_enters_valid_admin_username_and_login() {
        LoginPage loginPage = new LoginPage();
        sendText(loginPage.usernameTextBox, ConfigReader.getPropertyValue("username"));
        sendText(loginPage.passwordTextBox, ConfigReader.getPropertyValue("password"));
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        LoginPage loginPage = new LoginPage();
        click(loginPage.loginBtn);
    }

    @Then("admin user is successfully logged in")
    public void admin_user_is_successfully_logged_in() {
        DashBoardPage dashBoardPage = new DashBoardPage();
        //Assert.assertTrue(dashBoardPage.welcomeMessage.isDisplayed());
        String expectedText = "Welcome Admin";
        String actualText = dashBoardPage.welcomeMessage.getText();
        Assert.assertEquals("values dont match", expectedText, actualText);
    }

    @When("user enters valid ess username and password")
    public void user_enters_valid_ess_username_and_password() {
        LoginPage loginPage = new LoginPage();
        sendText(loginPage.usernameTextBox, "johnny1234560000");
        sendText(loginPage.passwordTextBox, "Syntax1253!!!!");
    }

    @Then("ess user is successfully logged in")
    public void ess_user_is_successfully_logged_in() {
        DashBoardPage dashBoardPage = new DashBoardPage();
        Assert.assertTrue(dashBoardPage.welcomeMessage.isDisplayed());
    }

    @When("user enters valid username and invalid password")
    public void user_enters_valid_username_and_invalid_password() {
        LoginPage loginPage = new LoginPage();
        sendText(loginPage.usernameTextBox, "Admin");
        sendText(loginPage.passwordTextBox, "Syntax1253!!!!");
    }

    @Then("user sees invalid credentials text on login page")
    public void user_sees_invalid_credentials_text_on_login_page() {
        System.out.println("error message displayed");
    }

    @When("user enters {string} and {string}")
    public void user_enters_and(String username, String password) {
        LoginPage loginPage = new LoginPage();
        sendText(loginPage.usernameTextBox, username);
        sendText(loginPage.passwordTextBox, password);
    }

    @When("{string} is successfully logged in")
    public void is_successfully_logged_in(String firstname) {
        System.out.println("working fine");
    }

    @When("user enters valid username and invalid password and verify the error")
    public void user_enters_valid_username_and_invalid_password_and_verify_the_error(DataTable errordata) {
        List<Map<String, String>> logins = errordata.asMaps();
        for (Map<String, String> login : logins) {
            String usernameValue = login.get("username");
            String passwordValue = login.get("password");
            String errorValue = login.get("errormessage");

            LoginPage loginpage = new LoginPage();
            sendText(loginpage.usernameTextBox,usernameValue);
            sendText(loginpage.passwordTextBox,passwordValue);
            click(loginpage.loginBtn);

            String actual = loginpage.errorMessage.getText();
            Assert.assertEquals("values do not match", errorValue, actual);
            System.out.println("my test case has passed");
        }
    }

    @When("user enters different {string} and {string} and verify the {string} for all the combinations")
    public void user_enters_different_and_and_verify_the_for_all_the_combinations(String username, String password, String error) {
        LoginPage loginPage = new LoginPage();
        sendText(loginPage.usernameTextBox, username);
        sendText(loginPage.passwordTextBox, password);
        click(loginPage.loginBtn);

        String actual = loginPage.errorMessage.getText();
        Assert.assertEquals("Error message values do not match", error,actual);
    }
}
