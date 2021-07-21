package API;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.*;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardCodedExamples {
    /**
     * Given - Preparing the request
     * When - making the request/making the call/hitting the endpoint
     * Then - verification/assertions
     */

    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2MjY2MTEwNjksImlzcyI6ImxvY2FsaG9zdCIsImV4" +
            "cCI6MTYyNjY1NDI2OSwidXNlcklkIjoiMjgyNSJ9.RerSqsgF9Gz8qbLFSRcazxcc6uAio4GPix0SviKese8";
    static String employee_id;

    //@Test
    public void sampleTest() {

        RequestSpecification preparedRequest = given().header("Authorization", token)
                .header("Content-Type", "application/json")
                .queryParam("employee_id", "13931");

        Response response = preparedRequest.when().get("/getOneEmployee.php");

        //Printing response using a String() method to convert JSON object to a String and printing using SOP
        System.out.println(response.asString());
    }

    @Test
    public void apostCreateEmployee() {

        RequestSpecification preparedRequest = given().header("Authorization", token)
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"emp_firstname\": \"Moe\",\n" +
                        "  \"emp_lastname\": \"Kalouda\",\n" +
                        "  \"emp_middle_name\": \"Jib\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"1995-07-11\",\n" +
                        "  \"emp_status\": \"Employee\",\n" +
                        "  \"emp_job_title\": \"CEO\"\n" +
                        "}");

        // log().all() will log and print all info being sent with the request

        Response response = preparedRequest.when().post("/createEmployee.php");

        // pretty print does the same as SOP(response.asString())
        //response.prettyPrint();

        // jsonPath() allows us to recieve specific data from a json object - just like an xpath with selenium
        employee_id = response.jsonPath().getString("Employee.employee_id");

        //System.out.println(employee_id);

        //performing assertion
        response.then().assertThat().statusCode(201);

        // Using Hamcrest Matchers class
        response.then().assertThat().body("Message", equalTo("Employee Created"));

        // Write an assertion that verifies that the response body has the name you added
        response.then().assertThat().body("Employee.emp_firstname", equalTo("Moe"));

        // Verifying server
        response.then().assertThat().header("Server", "Apache/2.4.39 (Win64) PHP/7.2.18");
    }

    @Test
    public void bgetCreatedEmployee() {
        RequestSpecification preparedRequest = given().header("Authorization", token)
                .header("Content-Type", "application/json")
                .queryParam("employee_id", employee_id);

        Response response = preparedRequest.when().get("/getOneEmployee.php");

        response.prettyPrint();

        String empID = response.jsonPath().getString("employee.employee_id");

        boolean comparingEmpIDs = empID.contentEquals(employee_id);

        Assert.assertTrue(comparingEmpIDs);

        // Task: Retrieve the first name and assert that the first name is the same as the one you used
        //DO NOT USE HAMCREST MATCHERS

        String firstName = response.jsonPath().getString("employee.emp_firstname");
        Assert.assertTrue(firstName.contentEquals("Moe"));

    }

    //@Test
    public void cgetAllEmployees() {

        RequestSpecification preparedRequest = given().header("Authorization", token)
                .header("Content-Type", "application/json");

        Response response = preparedRequest.when().get("/getAllEmployees.php");

        String allEmployees = response.prettyPrint();

        // creating object of JsonPath class
        JsonPath js = new JsonPath(allEmployees);

        // retrieving number of employees in response body
        int count = js.getInt("Employees.size()");
        System.out.println(count);

        //print out all employee IDs from the response
        for (int i = 0; i < count; i++) {
            String employeeIDs = js.getString("Employees[" + i + "].employee_id");
            //System.out.println(employeeIDs);

            // verify stored employee ID from previous call is in response body
            if (employeeIDs.contentEquals(employee_id)) {
                System.out.println("Employee " + employee_id + " is here");

                // printing out first name of the employee that we created
                String firstName = js.getString("Employees[" + i + "].emp_firstname");

                /*
                 * Printing out the first name of the employee that we created
                 */
                System.out.println("Employee name is "+ firstName);
                break;
            }
        }
    }

    @Test
    public void dPutUpdateCreatedEmployee(){
        /**
         * update the created employee
         */
        RequestSpecification preparedRequest = given().header("Authorization", token)
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"employee_id\": \"" + employee_id + "\",\n" +
                        "  \"emp_firstname\": \"David\",\n" +
                        "  \"emp_lastname\": \"Beckham\",\n" +
                        "  \"emp_middle_name\": \"yoo\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"2020-07-11\",\n" +
                        "  \"emp_status\": \"not employed\",\n" +
                        "  \"emp_job_title\": \"IT Analyst\"\n" +
                        "}");

        Response response = preparedRequest.when().put("/updateEmployees.php");

        response.prettyPrint();
    }
}
