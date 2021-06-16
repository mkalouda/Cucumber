package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DashBoardPage;
import pages.EmployeeListPage;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;

public class EmployeeSearchSteps extends CommonMethods {

    @Given("user is logged in with valid admin credentials")
    public void user_is_logged_in_with_valid_admin_credentials() {
        LoginPage loginPage = new LoginPage();
        sendText(loginPage.usernameTextBox, ConfigReader.getPropertyValue("username"));
        sendText(loginPage.passwordTextBox, ConfigReader.getPropertyValue("password"));
        click(loginPage.loginBtn);
    }

    @Given("user navigates to employee list page")
    public void user_navigates_to_employee_list_page() {
        DashBoardPage dashBoardPage = new DashBoardPage();
        click(dashBoardPage.PIMOption);
        click(dashBoardPage.employeeListOption);
    }

    @When("user enters valid employee id")
    public void user_enters_valid_employee_id() {
        EmployeeListPage empListPage = new EmployeeListPage();
        sendText(empListPage.idEmployee, "15518");
    }

    @When("click on search button")
    public void click_on_search_button() {
        EmployeeListPage empListPage = new EmployeeListPage();
        click(empListPage.searchBtn);
    }

    @When("user enters valid employee name")
    public void user_enters_valid_employee_name() {
        EmployeeListPage empListPage = new EmployeeListPage();
        sendText(empListPage.employeeNameField, "hi hello");
    }

    @Then("user see employee information is displayed")
    public void user_see_employee_information_is_displayed() {
        System.out.println("employee info is displayed");
    }
}
