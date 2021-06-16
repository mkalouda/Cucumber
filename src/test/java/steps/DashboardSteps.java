package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.DashBoardPage;
import utils.CommonMethods;

import java.util.ArrayList;
import java.util.List;

public class DashboardSteps extends CommonMethods {

    @Then("verify the following tabs on dashboard")
    public void verify_the_following_tabs_on_dashboard(DataTable dataTable) {
        List<String> expectedTabs = dataTable.asList();
        DashBoardPage dash = new DashBoardPage();
        List<String> actualTabs = new ArrayList<>();
        for (WebElement actualTab: dash.dashboardTabs){
            actualTabs.add(actualTab.getText());
        }
        System.out.println(expectedTabs);
        System.out.println(actualTabs);
        Assert.assertTrue(expectedTabs.equals(actualTabs));
        System.out.println("my test case passed");
    }
}
