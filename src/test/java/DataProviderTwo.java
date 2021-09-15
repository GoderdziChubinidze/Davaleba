import org.testng.annotations.DataProvider;

public class DataProviderTwo {

    @DataProvider(name = "two")
    public Object[][] getData(){
        Object[][] data ={{"automation","Auto@2"}};
        return data;

    }
}
