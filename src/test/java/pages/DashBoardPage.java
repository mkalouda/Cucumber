package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import java.util.List;

public class DashBoardPage extends CommonMethods {

    @FindBy(id = "welcome")
    public WebElement welcomeMessage;

    @FindBy(id = "menu_pim_viewPimModule")
    public WebElement PIMOption;

    @FindBy(linkText = "Add Employee")
    public WebElement addEmployeeOption;

    @FindBy(linkText = "Employee List")
    public WebElement employeeListOption;

    @FindBy(xpath = "//div[@class ='menu']/ul/li")
    public List<WebElement> dashboardTabs;

    public DashBoardPage(){
        PageFactory.initElements(driver,this);
    }
}
