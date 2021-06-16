package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddEmployeePage;
import pages.DashBoardPage;
import utils.CommonMethods;
import utils.Constants;
import utils.ExcelReading;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AddEmployeeSteps extends CommonMethods {

    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        DashBoardPage dashBoardPage = new DashBoardPage();
        click(dashBoardPage.PIMOption);
    }

    @When("user clicks on Add employee button")
    public void user_clicks_on_add_employee_button() {
        DashBoardPage dashBoardPage = new DashBoardPage();
        click(dashBoardPage.addEmployeeOption);
    }
    @When("User enters firstname, middlename, and lastname")
    public void user_enters_firstname_middlename_and_lastname() {
        AddEmployeePage add = new AddEmployeePage();
        sendText(add.firstName, "Bob11111");
        sendText(add.middleName, "john");
        sendText(add.lastName, "yesss");
    }
    @When("user enters first name {string} middle name {string} and last name {string}")
    public void user_enters_first_name_middle_name_and_last_name(String firstName, String middleName, String lastName) {
        AddEmployeePage add = new AddEmployeePage();
        sendText(add.firstName, firstName);
        sendText(add.middleName, middleName);
        sendText(add.lastName, lastName);
    }
    @When("user enters {string} {string} and {string} in the application")
    public void user_enters_and_in_the_application(String firstName, String middleName, String lastName) {
        AddEmployeePage add = new AddEmployeePage();
        sendText(add.firstName, firstName);
        sendText(add.middleName, middleName);
        sendText(add.lastName, lastName);
    }

    @When("user clicks on save button option")
    public void user_clicks_on_save_button_option() {
        AddEmployeePage add = new AddEmployeePage();
        click(add.saveBtn);
    }
    @Then("employee added successfully")
    public void employee_added_successfully() {
        System.out.println("employee was added");
    }

    @When("adding multiple employees and verify they are added successfully")
    public void adding_multiple_employees_and_verify_they_are_added_successfully(DataTable employees) {
        List<Map<String,String>> employeeNames = employees.asMaps();
        for (Map<String,String> employeeName: employeeNames){
            String firstNameValue = employeeName.get("firstName");
            String middleNameValue = employeeName.get("middleName");
            String lastNameValue = employeeName.get("lastName");

            AddEmployeePage add = new AddEmployeePage();
            sendText(add.firstName, firstNameValue);
            sendText(add.middleName,middleNameValue);
            sendText(add.lastName, lastNameValue);
            click(add.saveBtn);

            //assertion take it as HW

            DashBoardPage dash = new DashBoardPage();
            click(dash.addEmployeeOption);
        }
    }

    @When("user adds multiple employees from excel file {string} sheet and verify they are added")
    public void user_adds_multiple_employees_from_excel_file_sheet_and_verify_they_are_added(String sheetname) {
        List<Map<String,String>> newemployees = ExcelReading.excelIntoListMap(Constants.TESTDATA_FILEPATH,sheetname);

        DashBoardPage dash = new DashBoardPage();
        AddEmployeePage add = new AddEmployeePage();

        Iterator<Map<String,String>> it = newemployees.iterator();
        while (it.hasNext()){
            Map<String,String> mapNewEmp = it.next();
            sendText(add.firstName, mapNewEmp.get("FirstName"));
            sendText(add.middleName, mapNewEmp.get("MiddleName"));
            sendText(add.lastName, mapNewEmp.get("LastName"));
            click(add.saveBtn);

            //assertion complete in HW
        }
    }
}
