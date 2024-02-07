import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class VaccineFinderTest {
    @Test
    public void VaccineFinderTabUIElementsVerification() {

        WebDriver driver = new ChromeDriver();


        driver.manage().window().maximize();


        driver.get("https://indian-vaccine.web.app/");


        String expectedTitle = "Vaccine Finder | App";
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Page title is correct: " + actualTitle);
        } else {
            System.out.println("Page title is incorrect. Expected: " + expectedTitle + ", Actual: " + actualTitle);
        }


        WebElement ResetCurrentSearch = driver.findElement(By.xpath("//button[@title='Reset Current Search']"));
        WebElement Refresh = driver.findElement(By.xpath("//button[@title='Refresh']//*[name()='svg']"));
        WebElement Notification = driver.findElement(By.xpath("//button[@title='Notification']"));
        WebElement selectState = driver.findElement(By.xpath("//select[@name='selectState']"));
        WebElement selectedDistrict = driver.findElement(By.xpath("//select[@name='selectedDistrict']"));


        if (ResetCurrentSearch.isDisplayed() && Refresh.isDisplayed() && Notification.isDisplayed() && selectState.isDisplayed() & selectedDistrict.isDisplayed()) {
            System.out.println("UI elements are present and visible");
        } else {
            System.out.println("UI elements are not present or visible");
        }


        driver.quit();
    }

    @Test
    public void CovidCasesTabUIElementsVerification() {

        WebDriver driver = new ChromeDriver();


        driver.manage().window().maximize();


        driver.get("https://indian-vaccine.web.app/");
        driver.findElement(By.xpath("//a[@class='nav-link']")).click();

        String expectedTitle = "Vaccine Finder | Total Cases";
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Page title is correct: " + actualTitle);
        } else {
            System.out.println("Page title is incorrect. Expected: " + expectedTitle + ", Actual: " + actualTitle);
        }



        WebElement Refresh = driver.findElement(By.xpath("//button[@class='mt-2 btn btn-outline-info btn-sm']//*[name()='svg']"));
        WebElement selectState = driver.findElement(By.xpath("//select[@name='selectedState']"));
        WebElement selectedDistrict = driver.findElement(By.xpath("//select[@name='selectedDistrict']"));
        WebElement PieChart = driver.findElement(By.xpath("//*[name()='path' and contains(@d,'M11,2V22C5')]"));
        WebElement Text = driver.findElement(By.xpath("//button[@title='Text']"));


        if (PieChart.isDisplayed() && Refresh.isDisplayed() && Text.isDisplayed() && selectState.isDisplayed() & selectedDistrict.isDisplayed()) {
            System.out.println("UI elements are present and visible");
        } else {
            System.out.println("UI elements are not present or visible");
        }


        driver.quit();
    }

    @Test
    public void VaccineFinderTabUIElementsSelection() {

        WebDriver driver = new ChromeDriver();


        driver.manage().window().maximize();


        driver.get("https://indian-vaccine.web.app/");




        WebElement ResetCurrentSearch = driver.findElement(By.xpath("//button[@title='Reset Current Search']"));
        WebElement Refresh = driver.findElement(By.xpath("//button[@title='Refresh']//*[name()='svg']"));
        WebElement Notification = driver.findElement(By.xpath("//button[@title='Notification']"));
        WebElement selectState = driver.findElement(By.xpath("//select[@name='selectState']"));
        WebElement selectedDistrict = driver.findElement(By.xpath("//select[@name='selectedDistrict']"));



        if (ResetCurrentSearch.isEnabled() ) {
            System.out.println("ResetCurrentSearch button is enabled");
        } else {
            System.out.println("ResetCurrentSearch button is not enabled");
        }
        if ( Refresh.isEnabled()) {
            System.out.println("Refresh button is enabled");
        } else {
            System.out.println("Refresh button is not enabled");
        }
        if ( Notification.isEnabled()) {
            System.out.println("Notification button is enabled");
        } else {
            System.out.println("Notification button is not enabled");
        }
        if ( selectState.isEnabled()) {
            System.out.println("selectState drop down is enabled");
        } else {
            System.out.println("selectState drop down is not enabled");
        }
        if ( selectedDistrict.isEnabled()) {
            System.out.println("selectedDistrict drop down is enabled");
        } else {
            System.out.println("selectedDistrict drop down is not enabled");
        }


        driver.quit();


    }
    @Test
    public void CovidCasesTabUIElementsSelection() {

        WebDriver driver = new ChromeDriver();


        driver.manage().window().maximize();


        driver.get("https://indian-vaccine.web.app/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[@class='nav-link']")).click();


        WebElement Refresh = driver.findElement(By.xpath("//button[@class='mt-2 btn btn-outline-info btn-sm']//*[name()='svg']"));

        WebElement selectState = driver.findElement(By.xpath("//select[@name='selectedState']"));
        WebElement selectedDistrict = driver.findElement(By.xpath("//select[@name='selectedDistrict']"));




        if ( Refresh.isEnabled()) {
            System.out.println("Refresh button is enabled");
        } else {
            System.out.println("Refresh button is not enabled");
        }

        if ( selectState.isEnabled()) {
            System.out.println("selectState drop down is enabled");
        } else {
            System.out.println("selectState drop down is not enabled");
        }
        if ( selectedDistrict.isEnabled()) {
            System.out.println("selectedDistrict drop down is enabled");
        } else {
            System.out.println("selectedDistrict drop down is not enabled");
        }

        Select selectedState=new Select(driver.findElement(By.xpath("//select[@name='selectedState']")));
        selectedState.selectByValue("Kerala");


        WebElement selectedStateValue = selectedState.getFirstSelectedOption();


        String actualSelectedStateValue = selectedStateValue.getText();


        String expectedSelectedValue = "Kerala";


        if (actualSelectedStateValue.equals(expectedSelectedValue)) {
            System.out.println("Dropdown value was selected correctly: " + actualSelectedStateValue);
        } else {
            System.out.println("Dropdown value was not selected correctly. Expected: " + expectedSelectedValue
                    + ", Actual: " + actualSelectedStateValue);
        }

        Select selectDistrict=new Select(driver.findElement(By.xpath("//select[@name='selectedDistrict']")));
        selectDistrict.selectByValue("Thrissur");
        WebElement selectedDistrictValue = selectDistrict.getFirstSelectedOption();


        String actualSelectedDistrictValue = selectedDistrictValue.getText();


        String expectedSelectedDistrictValue = "Thrissur";


        if (actualSelectedDistrictValue.equals(expectedSelectedDistrictValue)) {
            System.out.println("Dropdown value was selected correctly: " + actualSelectedDistrictValue);
        } else {
            System.out.println("Dropdown value was not selected correctly. Expected: " + expectedSelectedDistrictValue
                    + ", Actual: " + actualSelectedDistrictValue);
        }





        driver.quit();


    }
    @Test
    public void CovidCasesForSelectedValuesPieChart() {

        WebDriver driver = new ChromeDriver();


        driver.manage().window().maximize();


        driver.get("https://indian-vaccine.web.app/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[@class='nav-link']")).click();




        Select selectedState=new Select(driver.findElement(By.xpath("//select[@name='selectedState']")));
        selectedState.selectByValue("Kerala");


        WebElement selectedStateValue = selectedState.getFirstSelectedOption();


        String actualSelectedStateValue = selectedStateValue.getText();




        Select selectDistrict=new Select(driver.findElement(By.xpath("//select[@name='selectedDistrict']")));
        selectDistrict.selectByValue("Thrissur");
        WebElement selectedDistrictValue = selectDistrict.getFirstSelectedOption();


        String actualSelectedDistrictValue = selectedDistrictValue.getText();




        WebElement State= driver.findElement(By.xpath("//h4[normalize-space()='State - Kerala']"));
        String stateVal=State.getText();
        String DisplayedStateVal="State - "+actualSelectedStateValue;
        if(DisplayedStateVal.equals(stateVal)){
            System.out.println("Covid Cases count for the selectd state is displayed in Pie Chart");
        }
        else {
            System.out.println("Displaying wrong state value");
        }
        WebElement District= driver.findElement(By.xpath("//h4[normalize-space()='District - Thrissur']"));
        String DistrictVal=State.getText();
        String DisplayedDistrictVal="District - "+actualSelectedDistrictValue;
        if(DisplayedStateVal.equals(DistrictVal)){
            System.out.println("Covid Cases count for the selectd District is displayed in Pie Chart");
        }
        else {
            System.out.println("Displaying wrong District value");
        }





        driver.quit();


    }
    @Test
    public void CovidCasesForSelectedValuesText() {

        WebDriver driver = new ChromeDriver();


        driver.manage().window().maximize();


        driver.get("https://indian-vaccine.web.app/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[@class='nav-link']")).click();




        Select selectedState=new Select(driver.findElement(By.xpath("//select[@name='selectedState']")));
        selectedState.selectByValue("Delhi");


        WebElement selectedStateValue = selectedState.getFirstSelectedOption();


        String actualSelectedStateValue = selectedStateValue.getText();




        Select selectDistrict=new Select(driver.findElement(By.xpath("//select[@name='selectedDistrict']")));
        selectDistrict.selectByValue("New Delhi");
        WebElement selectedDistrictValue = selectDistrict.getFirstSelectedOption();


        String actualSelectedDistrictValue = selectedDistrictValue.getText();



        WebElement State= driver.findElement(By.xpath("//h4[normalize-space()='State - Delhi']"));
        String stateVal=State.getText();
        String DisplayedStateVal="State - "+actualSelectedStateValue;
        if(DisplayedStateVal.equals(stateVal)){
            System.out.println("Covid Cases count for the selectd state is displayed in Text Format");
        }
        else {
            System.out.println("Displaying wrong state value");
        }
        WebElement District= driver.findElement(By.xpath("//h4[normalize-space()='District - New Delhi']"));
        String DistrictVal=State.getText();
        String DisplayedDistrictVal="District - "+actualSelectedDistrictValue;
        if(DisplayedStateVal.equals(DistrictVal)){
            System.out.println("Covid Cases count for the selectd District is displayed in Text Format");
        }
        else {
            System.out.println("Displaying wrong District value");
        }




        driver.quit();


    }
    @Test
    public void multiBrowserCapability() {

        WebDriver driverChrome = new ChromeDriver();


        driverChrome.manage().window().maximize();


        driverChrome.get("https://indian-vaccine.web.app/");
        driverChrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driverChrome.findElement(By.xpath("//a[@class='nav-link']")).click();





        driverChrome.quit();

        WebDriver driverEdge = new EdgeDriver();


        driverEdge.manage().window().maximize();


        driverEdge.get("https://indian-vaccine.web.app/");
        driverEdge.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driverEdge.findElement(By.xpath("//a[@class='nav-link']")).click();





        driverEdge.quit();

        driverChrome.quit();

        WebDriver driverFireFox = new FirefoxDriver();


        driverFireFox.manage().window().maximize();


        driverFireFox.get("https://indian-vaccine.web.app/");
        driverFireFox.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driverFireFox.findElement(By.xpath("//a[@class='nav-link']")).click();





        driverFireFox.quit();






    }
}

