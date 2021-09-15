import org.testng.annotations.DataProvider;

public class DataProviderThree {

    @DataProvider(name = "three")
    public Object[] getData(){
        String[][] data ={{"automation",""}};
        return data;

    }
}
