package steps;

import io.cucumber.java.en.Then;
import utils.DbUtils;
import utils.Globalvariables;

import java.util.List;
import java.util.Map;

public class DbSteps {

    @Then("query the HRMS database")
    public void query_the_hrms_database() {
        String query="select emp_firstname, emp_middle_name,emp_lastname " +
                "from hs_hr_employees where emp_number="+ Globalvariables.empId;
        List<Map<String,String>> tableDataAsList = DbUtils.getTableDataAsList(query);
        Globalvariables.dbFirstName=tableDataAsList.get(0).get("emp_firstname");
        Globalvariables.dbMiddleName=tableDataAsList.get(0).get("emp_middle_name");
        Globalvariables.dbLastName=tableDataAsList.get(0).get("emp_lastname");
    }

}
