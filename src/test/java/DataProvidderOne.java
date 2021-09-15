import org.testng.annotations.DataProvider;

public class DataProvidderOne {

    @DataProvider(name = "one")
    public Object[][] getData() {
        Object[][] data = {{"automation", "Automation@!@123"}};
        return data;
    }

}



